package com.github.jingshouyan.peotry.dao.impl;

import com.github.jingshouyan.jdbc.comm.bean.Condition;
import com.github.jingshouyan.jdbc.comm.util.ConditionUtil;
import com.github.jingshouyan.jdbc.core.dao.impl.BaseDaoImpl;
import com.github.jingshouyan.peotry.dao.AuthorDao;
import com.github.jingshouyan.peotry.entity.AuthorDO;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author jingshouyan
 * #date 2019/2/15 18:53
 */
@Repository
public class AuthorDaoImpl extends BaseDaoImpl<AuthorDO> implements AuthorDao {


    @Override
    public Map<String,Long> authorMap(Collection<String> authorNames, String dynasty) {
        List<Condition> conditions = ConditionUtil.newInstance()
                .field("name").in(authorNames)
                .field("dynasty").eq(dynasty)
                .conditions();
        List<AuthorDO> authors = query(conditions);
        Map<String,Long> map = Maps.newHashMap();
        for(AuthorDO author: authors) {
            map.put(author.getName(),author.getId());
        }
        return map;
    }
}
