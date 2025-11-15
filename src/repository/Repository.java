package repository;

import model.Product;
import repository.impl.RepositoryImpl;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Repository implements RepositoryImpl {

    private final Map<Long, Product> storage = new TreeMap<>();

    private Scanner scan;

    private Product product;

    private Long nextId = 1L;

    public Repository(Product product, Scanner scan) {
        this.product = product;
        this.scan = scan;
    }

    @Override
    public void addProduct(Product product) {

        this.product.setId(nextId++);
        System.out.printf("Product ID: %d\n", product.getId());

        System.out.print("Enter Product Name: ");
        String enteredName = scan.nextLine();

        product.setName(enteredName);

        System.out.print("Enter Product Quantity: ");
        int enteredQuantity = scan.nextInt();

        product.setQuantity(enteredQuantity);

        System.out.print("Enter Product Price: ");
        double enteredPrice = scan.nextDouble();

        product.setPrice(enteredPrice);


    }

    @Override
    public void showAllProduct() {

    }


}
