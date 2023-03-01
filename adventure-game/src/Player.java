import java.util.Scanner;
import java.util.InputMismatchException;

public class Player {
    String name;
    private static final int ITEM_SIZE = 10;
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
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void interact() {
        // Получаем список предметов в текущей комнате
        Item[] roomItems = getCurrentRoom().getItems();

        // Печатаем список предметов с номерами
        System.out.println("Выберите предмет для взаимодействия:");
        for (int i = 0; i < roomItems.length; i++) {
            Item item = roomItems[1];
            System.out.println((i + 1) + ". " + item.getName());
        }

        Scanner scanner = new Scanner(System.in);
        // Считываем номер выбранного предмета
        int itemIndex = -1;
        while (itemIndex < 1 || itemIndex > roomItems.length) {
            System.out.print("Введите номер предмета: ");
            try {
                itemIndex = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите число.");
                scanner.nextLine();
            }
            if (itemIndex < 1 || itemIndex > roomItems.length) {
                System.out.println("Некорректный номер предмета.");
            }
        }


        // Получаем выбранный предмет и обрабатываем его
        Item selectedItem = roomItems[itemIndex - 1];
        if (selectedItem instanceof Collectible) {
            // Если предмет можно положить в инвентарь, задаем пользователю вопрос
            System.out.println("Хотите положить этот предмет в инвентарь?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            int choice = -1;
            while (choice < 1 || choice > 2) {
                System.out.print("Введите номер ответа: ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Введите число.");
                    scanner.nextLine();
                }
                if (choice < 1 || choice > 2) {
                    System.out.println("Некорректный номер ответа.");
                }
            }
            if (choice == 1) {
                // Если пользователь хочет положить предмет в инвентарь, добавляем его туда
                if (item.length < ITEM_SIZE) {
                    item[item.length] = selectedItem;
                    System.out.println(selectedItem.getName() + " добавлен в инвентарь.");
                } else {
                    System.out.println("Инвентарь полон.");
                }
            } else {
                // Если пользователь не хочет положить предмет в инвентарь, вызываем метод use
                selectedItem.use();
            }
        } else {
            // Если предмет нельзя положить в инвентарь, вызываем метод use
            selectedItem.use();
        }
        scanner.close();
    }
}

