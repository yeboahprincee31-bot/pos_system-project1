import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public static void displayProducts() {

        String sql = "SELECT * FROM products";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql);
                ResultSet result =
                        statement.executeQuery()
        ) {

            System.out.println("\n===== PRODUCTS FROM DATABASE =====");

            while (result.next()) {

                int id = result.getInt("product_id");
                String name = result.getString("name");
                double price = result.getDouble("price");
                int stock = result.getInt("stock");

                System.out.println(
                        "ID: " + id +
                                " | " + name +
                                " | GH₵" + price +
                                " | Stock: " + stock
                );
            }

        } catch (SQLException e) {

            System.out.println("Could not load products.");
            System.out.println(e.getMessage());
        }
    }
}
