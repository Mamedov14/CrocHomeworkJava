import java.sql.*;
import java.util.List;

public class DataAccessObject {

    public Product findProduct(String code) throws SQLException {

        Connection connection = ConnectionUtils.getMyConnection();
        Statement statement = connection.createStatement();

//      language=SQL
        String sql = String.format("""
                SELECT
                order_number, username, article_article, product_name, price_in_rubles
                FROM test
                WHERE article_article = '%s';
                """, code);

        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            int order_number = Integer.parseInt(rs.getString("order_number"));
            String username = rs.getString("username");
            String article_article = rs.getString("article_article");
            String product_name = rs.getString("product_name");
            int price_in_rubles = Integer.parseInt(rs.getString("price_in_rubles"));

            connection.close();
            return new Product(order_number, username, article_article, product_name, price_in_rubles);
        }
        connection.close();
        return null;
    }

    public Product createProduct(Product product) throws SQLException, IllegalArgumentException {
        Connection connection = ConnectionUtils.getMyConnection();

        Product DBProduct = findProduct(product.getArticle_article());
        if (DBProduct != null) {
            throw new IllegalArgumentException("Продукт уже существует");
        }

//      language=SQL
        String sql = """
                INSERT INTO test
                (article_article, product_name, price_in_rubles)
                VALUES
                (?, ?, ?);
                """;

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getArticle_article());
        ps.setString(2, product.getProduct_name());
        ps.setInt(3, product.getPrice_in_rubles());
        ps.executeUpdate();

        connection.close();
        return product;
    }

    public Product updateProduct(Product product) throws SQLException {

        Connection connection = ConnectionUtils.getMyConnection();

//      language=SQL
        String sql = """
                UPDATE test
                SET product_name = ?, price_in_rubles = ?
                WHERE article_article = ?;
                """;

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getProduct_name());
        ps.setInt(2, product.getPrice_in_rubles());
        ps.setString(3, product.getArticle_article());
        ps.executeUpdate();

        connection.close();
        return product;
    }

    void deleteProduct(String code) throws SQLException {

        Connection connection = ConnectionUtils.getMyConnection();
        Statement statement = connection.createStatement();

//      language=SQL
        String sql = String.format("""
                DELETE FROM test WHERE article_article = '%s';
                """, code);

        int result = statement.executeUpdate(sql);
        connection.close();
        if (result != 0) {
            System.out.println("Успешно удалено!\n" + "Количество: " + result);
        } else {
            System.out.println("Артикул введен неверно!");
        }
    }

    public Order createOrder(String userLogin, List<Product> products) throws SQLException {

        Connection connection = ConnectionUtils.getMyConnection();

        Order order = new Order(userLogin, products);
//      language=SQL
        String sql = String.format("""
                
                
                """);

        return order;
    }
}
