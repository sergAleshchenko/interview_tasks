package interview_300_questions.java_visitor_pattern.visitor;

import interview_300_questions.java_visitor_pattern.tree.TreeLeaf;
import interview_300_questions.java_visitor_pattern.tree.TreeNode;

public class SumInLeavesVisitor extends TreeVisitor {
    private int sum = 0;

    @Override
    public int getResult() {
        return sum;
    }

    @Override
    public void visitNode(TreeNode node) {}

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}
