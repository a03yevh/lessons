public class Bedroom {
    String name;
    String description;
    Item[] item;

    public Bedroom(String name, String description) {
        this.name = name;
        this.description = description;
        this.item = new Item[] {
                new Item("Окно", "Окно с ручкой в дальней стене"),
                new Item("Тумбочка", "Деревянная тумбочка у кровати"),
                new Item("Кровать", "Незаправленная кровать из Икеи")
        };
    }

    public Bedroom(String name) {
        this(name, "");
    }
}
