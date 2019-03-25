//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipFileUtils {
    private static Logger logger = LoggerFactory.getLogger(ZipFileUtils.class);
    private static final int BUFFER_SIZE = 2048;
    public static final String encoding = "UTF-8";
    private static String FOLDER_NAME = "";

    public ZipFileUtils() {
    }

    public static void toZip(String path, String folderName, OutputStream outputStream) throws Exception {
        FOLDER_NAME = folderName;
        ZipOutputStream zipOutputStream = null;

        try {
            File file = new File(path);
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream));
            String base = file.getName();
            compressZip(zipOutputStream, file, base);
        } catch (Exception var13) {
            throw new RuntimeException("zip error:" + var13.getMessage());
        } finally {
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.closeEntry();
                    zipOutputStream.close();
                } catch (IOException var12) {
                    var12.printStackTrace();
                }
            }

        }

    }

    public static void compressZip(ZipOutputStream zipOutputStream, File file, String base) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            File[] var4 = files;
            int var5 = files.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                File fi = var4[var6];
                if (fi.isDirectory()) {
                    compressZip(zipOutputStream, fi, base + File.separator + fi.getName());
                } else {
                    zip(zipOutputStream, fi, base);
                }
            }
        } else {
            zip(zipOutputStream, file, base);
        }

    }

    public static void zip(ZipOutputStream zipOutputStream, File file, String base) throws IOException, FileNotFoundException {
        if (base.equals(FOLDER_NAME)) {
            base = "";
        } else {
            base = base.replace(FOLDER_NAME + File.separator, "").trim() + File.separator;
        }

        ZipEntry zipEntry = new ZipEntry(new String((base + file.getName()).getBytes(), "UTF-8"));
        zipOutputStream.putNextEntry(zipEntry);
        byte[] buf = new byte[2048];
        FileInputStream inputStream = new FileInputStream(file);

        int len;
        while((len = inputStream.read(buf)) != -1) {
            zipOutputStream.write(buf, 0, len);
        }

        zipOutputStream.closeEntry();
        inputStream.close();
    }

    public static void delFolder(String folderPath) {
        try {
            deleteAllFile(folderPath);
            File file = new File(folderPath);
            file.delete();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static boolean deleteAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        } else if (!file.isDirectory()) {
            return flag;
        } else {
            String[] tempList = file.list();
            File temp = null;

            for(int i = 0; i < tempList.length; ++i) {
                if (path.endsWith(File.separator)) {
                    temp = new File(path + tempList[i]);
                } else {
                    temp = new File(path + File.separator + tempList[i]);
                }

                if (temp.isFile()) {
                    temp.delete();
                }

                if (temp.isDirectory()) {
                    deleteAllFile(path + "/" + tempList[i]);
                    delFolder(path + "/" + tempList[i]);
                    flag = true;
                }
            }

            return flag;
        }
    }
}
