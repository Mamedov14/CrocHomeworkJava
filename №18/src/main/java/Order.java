import java.util.List;

public class Order {

    private String userLogin;
    private List<Product> products;

    public Order(String userLogin, List<Product> products) {
        this.userLogin = userLogin;
        this.products = products;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userLogin='" + userLogin + '\'' +
                ", products=" + products +
                '}';
    }
}
