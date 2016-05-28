package com.stockGen.xml.model;

import java.util.List;
/**
 * Created by Administrator on 2016/5/28.
 */
public class Tree {

    Node root;

    private String treeName;

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
