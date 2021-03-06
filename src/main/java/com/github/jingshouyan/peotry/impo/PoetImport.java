package com.github.jingshouyan.peotry.impo;

import com.github.jingshouyan.jdbc.comm.bean.Condition;
import com.github.jingshouyan.jdbc.comm.util.ConditionUtil;
import com.github.jingshouyan.jrpc.base.util.json.JsonUtil;
import com.github.jingshouyan.peotry.constant.PoetryConstant;
import com.github.jingshouyan.peotry.dao.AuthorDao;
import com.github.jingshouyan.peotry.dao.PoetryDao;
import com.github.jingshouyan.peotry.dto.PoetDTO;
import com.github.jingshouyan.peotry.entity.AuthorDO;
import com.github.jingshouyan.peotry.entity.PoetryDO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jingshouyan
 * #date 2019/2/15 21:04
 */
@Component
public class PoetImport implements Import, PoetryConstant {
    @Autowired
    private PoetryDao poetryDao;
    @Autowired
    private AuthorDao authorDao;
    @Override
    public void action(String filename, String json) {
        String[] ss = filename.split("\\.");
        String type = ss[0];
        String dynasty = ss[1];
        List<PoetDTO> poets = JsonUtil.toList(json, PoetDTO.class);
        Set<String> authors = poets.stream()
                .map(PoetDTO::getAuthor)
                .collect(Collectors.toSet());
        Map<String,Long> map = authorDao.authorMap(authors, dynasty);
        List<PoetryDO> poetries = poets.stream()
                .map(poet -> {
                    PoetryDO poetry = new PoetryDO();
                    poetry.setAuthorId(map.get(poet.getAuthor()));
                    poetry.setAuthor(poet.getAuthor());
                    poetry.setDynasty(dynasty);
                    poetry.setType(type);
                    poetry.setTitle(poet.getTitle());
                    String content = poet.getParagraphs().stream().collect(Collectors.joining());
                    content = content.replace("，"," ， ");
                    content = content.replace("。"," 。 ");
                    content = " " +content;
                    poetry.setContent(content);
                    return poetry;
                }).collect(Collectors.toList());
        List<List<PoetryDO>> sub = Lists.partition(poetries,BATCH_SIZE);
        sub.parallelStream().forEach(poetryDao::batchInsert);
    }

}
