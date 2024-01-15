package exceptions;

import java.io.IOException;
import java.io.WriteAbortedException;

public class ExChild extends ExSuper {
    @Override
    public void doSomething() throws ArithmeticException, WriteAbortedException {

    }
}
