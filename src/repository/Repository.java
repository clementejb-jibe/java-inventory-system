package repository;

import model.Product;
import repository.impl.RepositoryImpl;

import java.sql.*;

public class Repository implements RepositoryImpl {


    private final Product product;

    public Repository(Product product) {
        this.product = product;
    }


    // SQL Method

    // A Method to get the connect the Java to SQL.
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/inventory";
        String username = "root";
        String password = "RoOt@987_my_SQL";

        return DriverManager.getConnection(url, username, password);
    }

    // This method is a function for getting all existing products from the database.
    public void saveProductToDatabase(Product product) {

        // A Query to insert the data inputted by users.
        String query = "INSERT INTO products (product_name, price, quantity) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, product.getName()); // Assign for product_name to insert data
            statement.setDouble(2, product.getPrice()); // Assign for price to insert data
            statement.setInt(3, product.getQuantity()); // Assign for quantity to insert data

            statement.executeUpdate(); // Updates the database after inserting data
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // This function is to show all existing items in database
    public String getAllProducts() {

        String query = "SELECT * FROM products";
        StringBuilder stringBuilder = new StringBuilder();
        boolean isEmpty = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet result = statement.executeQuery();

            stringBuilder.append("--------- PRODUCT ----------\n");
            while (result.next()) {
                isEmpty = true;
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

        if(!isEmpty) {
            System.out.println("\nNo product existing, database is empty.");
        }

        return stringBuilder.toString();
    }

    public void removeProduct(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            // update the database
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getProductId(int id) {
        String query = "SELECT id, product_name, quantity, price FROM products WHERE id =?";
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFound = false;

        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            stringBuilder.append("\n------PRODUCT-------\n");
            while (result.next()) {
                isFound = true;
                int productId = result.getInt("id");
                String productName = result.getString("product_name");
                int quantity = result.getInt("quantity");
                double price = result.getDouble("price");



                stringBuilder.append("ID: ").append(productId)
                        .append(" | PRODUCT NAME: ").append(productName)
                        .append(" | QUANTITY: ").append(quantity)
                        .append(" | PRICE: ").append(price)
                        .append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder validationText_Id = new StringBuilder(); // Texts for Validation if ID dont exists.
        // Checks if id existing
        if(!isFound) {
            validationText_Id.append("Product ID: ").append(id).append(" do not exist in database\n");
            return validationText_Id.toString();
        }
        return stringBuilder.toString();
    }

    // Main Methods for Repository
    @Override
    public String searchProductId(int id) {
        return getProductId(id);
    }

    @Override
    public void deleteProduct(int id) {
        removeProduct(id);
    }

    @Override
    public void addProduct(String name, int quantity, double price) {

        // Statement 1
        product.setName(name);

        // Statement 2
        product.setQuantity(quantity);

        // Statement 3
        product.setPrice(price);

        saveProductToDatabase(product);

    }

    @Override
    public String showAllProduct() {
        return getAllProducts();
    }



}
