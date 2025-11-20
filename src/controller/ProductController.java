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
        while (true) {
            System.out.println(service.showAllProducts());

            System.out.println("1. Back");
            System.out.print("Select: ");
            int select = scan.nextInt();

            if (select == 1) {
                break;
            } else {
                System.out.println("Invalid Option.");
            }
        }
    }

    // Search Product through ID
    public void searchProductId() {

        while (true) {
            System.out.print("Enter Product ID: ");
            int enteredId = scan.nextInt();

            System.out.println(service.searchProductById(enteredId));

            System.out.print("""
                    1. Search Another Product
                    2. Back
                    3. Exit
                        Select:""");
            int select = scan.nextInt();

            if (select == 1) {
                searchProductId();
            } else if (select == 2) {
                break;
            } else if(select == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid Option");
            }
        }
    }

    // Delete Product by ID
    public void removeProductId() {
        System.out.println("Enter Product ID to remove:  ");
        int enteredId = scan.nextInt();

        service.removeProduct(enteredId);
    }

}
