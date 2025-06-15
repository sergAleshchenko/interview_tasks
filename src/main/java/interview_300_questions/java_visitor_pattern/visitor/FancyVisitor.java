package interview_300_questions.java_visitor_pattern.visitor;

import interview_300_questions.java_visitor_pattern.Color;
import interview_300_questions.java_visitor_pattern.tree.TreeLeaf;
import interview_300_questions.java_visitor_pattern.tree.TreeNode;

public class FancyVisitor extends TreeVisitor {
    private int sumNonLeaf;
    private int sumGreenLeaf;

    @Override
    public int getResult() {
        return Math.abs(sumNonLeaf - sumGreenLeaf);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumNonLeaf += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaf += leaf.getValue();
        }
    }
}
