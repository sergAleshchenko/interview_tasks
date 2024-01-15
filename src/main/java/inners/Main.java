package inners;

public class Main {
    public static void main(String[] args) {
        Student.Address address = new Student().new Address();
        Student student = new Student();
        Student.Address address1 = student.getAddress();
    }
}
