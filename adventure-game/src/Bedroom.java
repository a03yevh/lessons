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

    @Override
    public void printItems() {
        System.out.print("Предметы в комнате " + name() + ": ");
        for (int i = 0; i < item.length; i++) {
            System.out.print(item[i].getName());
            if (i < item.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
