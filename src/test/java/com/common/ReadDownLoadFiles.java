package com.common;


import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ReadDownLoadFiles {
    private static int count = 0;
    private static Logger log = Logger.getLogger(ReadDownLoadFiles.class);


    public static ArrayList<String> getDownLoadFilesName(){
        ArrayList<String> filesname = new ArrayList<String>();
        File downloadfilepath = new File("src\\test\\java\\com\\downloadfiles");
        String downloadsPath = downloadfilepath.getAbsolutePath().toString();
        File file = new File(downloadsPath);
        File[] tempLists = file.listFiles();
        for(int i = 0 ; i < tempLists.length; i ++){
            log.info("文件名：" + tempLists[i].getName());
            if (tempLists[i].isFile()){
                filesname.add(tempLists[i].getName().toString());
            }
            if (tempLists[i].isDirectory()){
                System.out.println("目录");
            }
        }
        return filesname;
    }


    public static ArrayList<String> getDownLoadFilesPath(){
        ArrayList<String> filespath = new ArrayList<String>();
        File downloadfilepath = new File("src\\test\\java\\com\\downloadfiles");
        String downloadsPath = downloadfilepath.getAbsolutePath().toString();
        File file = new File(downloadsPath);
        File[] tempLists = file.listFiles();
        for(int i = 0 ; i < tempLists.length; i ++){
            log.info("文件名：" + tempLists[i].getName());
            if (tempLists[i].isFile()){
                filespath.add(tempLists[i].toString());
            }
            if (tempLists[i].isDirectory()){
                System.out.println("目录");
            }
        }
        return filespath;
    }




    public  void refreshFileList() {
        File downloadfilepath = new File("src\\test\\java\\com\\downloadfiles");
        String downloadsPath = downloadfilepath.getAbsolutePath().toString();
        File dir = new File(downloadsPath);
        File[] files = dir.listFiles();
        if (files == null)
        {
            System.out.println("该目录下没有任何一个文件！");
            return;
        }
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
            count++;
        }
    }

    public static void main(String[] args) {
        ReadDownLoadFiles r = new ReadDownLoadFiles();
        r.refreshFileList();
    }
}
