package inners;

public abstract class AbstractTeacher {
    private int id;

    public AbstractTeacher(int id) {
        this.id = id;
    }

    public abstract boolean excludeStudent(Student student);
}
