package exchanger;

public class Item {
    private int itemId;
    private double price;
    private String description;

    public Item(int itemId, double price, String description) {
        this.itemId = itemId;
        this.price = price;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("id=%d, price=%4.2f, description=%s \n" ,itemId, price, description);
    }
}
