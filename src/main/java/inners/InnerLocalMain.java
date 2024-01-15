package inners;

public class InnerLocalMain {
    public static void main(String[] args) {
        AbstractTeacher teacher = TeacherCreator.createTeacher(6);
        System.out.println(teacher.getClass());

        boolean result = teacher.excludeStudent(new Student());
        System.out.println(result);
    }
}
