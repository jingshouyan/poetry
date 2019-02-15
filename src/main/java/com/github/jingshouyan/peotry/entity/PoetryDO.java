package com.github.jingshouyan.peotry.entity;

import com.github.jingshouyan.jdbc.comm.annotaion.*;
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
    @Column(length = 20)
    private String author;
    @Column(length = 4000)
    private String content;
}
