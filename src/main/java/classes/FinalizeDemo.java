package classes;

class Parent {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize: Parent");
    }
}

class SubParent extends Parent {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize: SubParent");
    }
}

public class FinalizeDemo extends SubParent {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize: FinalizeDemo");
    }

    public static void main(String[] args) {
        FinalizeDemo finalizeDemo = new FinalizeDemo();
        finalizeDemo = null;
        System.gc();
    }
}
