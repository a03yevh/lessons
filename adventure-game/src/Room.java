import java.util.List;
import java.util.ArrayList;

public abstract class Room {
    public String name;
    public String description;
    public List<Item> items;

    public String name() {

        return name;
    }
    public void full_info() {

        System.out.println(name + " -> " + description);
    }
    public String getName() {
        return name;
    }
    public abstract void printItems();
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
    }
    public Room(String name, String description, List<Item> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

    public Room(String name) {

        this.name = name;
    }

    public Room(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
