package generics;

/**
 * @author Sergei Aleshchenko
 */
public class Company implements CustomerInterface {
    private int id;
    private String name;
    private String address;
    private String companyName;

    public Company(int id, String name, String address, String companyName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.companyName = companyName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
