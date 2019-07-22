package com.tigxu.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.tigxu.mapper.Mapper;
import com.tigxu.tool.ResourceOperation;
import com.tigxu.tool.Supper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Date;

/***
 * 返回页面
 */
@Controller
public class Index extends Supper {
    /**
     * 返回首页
     * @return
     */
    @RequestMapping("/")
    public String   index(HttpServletRequest request){
        return "index";
    }
    @RequestMapping("/upresume")
    public String upResume(HttpServletRequest request){
        request.setAttribute("path", "resume");
        return "upload/upload";
    }
    @RequestMapping("/logins")
    public String   login(){
        return "login";
    }
}
