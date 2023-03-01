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
