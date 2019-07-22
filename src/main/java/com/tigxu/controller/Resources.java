package com.tigxu.controller;

import com.tigxu.tool.AutomaticSynchronization;
import com.tigxu.tool.ResourceOperation;
import com.tigxu.tool.Supper;
import com.tigxu.tool.Tool;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/***
 * 静态资源处理
 */
@Controller
public class Resources extends Supper {
    /**
     * 静态资源重定向
     * @param request
     * @return
     */
    @RequestMapping("/static/**")
    public String staticResources(HttpServletRequest request){
        return "redirect:"+resource.getUrl(request.getRequestURI().substring(1));
    }

    @RequestMapping(value = "/upload/**",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> upload(HttpServletRequest request, MultipartFile file){
        String  hash        = null;
        String  url         = null;
        String  fileName    = file.getOriginalFilename();
        String  fileType    = fileName.substring(fileName.lastIndexOf('.')+1);
        Long    fileSize    = file.getSize();

        fileName=fileName.substring(0,fileName.lastIndexOf('.'));

        try {
            hash    = Tool.hash(file.getInputStream());
            url     = request.getRequestURI()+"/"+hash+"."+fileType;
            url     = url.replaceAll("upload","static");
            resource.upload(url,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        url     = url.substring(url.indexOf("static/"));
        mapper.insert("insert into t_file_info(uid,hash,name,path,type,size,uptime,isdelete) "+
                "values('"+Tool.getUUID()+"','"+hash+"','"+fileName+
                "','"+url+"','"+fileType+"',"+fileSize+",CURRENT_TIMESTAMP(),0)");

        Map<String, Object> map	=  new HashMap<String, Object>();
        map.put("code","000");
        map.put("msg", "ok");
        map.put("url", url);
        return map;
    }


}
