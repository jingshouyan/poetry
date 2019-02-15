package com.github.jingshouyan.peotry.entity;

import com.github.jingshouyan.jdbc.comm.annotaion.Column;
import com.github.jingshouyan.jdbc.comm.annotaion.Key;
import com.github.jingshouyan.jdbc.comm.annotaion.Table;
import com.github.jingshouyan.jdbc.comm.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jingshouyan
 * #date 2019/2/15 19:35
 */
@Table("T_IMPORT_RECORD")
@Data
@EqualsAndHashCode(callSuper = false)
public class ImportRecordDO extends BaseDO {
    @Key@Column(length = 100)
    private String fileName;
}
