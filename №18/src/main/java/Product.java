public class Product {

    private int order_number;
    private String username;
    private String article_article;
    private String product_name;
    private int price_in_rubles;

    public Product(int order_number, String username, String article_article, String product_name, int price_in_rubles) {
        this.order_number = order_number;
        this.username = username;
        this.article_article = article_article;
        this.product_name = product_name;
        this.price_in_rubles = price_in_rubles;
    }

    public Product(String article_article, String product_name, int price_in_rubles) {
        this.article_article = article_article;
        this.product_name = product_name;
        this.price_in_rubles = price_in_rubles;
    }

    public Product(String article_article) {
        this.article_article = article_article;
    }

    public int getOrder_number() {
        return order_number;
    }

    public String getUsername() {
        return username;
    }

    public String getArticle_article() {
        return article_article;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getPrice_in_rubles() {
        return price_in_rubles;
    }

    @Override
    public String toString() {
        return "Product{" +
                "order_number=" + order_number +
                ", username='" + username + '\'' +
                ", article_article='" + article_article + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price_in_rubles=" + price_in_rubles +
                '}';
    }
}
