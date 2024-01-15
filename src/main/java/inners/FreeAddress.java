package inners;

public class FreeAddress extends Student.Address {

    public FreeAddress() {
        new Student().super();
    }

    public FreeAddress(Student student) {
        student.super();
    }
}
