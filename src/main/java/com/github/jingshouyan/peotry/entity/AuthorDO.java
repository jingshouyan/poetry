package com.github.jingshouyan.peotry.entity;

import com.github.jingshouyan.jdbc.comm.annotaion.Column;
import com.github.jingshouyan.jdbc.comm.annotaion.Key;
import com.github.jingshouyan.jdbc.comm.annotaion.Table;
import com.github.jingshouyan.jdbc.comm.entity.BaseDO;
import lombok.Data;

/**
 * @author jingshouyan
 * #date 2019/2/15 18:27
 */
@Table("T_AUTHOR")
@Data
public class AuthorDO extends BaseDO {

    @Key
    private Long id;
    @Column(length = 20,index = true)
    private String name;
    @Column(length = 1000)
    private String desc;

}
