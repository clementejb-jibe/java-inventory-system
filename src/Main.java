import controller.ProductController;
import model.Product;
import repository.Repository;
import service.InventoryService;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);

        Product product = new Product();

        Repository db = new Repository(product);

        InventoryService service = new InventoryService(db);

        ProductController controller = new ProductController(service, scan);

        UserInterface userInterface = new UserInterface(controller, scan);

        userInterface.interfaceStart();



    }
}