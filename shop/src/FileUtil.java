import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    private static final String FILE_NAME = "products.csv";

    public static void saveProducts(Product[] products) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (Product product : products) {
                writer.write(product.getName() + "," + product.getDescription() + "," + product.getCategory() + "," + product.getPrice() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product[] readProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String description = fields[1];
                Category category = Category.valueOf(fields[2]);
                double price = Double.parseDouble(fields[3]);
                Product product = new Product(name, description, price, category);
                products.add(product);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products.toArray(new Product[0]);
    }
}