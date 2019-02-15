package com.github.jingshouyan.peotry.helper;

import com.github.jingshouyan.peotry.dao.ImportRecordDao;
import com.github.jingshouyan.peotry.impo.Import;
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
    @Autowired
    private FileHelper fileHelper;


    public void importData(String path) {
        fileHelper.listFile(path,file -> {
            String filename = file.getName();
            boolean isImport = importRecordDao.find(filename).isPresent();
            if(!isImport) {
                String[] ss = filename.split("\\.");
                String type = ss[0];
                Import imp = factory.getImport(type);
                if(imp != null) {
                    String data = fileHelper.readData(file);
                    imp.action(filename,data);
                }
            }

        });
    }



}
