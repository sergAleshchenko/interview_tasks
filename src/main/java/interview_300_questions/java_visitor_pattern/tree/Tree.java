package interview_300_questions.java_visitor_pattern.tree;

import interview_300_questions.java_visitor_pattern.Color;
import interview_300_questions.java_visitor_pattern.visitor.TreeVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public abstract void accept(TreeVisitor visitor);
}
