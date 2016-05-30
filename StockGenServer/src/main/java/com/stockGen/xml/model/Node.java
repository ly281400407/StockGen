package com.stockGen.xml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/28.
 */
public class Node {

    //节点名
    private String nodeName;

    //父节点
    private Node parent;

    //子节点
    private List<Node> items;

    //节点属性
    private Map<String, String> attribute;

    /**
     * 添加子节点
     * @param node
     */
    public void addItem(Node node){
        if(null == items){
            items = new ArrayList<Node>();
        }
        items.add(node);
        node.setParent(this);
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getItems() {
        return items;
    }

    public Map<String, String> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, String> attribute) {
        this.attribute = attribute;
    }
}
