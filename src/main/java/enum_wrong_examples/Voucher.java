package enum_wrong_examples;

public class Voucher {
    private int id;
    private VoucherType type;

    public Voucher(VoucherType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VoucherType getType() {
        return type;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
