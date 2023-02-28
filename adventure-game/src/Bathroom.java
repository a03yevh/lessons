public class Bathroom extends Room {
    public Item[] item;

    Bathroom(String name, String description) {
        super(name, description);
        this.item = new Item[] {
                new Item("Зеркало", "Круглое зеркало над раковиной"),
                new Item("Раковина", "Белая керамическая раковина")
        };
    }
    public Bathroom(String name) {

        super(name);
    }

    public Bathroom(Item[] items) {
        super(items);
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
