public class Kitchen extends Room {

    Kitchen(String name, String description) {
        super(name, description);
        this.item = new Item[] {
                new Window("Выдвижной ящик", "Верхний ящик под столешницей")
        };
    }

    Kitchen(String name) {
        super(name);
    }

    @Override
    public void printItems() {
        System.out.println("В комнате есть следующие предметы:");
        for (Item item : item) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
    }
}