package repository.impl;

import model.Product;

import java.util.Map;

public interface RepositoryImpl {
    void addProduct(Product product);
    void deleteProduct();
    void showAllProduct();
}
