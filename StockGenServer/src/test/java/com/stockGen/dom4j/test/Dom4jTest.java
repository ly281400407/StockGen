package com.stockGen.dom4j.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute;

import java.util.*;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Dom4jTest {

    public static void main(String[] args) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("src\\test\\resources\\menu.xml");
        Element root = document.getRootElement();

        Map<String, Object> documentMap = transformationElement(root);
        System.out.println(documentMap.size());
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
            elementMap.put("sonElements", sonElements);
        }

        return elementMap;
    }

}
