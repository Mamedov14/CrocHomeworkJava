import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final int FIRST_CHOICE = 1;
    private final int LAST_CHOICE = 6;

    void showMenu() {
        System.out.println("-----------------");
        System.out.println("Меню");
        System.out.println("1) Поиск товара");
        System.out.println("2) Создание нового товара");
        System.out.println("3) Редактировать информацию о товаре");
        System.out.println("4) Удаление товара и всех упоминаний о нем в заказах");
        System.out.println("5) Создание заказа");
        System.out.println("6) Выход");
        System.out.print("INPUT: ");
    }

    void startMenu() throws SQLException {
        int choice;

        do {
            showMenu();

            Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
            choice = scanner.nextInt();
            scanner.nextLine(); // consume \n in console

            try {
                if (choice < FIRST_CHOICE || choice > LAST_CHOICE) {
                    throw new IllegalArgumentException("Вы выбрали не правильный пункт меню!");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Поиск товара по артикулу");
                    System.out.println("Введите <артикул_товара>");
                    String code = scanner.nextLine();
                    DataAccessObject dataAccessObject = new DataAccessObject();
                    System.out.println(dataAccessObject.findProduct(code));
                }
                case 2 -> {
                    System.out.println("Создание товара");
                    System.out.println("Введите <артикул_товара> <название> <цена>");
                    String code = scanner.nextLine();
                    String name = scanner.nextLine();
                    int price = scanner.nextInt();
                    DataAccessObject dataAccessObject = new DataAccessObject();
                    System.out.println(dataAccessObject.createProduct(new Product(code, name, price)));
                }
                case 3 -> {
                    System.out.println("Редактировать данные товара");
                    System.out.println("Введите <артикул_товара> <новое_название> <новая_цена>");
                    String code = scanner.nextLine();
                    String name = scanner.nextLine();
                    int price = scanner.nextInt();
                    DataAccessObject dataAccessObject = new DataAccessObject();
                    System.out.println(dataAccessObject.updateProduct(new Product(code, name, price)));
                }
                case 4 -> {
                    System.out.println("Удалить товар");
                    System.out.println("Введите <артикул_товара>");
                    String code = scanner.nextLine();
                    DataAccessObject dataAccessObject = new DataAccessObject();
                    dataAccessObject.deleteProduct(code);
                }
                case 5 -> {
                    System.out.println("Создать заказ");
                    System.out.println("Введите <логин_пользователя> <артикул_товара_1>[, <артикул_товара_N>]");
                    String name = scanner.nextLine();
                    List<Product> products = new ArrayList<>();
                    products.add(new Product("Т2"));
                    products.add(new Product("Т4"));
                    DataAccessObject dataAccessObject = new DataAccessObject();
                    System.out.println(dataAccessObject.createOrder(name, products));
                }
                case 6 -> {
                    System.out.println("До свидания!");
                }
            }
        } while (choice != LAST_CHOICE);
    }
}