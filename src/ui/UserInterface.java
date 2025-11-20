package ui;

import controller.ProductController;
import ui.impl.UserInterfaceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterface implements UserInterfaceImpl {

    private final Scanner scan;

    private final ProductController controller;

    public UserInterface(ProductController controller, Scanner scan) {
        this.controller = controller;
        this.scan = scan;
    }

    private void mainMenu() {
        System.out.print("""
                :::::::::: INVENTORY ::::::::::
                1. Add Product
                2. Search Product
                3. Delete Product
                4. Show All Products
                5. Exit
                    SELECT:""");
    }

    // UI Method
    public void interfaceStart() {

        while (true) {
            mainMenu();
            try {
                int selection = scan.nextInt();
                scan.nextLine();

                switch (selection) {
                    case 1 -> controller.addProduct();
                    case 2 -> controller.searchProductId();
                    case 3 -> controller.removeProductId();
                    case 4 -> controller.showAllProduct();
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid Option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scan.next();
            }
        }


    }
}


