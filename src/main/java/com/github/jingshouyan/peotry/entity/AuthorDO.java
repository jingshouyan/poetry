package com.github.jingshouyan.peotry.entity;

import com.github.jingshouyan.jdbc.comm.Constant;
import com.github.jingshouyan.jdbc.comm.annotaion.Column;
import com.github.jingshouyan.jdbc.comm.annotaion.Key;
import com.github.jingshouyan.jdbc.comm.annotaion.Table;
import com.github.jingshouyan.jdbc.comm.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jingshouyan
 * #date 2019/2/15 18:27
 */
@Table("T_AUTHOR")
@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorDO extends BaseDO {

    @Key
    private Long id;
    @Column(length = 100,index = true)
    private String name;
    @Column(length = 50)
    private String dynasty;
    @Column(length = Constant.VARCHAR_MAX_LENGTH)
    private String desc;

}
