package ui;

import controller.ProductController;

import java.util.Scanner;


public class UserInterface {

    private final Scanner scan;

    private final ProductController controller;

    public UserInterface(ProductController controller, Scanner scan) {
        this.controller = controller;
        this.scan = scan;
    }


    // UI Methods

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

    public void interfaceStart() {
        boolean isInterfaceRunning = true;

        while (isInterfaceRunning) {
            mainMenu();
            int selection = scan.nextInt();
            scan.nextLine();

            switch (selection) {
                case 1 -> controller.addProduct();
                case 2 -> controller.searchProductId();
                case 3 -> controller.removeProductId();
                case 4 -> controller.showAllProduct();
                case 5 -> isInterfaceRunning = false;
            }
        }
    }
}


