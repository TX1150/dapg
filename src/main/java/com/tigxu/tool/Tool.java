package com.tigxu.tool;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Tool {
    /**
     * 计算文件MD5
     * @param in
     * @return
     */
    public static String hash(InputStream in) {
        try {
            return DigestUtils.md5Hex(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算字符串MD5
     * @param str
     * @return
     */
    public static String hash(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * 生成uuid
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    List<String> list;
    @Test
    public void test(){
        String  files ="D:\\code\\读写文件\\读写文件\\main.c";
        File    file    = new File(files);
        System.out.println(file.getAbsolutePath().replaceAll("\\\\", "/"));
    }
    public void as(File file){
        if(file.isFile()){
            list.add(file.getAbsolutePath());
        }
        if(file.isDirectory()){
            if(file.listFiles().length==0){
                list.add(file.getAbsolutePath());
            }else{
                for(File f:file.listFiles()){
                    as(f);
                }
            }
        }
    }
}
