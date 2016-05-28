package com.stockGen.xml.util;

import com.stockGen.xml.model.*;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.*;

/**
 * Created by Administrator on 2016/5/28.
 */
public class XmlParser {

    /**
     * 将xml解析成树对象
     * @param url
     * @return
     * @throws DocumentException
     */
    public static Tree parserToTree(String url) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        Element element = document.getRootElement();
        Node node = transformationNode(element);
        Tree tree = new Tree();
        tree.setTreeName(node.getNodeName());
        tree.setRoot(node);
        return tree;
    }


    /**
     * 将element元素转换成Node
     * @param element
     * @return
     */
    private static Node transformationNode(Element element){

        Node node = new Node();
        node.setNodeName(element.getName());

        //解析attribute
        Map<String, String> attributes = new HashMap<String, String>();
        Iterator i = element.attributeIterator();
        while(i.hasNext()){
            Attribute attribute = (Attribute)i.next();
            attributes.put(attribute.getName(), attribute.getValue());
        }
        node.setAttribute(attributes);

        //解析子元素
        List<Element> elementList = element.elements();
        if(null!=elementList && elementList.size()>0) {
            for (Element temp : elementList) {
                Node sonNode = transformationNode(temp);
                sonNode.setParent(node);
                node.addSon(sonNode);
            }
        }

        return node;
    }
}
