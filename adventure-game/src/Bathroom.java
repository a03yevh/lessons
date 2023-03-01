import java.util.ArrayList;
import java.util.List;

public class Bathroom extends Room {
    public Bathroom(String name, String description) {
        super(name, description);
        this.items = new ArrayList<>();
        this.items.add(new Item("Зеркало", "Круглое зеркало над раковиной"));
        this.items.add(new Item("Раковина", "Белая керамическая раковина"));
    }

    public Bathroom(String name) {
        super(name);
    }

    public Bathroom(List<Item> items) {

        super(items);
    }

    @Override
    public void printItems() {
        System.out.print("Предметы в комнате " + name() + ": ");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.print(items[i].getName());
            for (Item item : this.items) {
                System.out.println("- " + item.getName() + " (" + item.getDescription() + ")");
            }
        }
        System.out.println();
    }
}
