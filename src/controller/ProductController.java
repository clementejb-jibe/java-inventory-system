package controller;

import service.InventoryService;

import java.util.Scanner;

public class ProductController {

    private final Scanner scan;

    private final InventoryService service;



    public ProductController(InventoryService service, Scanner scan) {
        this.service = service;
        this.scan = scan;
    }


    // Methods
    // Insert Product to Database
    public void addProduct() {
        System.out.print("Enter Product Name: ");
        String productName = scan.nextLine();

        System.out.print("Enter Quantity: ");
        int productQuantity = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Price: ");
        double productPrice = scan.nextDouble();
        scan.nextLine();

        service.addProduct(productName, productQuantity, productPrice);
    }

    // Fetch All Products from Database
    public void showAllProduct() {
        System.out.println(service.showAllProducts());
    }

    // Search Product through ID
    public void searchProductId() {
        System.out.print("Enter Product ID: ");
        int enteredId = scan.nextInt();

        System.out.println(service.searchProductById(enteredId));
    }

    // Delete Product by ID
    public void removeProductId() {
        System.out.println("Enter Product ID to remove:  ");
        int enteredId = scan.nextInt();

        service.removeProduct(enteredId);
    }

}
