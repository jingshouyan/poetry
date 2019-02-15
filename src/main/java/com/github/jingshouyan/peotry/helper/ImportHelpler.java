package com.github.jingshouyan.peotry.helper;

import com.github.jingshouyan.peotry.dao.ImportRecordDao;
import com.github.jingshouyan.peotry.impo.factory.ImportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jingshouyan
 * #date 2019/2/15 19:08
 */
@Component
public class ImportHelpler {

    @Autowired
    private ImportRecordDao importRecordDao;
    @Autowired
    private ImportFactory factory;






}
