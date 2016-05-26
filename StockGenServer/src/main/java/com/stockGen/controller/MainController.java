package com.stockGen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/26.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(value = "sys_command")
    public String sysCommand(HttpServletRequest request){

        return "index";
    }
}
