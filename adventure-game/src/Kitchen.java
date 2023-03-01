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
