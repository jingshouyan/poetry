package com.github.jingshouyan.peotry.helper;

import com.hankcs.hanlp.HanLP;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author jingshouyan
 * #date 2019/2/15 21:52
 */
@Component
public class FileHelper {

    @SneakyThrows
    public String readData(String filename) {
        File file = new File(filename);
        return FileUtils.readFileToString(file,"UTF-8");
    }
    @SneakyThrows
    public String readData(File file) {
        String data = FileUtils.readFileToString(file,"UTF-8");
        data = HanLP.convertToSimplifiedChinese(data);
        return data;
    }

    @SneakyThrows
    public void listFile(String path, Consumer<File> consumer) {
        File file = new File(path);
        String[] extensions = new String[] {"json"};
        Iterator<File> iterator = FileUtils.iterateFiles(file, extensions, true);
        while (iterator.hasNext()){
            File f = iterator.next();
            consumer.accept(f);
        }
    }

    public static void main(String[] args) {
        FileHelper fileHelper = new FileHelper();
//        String data = fileHelper.readData("D:\\workspace-python\\chinese-poetry\\json\\poet.song.1000.json");
//        System.out.println(data);
        fileHelper.listFile("D:\\workspace-python\\chinese-poetry",System.out::println);
    }
}
