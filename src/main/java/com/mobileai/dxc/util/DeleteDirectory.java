package com.mobileai.dxc.util;

import java.io.File;

public class DeleteDirectory {
    /**
     * 删除目录以及目录下的文件
     * @param   sPath 被删除目录的路径
     * @return  目录删除成功返回true，否则返回false
     */



    /**




     * 删除单个文件




     * @param   sPath 被删除文件path




     * @return 删除成功返回true，否则返回false




     */

    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    public static boolean deleteDirectory(String sPath) {
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            }
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

}
