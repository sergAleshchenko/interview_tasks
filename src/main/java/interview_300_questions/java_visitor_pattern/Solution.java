package interview_300_questions.java_visitor_pattern;

import interview_300_questions.java_visitor_pattern.tree.Tree;
import interview_300_questions.java_visitor_pattern.visitor.FancyVisitor;
import interview_300_questions.java_visitor_pattern.visitor.ProductOfRedNodesVisitor;
import interview_300_questions.java_visitor_pattern.visitor.SumInLeavesVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
//    Sample input:
//          5
//          4 7 2 5 12
//          0 1 0 0 1
//          1 2
//          1 3
//          3 4
//          3 5

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nodeValues = new int[n];
        Color[] nodeColors = new Color[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nodeValues[i] = scanner.nextInt();;
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            nodeColors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        return null;
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
