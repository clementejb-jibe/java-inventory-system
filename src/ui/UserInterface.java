package ui;

import controller.ProductController;
import ui.impl.UserInterfaceImpl;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterface implements UserInterfaceImpl {

    private final Scanner scan;
    private final ProductController controller;

    private final List<String> menuOptions = List.of(
            "1. Add Product",
            "2. Search Product",
            "3. Delete Product",
            "4. Show All Products",
            "5. Exit"
    );

    public UserInterface(ProductController controller, Scanner scan) {
        this.controller = controller;
        this.scan = scan;
    }



    private void mainMenu() {
        StringBuilder stringBuilder = new StringBuilder("\n===== PRODUCT MENU =====\n");
        for (String option : menuOptions) {
            stringBuilder.append(option).append("\n");
        }
        stringBuilder.append("SELECT an option: ");
        System.out.println(stringBuilder);
        System.out.flush();
    }

    // UI Method
    public void interfaceStart() {

        boolean isRunning = true;

        while (isRunning) {
            mainMenu();
            try {
                int selection = scan.nextInt();
                scan.nextLine();

                switch (selection) {
                    case 1 -> controller.addProduct();
                    case 2 -> controller.searchProductId();
                    case 3 -> controller.removeProductId();
                    case 4 -> controller.showAllProduct();
                    case 5 -> isRunning = false;
                    default -> System.out.println("Invalid Option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }
}


