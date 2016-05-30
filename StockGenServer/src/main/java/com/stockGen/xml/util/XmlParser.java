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
        Document document = readXml(url);
        Element element = document.getRootElement();
        Node node = transformationNode(element);
        Tree tree = new Tree();
        tree.setTreeName(node.getNodeName());
        tree.setRoot(node);
        return tree;
    }

    /**
     * 读取xml文件
     * @param url
     * @return
     * @throws DocumentException
     */
    private static Document readXml(String url) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
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
                node.addItem(sonNode);
            }
        }

        return node;
    }

    /**
     * 将xml解析成map数据类型
     * @param url
     * @return
     * @throws DocumentException
     */
    public static Map<String, Object> parseToMap(String url) throws DocumentException{
        Document document = readXml(url);
        Element element = document.getRootElement();
        Map<String, Object> result = transformationElement(element);
        return result;
    }

    /**
     * 解析元素
     * @param root
     * @return
     */
    public static Map<String, Object> transformationElement(Element root){
        Map<String, Object> elementMap = new HashMap<String, Object>();

        //解析当前element的attribute
        for(Iterator<Attribute> i=root.attributeIterator() ; i.hasNext() ;){
            Attribute attribute = i.next();
            String name = attribute.getName();
            String value = attribute.getValue();
            elementMap.put(name,value);
        }
        elementMap.put("nodeName",root.getName());

        //解析当前element的子element
        List<Element> elementList = root.elements();
        if(null!=elementList && elementList.size()>0) {
            List<Map<String, Object>> sonElements = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < elementList.size(); i++) {
                Element sonElement = elementList.get(i);
                Map<String, Object> sonElementMap = transformationElement(sonElement);
                sonElements.add(i, sonElementMap);
            }
            elementMap.put("items", sonElements);
        }

        return elementMap;
    }
}
