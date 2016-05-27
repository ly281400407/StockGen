package com.stockGen.dom4j.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * Created by Administrator on 2016/5/27.
 */
public class Dom4jTest {

    public static void main(String[] args) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("D:\\StockGen\\StockGenServer\\src\\test\\resources\\menu.xml");
        Element root = document.getRootElement();
        String name = root.getName();

    }



}
