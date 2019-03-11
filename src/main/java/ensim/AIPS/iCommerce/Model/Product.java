package ensim.AIPS.iCommerce.Model;

public class Product {
    private int id;
    private String name;
    private String description;
    private int stock;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product(int id, String name, String description, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
    }
}
