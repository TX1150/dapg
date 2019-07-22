package com.tigxu.tool;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/***
 * 阿里云资源
 */
public class ResourceOSS implements ResourceOperation{
    private OSS     ossClient;
    private String  bucketName;
    public ResourceOSS(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.ossClient=new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        this.bucketName=bucketName;
    }

    @Override
    public String getUrl(String path) {
        URL url = ossClient.generatePresignedUrl(this.bucketName, path, new Date(new Date().getTime() + 3600 * 1000));
        return url.toString();
    }

    @Override
    public Integer upload(String path, InputStream in) {
        if(path.charAt(0)=='/'){
            path=path.substring(1);
        }
        ossClient.putObject(this.bucketName, path, in);
        return 0;
    }
}
