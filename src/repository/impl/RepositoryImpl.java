package repository.impl;



public interface RepositoryImpl {
    void addProduct(String name, int quantity, double price);
    void deleteProduct(int id);
    String showAllProduct();
    String searchProductId(int id);
}
