import model.Product;
import repository.Repository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //For Debugging Only

        Scanner scan =new Scanner(System.in);
        Product product = new Product();
        Repository db = new Repository(scan);

        db.showAllProduct();

        //db.addProduct(product); // Add Product to the Inventory Database

        db.searchProductId();

        db.deleteProduct(); // Remove Product from Inventory Database

        db.showAllProduct(); // Show all current products in Database
    }
}