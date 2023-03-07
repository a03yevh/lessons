public class Application {
    private static Product[] products = {
            new Product("Laptop", "Powerful laptop with 16 GB RAM and 1 TB SSD", 1000, Category.ELECTRONICS),
            new Product("Sofa", "Comfortable sofa for your living room", 500, Category.FURNITURE),
            new Product("Headphones", "Wireless headphones with noise-cancellation", 200, Category.ACCESSORIES)
    };

    public static void main(String[] args) {
        Product[] products = FileUtil.readProducts();
        Menu menu = new Menu();
        while (true) {
            menu.printMainMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    menu.printAllProducts(products);
                    break;
                case 2:
                    Product newProduct = menu.createProduct();
                    products = addProduct(products, newProduct);
                    FileUtil.saveProducts(products);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static Product[] addProduct(Product[] products, Product newProduct) {
        Product[] newProducts = new Product[products.length + 1];
        System.arraycopy(products, 0, newProducts, 0, products.length);
        newProducts[products.length] = newProduct;
        return newProducts;
    }
}