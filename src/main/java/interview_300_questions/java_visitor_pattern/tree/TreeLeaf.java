package interview_300_questions.java_visitor_pattern.tree;

import interview_300_questions.java_visitor_pattern.Color;
import interview_300_questions.java_visitor_pattern.visitor.TreeVisitor;

public class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    @Override
    public void accept(TreeVisitor visitor) {
        visitor.visitLeaf(this);
    }
}
