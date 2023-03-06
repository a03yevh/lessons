import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println("Welcome to the shop!");
        System.out.println("Please select an option:");
        System.out.println("1. Show all products");
        System.out.println("2. Create a new product");
        System.out.println("3. Exit");
    }

    public int getChoice() {
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    public void printAllProducts(Product[] products) {
        System.out.println("All products:");
        for (Product product : products) {
            System.out.println(product.getName() + " (" + product.getCategory() + "): " + product.getDescription() + " - " + product.getPrice() + " USD");
        }
    }

    public Product createProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product description: ");
        String description = scanner.next();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter product category:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        Category category = categories[choice - 1];
        return new Product(name, description, price, category);
    }
}



