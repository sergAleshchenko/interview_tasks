package in_out;

import java.io.Serializable;

public class Student implements Serializable {
    static String faculty = "MMF2";
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 2L;

    public Student(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Faculty: " + faculty +
                "\nName: " + name +
                "\nID: " + id +
                "\nPassword: " + password;
    }
}
