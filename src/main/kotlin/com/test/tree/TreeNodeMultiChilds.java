package com.test.tree;

import java.util.ArrayList;

public class TreeNodeMultiChilds {
        String data;
        ArrayList<TreeNodeMultiChilds> children;

        public TreeNodeMultiChilds(String data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeNodeMultiChilds node) {
            this.children.add(node);
        }

        public String print(int level) {
            String ret;
            ret =   "  ".repeat(level)+"|_ "+data+"\n";
            for (TreeNodeMultiChilds node : this.children) {
                ret += node.print(level+1);
            }
            return ret;
        }

    public static void main(String[] args) {
        TreeNodeMultiChilds treeNode = new TreeNodeMultiChilds("Drinks");
        TreeNodeMultiChilds hot = new TreeNodeMultiChilds("Hot");
        TreeNodeMultiChilds cold = new TreeNodeMultiChilds("Cold");
        treeNode.addChild(hot);
        treeNode.addChild(cold);
        TreeNodeMultiChilds tea = new TreeNodeMultiChilds("Tea");
        TreeNodeMultiChilds coffee = new TreeNodeMultiChilds("Coffee");
        TreeNodeMultiChilds chocolate = new TreeNodeMultiChilds("Chocolate");
        hot.addChild(tea);
        hot.addChild(coffee);
        hot.addChild(chocolate);
        TreeNodeMultiChilds soda = new TreeNodeMultiChilds("Soda");
        TreeNodeMultiChilds milk = new TreeNodeMultiChilds("Milk");
        cold.addChild(soda);
        cold.addChild(milk);
        System.out.println(treeNode.print(0));
    }
}
