public class Bathroom extends Room {

    Bathroom(String name, String description) {
        super(name, description);
        this.item = new Item[] {
                new Furniture("Зеркало", "Круглое зеркало над раковиной"),
                new Furniture("Раковина", "Белая керамическая раковина")
        };
    }

    @Override
    public void printItems() {
        System.out.println("В комнате есть следующие предметы:");
        for (Item item : item) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
    }
}