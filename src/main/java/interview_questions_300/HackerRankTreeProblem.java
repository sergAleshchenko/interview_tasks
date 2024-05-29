package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int result = 0;

    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long result=1L;

    public int getResult() {
        //implement this
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % (1000000007);
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % (1000000007);
        }
    }
}

class FancyVisitor extends TreeVis {
    int sumOfNode=0;
    int sumOfLeaf = 0;

    public int getResult() {
        //implement this
        return Math.abs(sumOfNode - sumOfLeaf);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            sumOfNode += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.GREEN) {
            sumOfLeaf += leaf.getValue();
        }
    }
}

public class HackerRankTreeProblem {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] vals = new int[n];

        for(int i=0; i<n; i++){
            vals[i]= sc.nextInt();

        }
        Color[] colors = new Color[n];

        for(int i=0; i<n; i++){
            colors[i]= sc.nextInt()==1? Color.GREEN:Color.RED;
        }

        Map<Integer, Set<Integer>> nodeEdges = new HashMap<>();
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(!nodeEdges.containsKey(u)){
                nodeEdges.put(u,new HashSet<Integer>());
            }
            if(!nodeEdges.containsKey(v)){
                nodeEdges.put(v,new HashSet<Integer>());
            }
            nodeEdges.get(u).add(v);
            nodeEdges.get(v).add(u);
        }

        Map<TreeNode, Integer> nodeIndexMap = new HashMap<>();
        List<TreeNode> parents = new ArrayList<>();

        TreeNode root = new TreeNode(vals[0],colors[0],0);
        nodeIndexMap.put(root,1);
        parents.add(root);

        while(!parents.isEmpty()){
            List<TreeNode> nextLevelParents = new ArrayList<>();
            for(TreeNode node : parents){
                int depth = node.getDepth();
                int parentIndex = nodeIndexMap.get(node);

                for(int childIndex: nodeEdges.get(parentIndex)){

                    nodeEdges.get(childIndex).remove(parentIndex);

                    if(!nodeEdges.get(childIndex).isEmpty()){
                        TreeNode child = new TreeNode(vals[childIndex-1], colors[childIndex-1],depth+1);
                        nextLevelParents.add(child);
                        nodeIndexMap.put(child, childIndex);
                        node.addChild(child);
                    }else{
                        TreeLeaf leaf = new TreeLeaf(vals[childIndex-1], colors[childIndex-1],depth+1);
                        node.addChild(leaf);
                    }
                }
            }
            parents = nextLevelParents;
        }
        sc.close();
        return root;
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}