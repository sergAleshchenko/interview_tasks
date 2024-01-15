package entity;

public class Person {
    private int id;
    private String name = "";

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("others.Person{");
        sb.append("personId = " + id + ", ");
        sb.append("name = " + name + "}");

        return sb.toString();
    }
}
