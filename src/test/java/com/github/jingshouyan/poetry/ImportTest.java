package com.github.jingshouyan.poetry;

import com.github.jingshouyan.peotry.PoetryApp;
import com.github.jingshouyan.peotry.helper.ImportHelpler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jingshouyan
 * #date 2019/2/15 22:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PoetryApp.class)
@Slf4j
public class ImportTest {

    @Autowired
    private ImportHelpler importHelpler;
    @Test
    public void importShi() {
        importHelpler.importData("D:\\work-python\\chinese-poetry\\json");
    }
}
