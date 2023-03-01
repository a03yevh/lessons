public class Bedroom extends Room {

    Bedroom(String name, String description) {
        super(name, description);
        this.item = new Item[] {
                new Window("Окно", "Окно с ручкой в дальней стене"),
                new Furniture("Тумбочка", "Деревянная тумбочка у кровати"),
                new Furniture("Кровать", "Незаправленная кровать из Икеи")
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