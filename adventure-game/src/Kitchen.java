public class Kitchen {
    String name;
    String description;
    Item[] item;

    public Kitchen(String name, String description) {
        this.name = name;
        this.description = description;
        this.item = new Item[] {
                new Item("Выдвижной ящик", "Верхний ящик под столешницей"),
        };
    }

    public Kitchen(String name) {
        this(name, "");
    }
}
