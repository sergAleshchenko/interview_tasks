package inners;

import java.io.Serializable;

public class Student {
    private int studentId;
    private String name;
    private int group;
    private String faculty;

    private Address address;

    public class Address extends Thread implements Serializable {
        private String city;
        private String street;
        private int houseId;
        private int flatId;
        private String email;
        private String skype;
        private long phoneNumber;

        public Address() {
        }

        public void action() {
            group = 101;
        }
    }

    public Student() {
    }

    public void operation() {
        address.city = "Kiiv";
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
