package repository;

import model.Product;
import repository.impl.RepositoryImpl;

import java.sql.*;
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


    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/inventory";
        String username = "root";
        String password = "RoOt@987_my_SQL";

        return DriverManager.getConnection(url, username, password);
    }

    public void saveProductToDatabase(Product product) {

        String query = "INSERT INTO products (product_name, price, quantity) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());

            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAllProducts() {

        String query = "SELECT * FROM products";
        StringBuilder stringBuilder = new StringBuilder("------PRODUCT-------\n");

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet result = statement.executeQuery();


            while (result.next()) {
                int id = result.getInt("id");
                String productName = result.getString("product_name");
                int quantity = result.getInt("quantity");
                double price = result.getDouble("price");

                stringBuilder.append("ID: ").append(id)
                        .append(" | PRODUCT NAME: ").append(productName)
                        .append(" | QUANTITY: ").append(quantity)
                        .append(" | PRICE: ").append(price)
                        .append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    @Override
    public void addProduct(Product product) {

        /*this.product.setId(nextId++);
        System.out.printf("Product ID: %d\n", product.getId());*/
        // Statement 1
        System.out.print("Enter Product Name: ");
        String enteredName = scan.nextLine();
        product.setName(enteredName);

        // Statement 2
        System.out.print("Enter Product Quantity: ");
        int enteredQuantity = scan.nextInt();
        scan.nextLine();
        product.setQuantity(enteredQuantity);

        // Statement 3
        System.out.print("Enter Product Price: ");
        double enteredPrice = scan.nextDouble();
        scan.nextLine();
        product.setPrice(enteredPrice);

        saveProductToDatabase(product);

    }

    @Override
    public void showAllProduct() {
        System.out.println(getAllProducts());
    }


    public void databaseConnection() {

    }


}
