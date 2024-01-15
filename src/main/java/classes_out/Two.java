package classes_out;


class One {
    void method() {

    }
}

public class Two extends One {
    @Override
    protected void method() {
        super.method();
    }
}
