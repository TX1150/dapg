package com.tigxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CreateData {
    @ResponseBody
    @RequestMapping(value = "/ajax")
    public Map<String,Object> ajax(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=UTF-8");
        String  page    = request.getParameter("page");
        System.out.println("page="+page);
        String url="http://localhost:8080/";
        List<String> list   = new ArrayList<>();
        Map<String,Object> map  = new HashMap<>();
        for(int i=0;i<10;i++){
            list.add(url+(Integer.parseInt(page)*10+i)+".jpg");
        }
        map.put("data", list);
        map.put("eof", true);
        if(page.equals("7")){
            map.put("eof",false);
        }
        return map;
    }
}
