package com.github.jingshouyan.peotry.entity;

import com.github.jingshouyan.jdbc.comm.Constant;
import com.github.jingshouyan.jdbc.comm.annotaion.Column;
import com.github.jingshouyan.jdbc.comm.annotaion.Index;
import com.github.jingshouyan.jdbc.comm.annotaion.Key;
import com.github.jingshouyan.jdbc.comm.annotaion.Table;
import com.github.jingshouyan.jdbc.comm.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jingshouyan
 * #date 2019/2/15 18:43
 */
@Table("T_POETRY")
@Index("authorId")
@Data
@EqualsAndHashCode(callSuper = false)
public class PoetryDO extends BaseDO {
    @Key
    private Long Id;

    private Long authorId;
    @Column(length = 100)
    private String author;
    @Column(length = 50)
    private String dynasty;
    @Column(length = 50)
    private String type;
    @Column(length = 1000)
    private String title;
    @Column(length = Constant.VARCHAR_MAX_LENGTH)
    private String content;
}
