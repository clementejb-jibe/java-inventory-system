package service;

import model.Product;
import repository.Repository;
import service.impl.InventoryServiceImpl;

public class InventoryService implements InventoryServiceImpl {

    private Repository repo;

    public InventoryService (Repository repo) {
        this.repo = repo;
    }

    @Override
    public void showAllProducts() {
        repo.showAllProduct();
    }

    @Override
    public void searchProductById() {
        repo.searchProductId();
    }

    public void addProduct(Product product) {
        repo.addProduct(product);
    }

    @Override
    public void removeProduct(int id) {
        repo.deleteProduct();
    }

}
