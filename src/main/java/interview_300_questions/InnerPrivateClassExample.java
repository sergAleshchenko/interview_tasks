package interview_300_questions;

/**
 * @author Sergei Aleshchenko
 */
public class InnerPrivateClassExample {

    public static void main(String[] args) {
        Object o = new Inner().new Private();
    }

    static class Inner {
        private class Private {
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }
}

