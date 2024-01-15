package classes;

public class LearnMainStatic {
    public static void main(String[] args) {
        StudentStatic student1 = new StudentStatic(42);
        StudentStatic student2 = new StudentStatic(77);


        System.out.println(StudentStatic.faculty);
        StudentStatic.convertFaculty("This is the best -->");
    }
}
