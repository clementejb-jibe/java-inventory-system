package controller;

import service.InventoryService;

import java.util.InputMismatchException;
import java.util.List;
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
        System.out.print("\nEnter Product Name: ");
        String productName = scan.nextLine();

        System.out.print("Enter Quantity: ");
        try {
            int productQuantity = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter Price: ");
            double productPrice = scan.nextDouble();
            scan.nextLine();

            service.addProduct(productName, productQuantity, productPrice);
            System.out.println("\nAdded to the database.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scan.next();
        }
    }

    // Fetch All Products from Database
    public void showAllProduct() {
        while (true) {
            System.out.println(service.showAllProducts());

            System.out.println("1. Back");
            System.out.print("SELECT an option: ");
            try {
                int select = scan.nextInt();

                if (select == 1) {
                    break;
                } else {
                    System.out.println("\nInvalid Option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scan.next();
            }
        }
    }

    // Search Product through ID
    public void searchProductId() {

        List<String> menuOptions = List.of(
                "1. Search Another Product",
                "2. Back",
                "3. Exit"
        );


        while (true) {
            System.out.print("\nEnter Product ID: ");

            try {
                int enteredId = scan.nextInt();
                System.out.println(service.searchProductById(enteredId));

                menuOptions.forEach(System.out::println);
                System.out.print("SELECT an option: ");
                int select = scan.nextInt();

                if (select == 1) {
                    searchProductId();
                } else if (select == 2) {
                    break;
                } else if (select == 3) {
                    System.exit(0);
                } else {
                    System.out.printf("\nOption '%d' is not on the option.\n", enteredId);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scan.next();
            }
        }
    }

    // Delete Product by ID
    public void removeProductId() {
        while (true) {
            System.out.println("\nEnter Product ID to be remove:  ");
            try {
                int enteredId = scan.nextInt();
                service.removeProduct(enteredId);
                System.out.println("\nProduct Removed Successfully.\n");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scan.next();
            }
        }
    }

}
