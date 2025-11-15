import model.Product;
import repository.Repository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //For Debugging Only

        Scanner scan =new Scanner(System.in);
        Product product = new Product();
        Repository db = new Repository(product, scan);

        db.addProduct(product);

        db.showAllProduct();
    }
}