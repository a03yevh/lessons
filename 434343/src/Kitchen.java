public class Kitchen extends Room {
    Item[] item;

    Kitchen(String name, String description) {
        super(name, description);
        this.item = new Item[] {
                new Item("Выдвижной ящик", "Верхний ящик под столешницей"),
        };
    }

    Kitchen(String name) {
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
