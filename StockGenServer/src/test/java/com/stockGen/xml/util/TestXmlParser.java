package com.stockGen.xml.util;

import com.stockGen.xml.model.Node;
import com.stockGen.xml.model.Tree;
import org.dom4j.DocumentException;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class TestXmlParser {

    @Test
    public void testParserNode(){

        Tree tree = null;
        try {
            tree = XmlParser.parserToTree("src\\test\\resources\\menu.xml");
        }catch (DocumentException e){
            Assert.assertEquals(e.getMessage(), false, true);
            return;
        }
        Assert.assertEquals("解析xml为空", tree, null);
        Node node = tree.getRoot();
        Assert.assertEquals("解析xml为空", node, null);
        Assert.assertEquals("解析根节点节点名称错误", node.getNodeName(), "Menu");
        Assert.assertEquals("解析根节点attribute错误，根节点attribute应为空", node.getAttribute(), null);

        List<Node> menuSon = node.getSon();
        Assert.assertEquals("menu节点的子节点不为空", menuSon, null);


    }

}
