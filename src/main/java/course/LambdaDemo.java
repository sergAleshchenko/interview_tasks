package course;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */

interface Executable {
    int execute(int i, int j);
}

class SomeRunner {
    public void run(Executable e) {
        int execute = e.execute(10, 15);

        System.out.println("SomeRunner.run(), execute = " + execute);
    }
}

class ExecutableImpl implements Executable {
    @Override
    public int execute(int i, int j) {
        System.out.println("ExecutableImpl.execute(), i = " + i + ", j = " + j);
        return i;
    }

}

public class LambdaDemo {
    public static void main(String[] args) {

        SomeRunner someRunner = new SomeRunner();
        someRunner.run(new ExecutableImpl());

        System.out.println("-------------------------------");

        int a = 1;
        someRunner.run(new Executable() {
            @Override
            public int execute(int i, int j) {
                System.out.println("Anonymous way, i = " + i + ", j = " + j);
                int a = 2;
                return i + j;
            }
        });

        System.out.println("-------------------------------");

        someRunner.run((x, y) -> x);
    }
}
