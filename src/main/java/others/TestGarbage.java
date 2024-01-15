package others;

public class TestGarbage {
    private String objName;

    public TestGarbage(String objName) {
        this.objName = objName;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("object " + this.objName + " is garbage collected");
    }

    public static void main(String[] args) {
        TestGarbage testGarbage = new TestGarbage("testGarbage");
        TestGarbage testGarbage1 = new TestGarbage("testGarbage1");
        testGarbage1 = testGarbage;
//        testGarbage1 = null;
        System.gc();
    }
}
