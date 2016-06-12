package com.stockGen.controller;

import com.stockGen.xml.util.XmlParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "get_Tree_data")
    public String getTreeNode(HttpServletRequest request){
        try {
            Map<String, Object> data = XmlParser.parseToMap("classpath:menu.xml");
            Map<String, Object> treeViewData = new HashMap<String, Object>();
            treeViewData.put("data",data);
            JSONObject json = JSONObject.fromObject(treeViewData);
            return json.toString();
        }catch (DocumentException e){
            e.printStackTrace();
            return "0";
        }
    }

    @ResponseBody
    @RequestMapping(value = "get_navigator_item")
    public String getNavigatorItemByParentId(HttpServletRequest request) throws UnsupportedEncodingException {

        List<Object> list = new ArrayList<Object>();
        String id = request.getParameter("parentId");
        if("0".equals(id)){
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", "algorithm");
            map.put("text", "算法");
            map.put("hasChild", "true");
            list.add(map);

            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("id", "stock");
            map1.put("text", "股票");
            map1.put("hasChild", "true");
            list.add(map1);
        }else if("algorithm".equals(id)){
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", "liangzhu");
            map.put("text", "量柱算法");
            map.put("hasChild", "false");
            list.add(map);

            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("id", "paixu");
            map1.put("text", "排序算法");
            map1.put("hasChild", "false");
            list.add(map1);
        }else if("stock".equals(id)){
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", "huzhi");
            map.put("text", "沪指");
            map.put("hasChild", "true");
            list.add(map);

            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("id", "shenzhi");
            map1.put("text", "深指");
            map1.put("hasChild", "true");
            list.add(map1);
        }else if("shenzhi".equals(id)){
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", "yhjt");
            map.put("text", "雅化集团");
            map.put("hasChild", "false");
            list.add(map);

            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("id", "mhjt");
            map1.put("text", "美好集团");
            map1.put("hasChild", "false");
            list.add(map1);
        }else if("huzhi".equals(id)){
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", "zgzc");
            map.put("text", "中国中车");
            map.put("hasChild", "false");
            list.add(map);

            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("id", "ywg");
            map1.put("text", "远望谷");
            map1.put("hasChild", "false");
            list.add(map1);
        }
/*        String result = list.toString();
        result = result.replace("=",":");*/
        JSONArray json = JSONArray.fromObject(list);
        return json.toString();

    }

    @ResponseBody
    @RequestMapping(value = "load_grid_data")
    public String loadGridData(HttpServletRequest request) throws UnsupportedEncodingException {
        List result = new ArrayList();

        List list = new ArrayList();
        list.add("高量柱");
        list.add("低量柱");
        list.add("高量柱数量");
        list.add("低量柱数量");
        result.add(list);

        List list1 = new ArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("4");
        list1.add("5");
        list1.add("8");
        result.add(list1);

        List list2 = new ArrayList();
        list2.add("2");
        list2.add("2");
        list2.add("4");
        list2.add("5");
        list2.add("8");
        result.add(list2);

        List list3 = new ArrayList();
        list3.add("3");
        list3.add("2");
        list3.add("4");
        list3.add("5");
        list3.add("8");
        result.add(list3);

        List list4 = new ArrayList();
        list4.add("4");
        list4.add("2");
        list4.add("4");
        list4.add("5");
        list4.add("8");
        result.add(list4);

        JSONArray json = JSONArray.fromObject(result);
        return json.toString();
    }
}
