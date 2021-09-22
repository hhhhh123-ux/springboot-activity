package com.example.springboot_activiti.common.utils.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;

@Slf4j
public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //如果文件存在就先删除了
        File ifFile = new File(filePath + File.separator + fileName);
        if (ifFile.exists()) {
            log.debug("File is exists!");
            ifFile.delete();
        }
        //然后再写文件
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath + File.separator + fileName);
            out.write(file);
        } catch (Exception e) {
            log.error("Error:", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void File(byte[] file, String filePath, String fileName) throws Exception {
        File fileP=new File(filePath);
        if(!fileP.exists()){
            fileP.mkdirs();
        }



    }

}
