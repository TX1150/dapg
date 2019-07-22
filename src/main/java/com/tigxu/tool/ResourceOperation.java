package com.tigxu.tool;

import java.io.InputStream;

/***
 * 资源操作
 */
public interface ResourceOperation {
    public String   getUrl(String path);
    public Integer  upload(String path,InputStream in);
}
