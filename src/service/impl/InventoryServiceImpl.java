package service.impl;

import model.Product;

public interface InventoryServiceImpl {

    String showAllProducts();
    void addProduct(String productName, int quantity, double price);
    void removeProduct(int id);
    String searchProductById(int id);

}
