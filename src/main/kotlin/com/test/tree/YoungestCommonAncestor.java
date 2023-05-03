package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class YoungestCommonAncestor {

    public static void main(String[] args) {
        AncestralTree A = new AncestralTree('A');
        AncestralTree B = new AncestralTree('B');
        AncestralTree C = new AncestralTree('C');
        AncestralTree D = new AncestralTree('D');
        AncestralTree E = new AncestralTree('E');
        AncestralTree F = new AncestralTree('F');
        A.addAsAncestor(new AncestralTree[]{C});
        A.addAsAncestor(new AncestralTree[]{B});
        D.addAsAncestor(new AncestralTree[]{A});
        D.addAsAncestor(new AncestralTree[]{E});
        F.addAsAncestor(new AncestralTree[]{D});

        System.out.println(getYoungestCommonAncestor(F,B,E).name);
    }
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
         TreeProperties treePropertiesOne = new TreeProperties(0,new ArrayList<>());
         TreeProperties treePropertiesTwo = new TreeProperties(0,new ArrayList<>());
        treePropertiesOne = getTreeProperties(descendantOne, treePropertiesOne);
        treePropertiesTwo = getTreeProperties(descendantTwo, treePropertiesTwo);

        AncestralTree answer;

        if(treePropertiesOne.length > treePropertiesOne.length){
             answer =  getMatchingTree(treePropertiesOne,treePropertiesTwo);
        } else {
             answer =  getMatchingTree(treePropertiesTwo,treePropertiesOne);
        }
        return answer; // Replace this line
    }

    private static AncestralTree getMatchingTree(TreeProperties treePropertiesSmall,
                                                 TreeProperties treePropertiesBig) {
        for (int idx = 0; idx < treePropertiesBig.length; idx++) {
            for (int jdx = 0; jdx < treePropertiesSmall.length; jdx++) {
                if(treePropertiesBig.ancestorList.get(idx) == treePropertiesSmall.ancestorList.get(jdx)){
                    return treePropertiesBig.ancestorList.get(idx);
                }
            }
        }
        return null;
    }


    private static TreeProperties getTreeProperties(AncestralTree descendantOne,
                                                    TreeProperties treeProperties) {
        if(descendantOne.ancestor == null) {
           return treeProperties;
        }

        treeProperties.length = treeProperties.length+1;
        treeProperties.ancestorList.add(descendantOne);
        treeProperties = getTreeProperties(descendantOne.ancestor,treeProperties);
        return treeProperties;
    }

    static class TreeProperties {
        public int length;
        List<AncestralTree> ancestorList;
        public TreeProperties(int length, List<AncestralTree> ancestorList) {
            this.length = length;
            this.ancestorList = ancestorList;
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }



}
