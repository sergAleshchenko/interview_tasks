package inners;

public class Teacher extends AbstractTeacher {
    public Teacher(int id) {
        super(id);
    }

    @Override
    public boolean excludeStudent(Student student) {
        System.out.println("Inside Teacher.excludeStudent()");
        return false;
    }
}
