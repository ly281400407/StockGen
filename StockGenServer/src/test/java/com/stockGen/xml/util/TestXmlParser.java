package com.stockGen.xml.util;

import com.stockGen.xml.model.Node;
import com.stockGen.xml.model.Tree;
import org.dom4j.DocumentException;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Administrator on 2016/5/28.
 */
public class TestXmlParser {

    /**
     * 测试xml解析成nodeTree
     * 先获取解析树
     * 1、校验树与根节点是否为空
     * 2、
     */
    @Test
    public void testParserNode(){

        Tree tree = null;
        try {
            tree = XmlParser.parserToTree("src\\test\\resources\\menu.xml");
        }catch (DocumentException e){
            Assert.assertEquals(e.getMessage(), false, true);
            return;
        }

        Assert.assertNotEquals("解析xml为空", tree, null);
        Node node = tree.getRoot();
        Assert.assertNotEquals("解析xml为空", node, null);
        Assert.assertEquals("解析根节点节点名称错误", node.getNodeName(), "Menu");
        Assert.assertEquals("解析根节点attribute错误，根节点attribute长度为0", node.getAttribute().size(), 0);

        List<Node> menuSon = node.getItems();
        Assert.assertNotEquals("menu节点的子节点不为空", menuSon, null);
        Assert.assertEquals("Menu子节点下存在三个子节点", menuSon.size(), 3);

        Node sonNode = menuSon.get(0);
        Assert.assertEquals("menu节点的第一个子节点名称应该为Command", sonNode.getNodeName(), "Command");

        Map<String, String> sonAttribution = sonNode.getAttribute();
        Assert.assertEquals("menu节点的第一个子节点的Attribute有两个", sonAttribution.size(), 2);


        Set<String> keySet = sonAttribution.keySet();
        //状态码 1-正常 2-name错误 3-name与value不匹配
        String statusCode = "1";
        Set<String> tempKeySet = new HashSet<String>();
        tempKeySet.add("type");
        tempKeySet.add("text");
        for(String key : keySet){
            if(tempKeySet.contains(key)){
                if("type".equals(key)){
                    if(!"menu".equals(sonAttribution.get(key))){
                        statusCode = "3";
                    }
                }else if("text".equals(key)){
                    if(!"stock".equals(sonAttribution.get(key))){
                        statusCode = "3";
                    }
                }
            }else{
                statusCode = "2";
            }
        }
        Assert.assertNotEquals("Command节点name错误", statusCode, 2);
        Assert.assertNotEquals("Command节点name与value不匹配", statusCode, 3);

    }

}
