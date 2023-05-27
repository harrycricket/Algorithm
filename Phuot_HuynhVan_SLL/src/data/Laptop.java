package data;

/**
 *
 * @author Huynh Van Phuot
 */
public class Laptop {
    private String id;
    private double price;
    private int yearOfProduct;
    private String color;
    private String branch;

    public Laptop() {
    }

    public Laptop(String id, double price, int yearOfProduct, String color, String branch) {
        this.id = id;
        this.price = price;
        this.yearOfProduct = yearOfProduct;
        this.color = color;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfProduct() {
        return yearOfProduct;
    }

    public void setYearOfProduct(int yearOfProduct) {
        this.yearOfProduct = yearOfProduct;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-10.1f|%5d|%-10s|%-10s|", 
                            id, price, yearOfProduct, color, branch);
    }
    
    
}
