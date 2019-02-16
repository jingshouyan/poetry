package com.github.jingshouyan.peotry.impo;

import com.github.jingshouyan.jrpc.base.util.json.JsonUtil;
import com.github.jingshouyan.peotry.dao.AuthorDao;
import com.github.jingshouyan.peotry.entity.AuthorDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jingshouyan
 * #date 2019/2/15 19:58
 */
@Component
public class AuthorImport implements Import {

    @Autowired
    private AuthorDao authorDao;


    @Override
    public void action(String filename, String json) {
        String[] ss = filename.split("\\.");
        String dynasty = ss[1];
        List<AuthorDO> authors = JsonUtil.toList(json,AuthorDO.class);
        authors.forEach(authorDO -> authorDO.setDynasty(dynasty));
        authorDao.batchInsert(authors);
    }
}
