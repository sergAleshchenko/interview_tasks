package inners;

public class TeacherCreator {
    public static AbstractTeacher createTeacher(int id) {

        class Rector extends AbstractTeacher {
            public Rector(int id) {
                super(id);
            }

            @Override
            public boolean excludeStudent(Student student) {
                System.out.println("Inside Rector.excludeStudent()");
                if (student != null) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (isRectorId(id)) {
            return new Rector(id);
        } else {
            return new Teacher(id);
        }
    }

    private static boolean isRectorId(int id) {
        return (id == 6);
    }
}
