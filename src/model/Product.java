package model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    } // Get the Product ID

    public void setId(int id) {
        this.id = id;
    } // Set the Product ID

    public String getName() {
        return name;
    } // Get the Product Name

    public void setName(String name) {
        this.name = name;
    } // Set the Product Name

    public int getQuantity() {
        return quantity;
    } // get the Product Quantity

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } // Set the Product Quantity

    public double getPrice() {
        return price;
    } // Get the Product Price

    public void setPrice(double price) {
        this.price = price;
    } // Set the Product Price

}
