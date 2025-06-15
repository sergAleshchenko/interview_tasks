package interview_300_questions.java_visitor_pattern.visitor;

import interview_300_questions.java_visitor_pattern.Color;
import interview_300_questions.java_visitor_pattern.tree.TreeLeaf;
import interview_300_questions.java_visitor_pattern.tree.TreeNode;

public class ProductOfRedNodesVisitor extends TreeVisitor {
    private int prod = 1;
    private final int mod = 1000000007;

    @Override
    public int getResult() {
        return prod;
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            prod = (int) (((long)prod * node.getValue()) % mod);
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            prod = (int) (((long)prod * leaf.getValue()) % mod);
        }
    }
}
