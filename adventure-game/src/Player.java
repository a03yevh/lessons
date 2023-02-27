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
            System.out.println("Вы перешли в комнату " + room.getName() + ".");
        } else {
            System.out.println("Ошибка: комната не найдена.");
        }
    }

    public void showItems() {
        System.out.println("Предметы в инвентаре:");
        for (Item item : item) {
            System.out.println("- " + item.getName());
        }
    }
}
