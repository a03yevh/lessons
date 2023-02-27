public class Room {
    String name;
    String description;
    Item[] item;
    public String name() {
        return name;
    }
    public void full_info() {
        System.out.println(name + " -> " + description);
    }
    public String getName() {
        return name;
    }
    public void printItems() {
        System.out.println("В этой комнате нет доступных предметов");
    }
    Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    Room(String name, String description, Item[] item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    Room(String name) {
        this.name = name;
    }
}
