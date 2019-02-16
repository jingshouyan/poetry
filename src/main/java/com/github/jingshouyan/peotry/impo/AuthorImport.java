package com.github.jingshouyan.peotry.impo;

import com.github.jingshouyan.jrpc.base.util.json.JsonUtil;
import com.github.jingshouyan.peotry.constant.PoetryConstant;
import com.github.jingshouyan.peotry.dao.AuthorDao;
import com.github.jingshouyan.peotry.entity.AuthorDO;
import com.github.jingshouyan.peotry.helper.ExecHelper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jingshouyan
 * #date 2019/2/15 19:58
 */
@Component
public class AuthorImport implements Import, PoetryConstant {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private ExecHelper execHelper;

    @Override
    public void action(String filename, String json) {
        String[] ss = filename.split("\\.");
        String dynasty = ss[1];
        List<AuthorDO> authors = JsonUtil.toList(json,AuthorDO.class);
        authors.forEach(authorDO -> authorDO.setDynasty(dynasty));
        List<List<AuthorDO>> sub = Lists.partition(authors,BATCH_SIZE);
        sub.parallelStream()
                .forEach(as -> {
                    List<String> names = as.stream().map(AuthorDO::getName).collect(Collectors.toList());
                    Map<String,Long> map = authorDao.authorMap(names,dynasty);
                    List<AuthorDO> author4Insert = as.stream()
                            .filter(author -> !map.containsKey(author.getName()))
                            .collect(Collectors.toList());
                    authorDao.batchInsert(author4Insert);
                });
    }
}
