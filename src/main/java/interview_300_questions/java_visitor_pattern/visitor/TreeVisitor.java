package interview_300_questions.java_visitor_pattern.visitor;

import interview_300_questions.java_visitor_pattern.tree.TreeLeaf;
import interview_300_questions.java_visitor_pattern.tree.TreeNode;

public abstract class TreeVisitor {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}
