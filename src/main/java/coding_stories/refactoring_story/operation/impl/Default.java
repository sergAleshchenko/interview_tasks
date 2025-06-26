package coding_stories.refactoring_story.operation.impl;

import coding_stories.refactoring_story.operation.Operation;

public class Default implements Operation {
    private final String userInput;

    public Default(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String act(int number) {
        return userInput + number;
    }

    @Override
    public String getOperationName() {
        return userInput;
    }
}
