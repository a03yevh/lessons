public abstract class Room {
    String name;
    String description;
    Item[] item;

    public String name() {

        return name;
    }
    public void full_info() {

        System.out.println(name + " -> " + description);
    }
    public String getName() {

        return name;
    }
    public abstract void printItems();
    Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    Room(String name, String description, Item[] item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    Room(String name) {
        this.name = name;
    }

    public Item[] getItems() {
        return item;
    }

    public void addItem(Item item) {
        if (this.item == null) {
            // Если массив item еще не инициализирован, создаем его и добавляем предмет
            this.item = new Item[]{item};
        } else {
            // Если массив уже инициализирован, увеличиваем его размер на 1 и добавляем предмет
            Item[] newItems = new Item[this.item.length + 1];
            for (int i = 0; i < this.item.length; i++) {
                newItems[i] = this.item[i];
            }
            newItems[this.item.length] = item;
            this.item = newItems;
        }
        System.out.println("Предмет '" + item.getName() + "' добавлен в комнату '" + this.getName() + "'");
    }
}
