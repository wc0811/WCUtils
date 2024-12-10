package com.yp.wcUtil;

import java.io.File;

public class FileUtils {
    //判断文件是否已经存在
    public static boolean isFileExist(String filename) {
        File file = new File(filename);
//        File file = new File(SDPath + filename);
        return file.exists();
    }

    // 递归删除文件及文件夹
    public static boolean delete(File file) {
        if (file.isFile()) {
            file.delete();
            return true;
        }

        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                file.delete();
                return true;
            }

            for (int i = 0; i < childFiles.length; i++) {
                delete(childFiles[i]);
            }
            return file.delete();
        }
        return false;
    }

}
