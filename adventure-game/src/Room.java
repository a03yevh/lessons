public abstract class Room {
    public String name;
    public String description;
    public Item[] item;
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
    }
    public Room(String name, String description, Item[] item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    public Room(String name) {

        this.name = name;
    }

    public Room(Item[] items) {
        this.item = items;
    }
}
