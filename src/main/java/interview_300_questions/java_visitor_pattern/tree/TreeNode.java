package interview_300_questions.java_visitor_pattern.tree;

import interview_300_questions.java_visitor_pattern.Color;
import interview_300_questions.java_visitor_pattern.visitor.TreeVisitor;

import java.util.ArrayList;
import java.util.List;

public class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    @Override
    public void accept(TreeVisitor visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}
