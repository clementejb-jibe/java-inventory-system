package service;


import repository.Repository;
import service.impl.InventoryServiceImpl;

public class InventoryService implements InventoryServiceImpl {

    private final Repository repo;

    public InventoryService (Repository repo) {
        this.repo = repo;
    }

    @Override
    public String showAllProducts() {
        return repo.showAllProduct();
    }

    @Override
    public String searchProductById(int id) {
        return repo.searchProductId(id);
    }

    public void addProduct(String productName, int quantity, double price) {
        repo.addProduct(productName, quantity, price);
    }

    @Override
    public void removeProduct(int id) {
        repo.deleteProduct(id);
    }

}
