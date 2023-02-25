public class Bathroom {
    String name;
    String description;
    Item[] item;

    public Bathroom(String name, String description) {
        this.name = name;
        this.description = description;
        this.item = new Item[] {
                new Item("Зеркало", "Круглое зеркало над раковиной"),
                new Item("Раковина", "Белая керамическая раковина")
        };
    }

    public Bathroom(String name) {
        this(name, "");
    }
}
