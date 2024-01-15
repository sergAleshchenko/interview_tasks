package entity;

public class Student extends Person {

    private String faculty;
    private int yearOfStudy;

    public Student() {
    }

    public Student(String faculty, int yearOfStudy) {
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
    }

    public Student(int id, String name, String faculty, int yearOfStudy) {
        this(faculty, yearOfStudy);
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
