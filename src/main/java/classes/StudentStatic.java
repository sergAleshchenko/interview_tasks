package classes;

public class StudentStatic {
    static {
        faculty = "MMF";
        int a = 1/0;
    }

    static String faculty;
    private long studentId;
    private String name = "";
    private int yearOfStudy;

    public StudentStatic(long studentId) {
        this.studentId = studentId;
    }

    public static void convertFaculty(String head) {
        System.out.println(head + " " + faculty.toLowerCase());
    }

    public static String getFaculty() {
        return faculty;
    }

    public static void setFaculty(String faculty) {
        StudentStatic.faculty = faculty;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
