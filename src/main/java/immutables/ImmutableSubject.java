package immutables;

public class ImmutableSubject {
    private int id;
    private String name;

    public ImmutableSubject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
