package service.impl;

import model.Product;

public interface InventoryServiceImpl {

    void showAllProducts();
    void addProduct(Product product);
    void removeProduct(int id);
    void searchProductById();

}
