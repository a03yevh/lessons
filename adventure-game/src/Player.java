public class Player {
    String name;
    Item[] item = new Item[10];
    Room currentRoom;

    public Player() {
        this.currentRoom = null;
    }

    public void setCurrentRoom(Room room) {
        if (room != null) {
            currentRoom = room;
        } else {
            System.out.println("Ошибка: комната не найдена.");
        }
    }

    public void showItems() {
        System.out.println("Предметы в инвентаре:");
        if (item != null) {
            for (Item item : item) {
                if (item != null) {
                    System.out.println("- " + item.getName());
                }
            }
        } else {
            System.out.println("Инвентарь пуст.");
        }
    }
}
