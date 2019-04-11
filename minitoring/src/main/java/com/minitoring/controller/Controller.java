package com.minitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minitoring.mapper.Mapper;
import com.minitoring.pojo.User;
// Controller注解用于指示该类是一个控制器，可以同时处理多个请求动作
@org.springframework.stereotype.Controller

@RequestMapping("show")//请求地址映射
public class Controller{
    @Autowired//对类成员变量、方法及构造函数进行标注，完成自动装配的工作
    private Mapper mapper;
    /**
     * 地址：http://localhost:8080/show/all
     */
    @RequestMapping("all")//请求地址映射
    @ResponseBody//用于将Controller的方法返回的对象，以JSON格式写入HTTP相应正文
    public List<User> selectUsers() {
        List<User> list = mapper.listAllUser();
        return list;
    }
}

