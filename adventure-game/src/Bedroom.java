public class Bedroom extends Room {
    Item[] item;

    Bedroom(String name, String description) {
        super(name, description);
        this.item = new Item[] {
                new Item("Окно", "Окно с ручкой в дальней стене"),
                new Item("Тумбочка", "Деревянная тумбочка у кровати"),
                new Item("Кровать", "Незаправленная кровать из Икеи")
        };
    }

    Bedroom(String name) {
        super(name);
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
