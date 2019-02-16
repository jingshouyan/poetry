package com.github.jingshouyan.peotry.dao;

import com.github.jingshouyan.jdbc.core.dao.BaseDao;
import com.github.jingshouyan.peotry.entity.AuthorDO;

import java.util.Collection;
import java.util.Map;

/**
 * @author jingshouyan
 * #date 2019/2/15 18:52
 */

public interface AuthorDao extends BaseDao<AuthorDO> {
    Map<String,Long> authorMap(Collection<String> authorNames, String dynasty);
}
