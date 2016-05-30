package com.stockGen.controller;

import com.stockGen.xml.util.XmlParser;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "get_Tree_data")
    @ResponseBody
    public String getTreeNode(HttpServletRequest request){
        try {
            Map<String, Object> data = XmlParser.parseToMap("classpath:menu.xml");
            Map<String, Object> treeViewData = new HashMap<String, Object>();
            treeViewData.put("data",data.get("items"));
            JSONObject json = JSONObject.fromObject(treeViewData);
            String treeNode = json.toString();
            return json.toString();
        }catch (DocumentException e){
            e.printStackTrace();
            return "0";
        }
    }
}
