package com.tigxu.tool;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/***
 * 自动同步本地文件到云端
 */
public class AutomaticSynchronization extends  Supper{
    private InputStream     in;

    private String          localPath;
    public void start(){
        syn(new File(this.localPath));
    }
    /**
     * 同步本地文件
     * @param path
     */
    protected void syn(File path){
        if(path.isFile()){
            try {
                in  = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String  hash    = Tool.hash(in);
            if(mapper.selectOne("select uid from t_file_info where hash='"+hash+"'")==null){
                //获取相对目录的url
                String  url = path.getAbsolutePath().substring(localPath.lastIndexOf('\\')+1);
                String  name    = path.getName();
                resource.upload(url.replaceAll("\\\\","/"),in);
                mapper.insert("insert into t_file_info(uid,hash,name,path,type,size,uptime,isdelete) "+
                        "values('"+Tool.getUUID()+"','"+hash+"','"+
                        name.substring(0,name.lastIndexOf('.'))+
                        "','"+url+
                        "','"+name.substring(name.lastIndexOf('.')+1)+"',"+
                        path.length()+",CURRENT_TIMESTAMP(),0)");
           }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(path.isDirectory()){
            for(File fpath:path.listFiles()){
                syn(fpath);
            }

        }
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}
