package com.game.example;

import com.game.example.item.Collectible;
import com.game.example.item.Item;
import com.game.example.item.Key;
import com.game.example.item.Useful;
import com.game.example.room.Room;
import com.game.example.util.UserInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private static final int INVENTORY_MAX_SIZE = 10;

    private String name;
    private final List<Item> items = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private Room currentRoom;

    public Player() {
        this.currentRoom = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCurrentRoom(Room room) {
        System.out.println("Вы перешли в комнату " + room.getName());
        currentRoom = room;
    }

    public void openRoom(Room room) {
        if (room.isLocked()) {
            Item item = getKeyToOpenRoom(room);

            if (item == null) {
                System.out.println("Комната заперта! Нужен ключ!");
                return;
            }

            room.setLocked(false);
            items.remove(item);
        }

        setCurrentRoom(room);
    }

    private Item getKeyToOpenRoom(Room room) {
        for (Item item : items) {
            if (item instanceof Key && doesKeyOpenRoom((Key) item, room.getName())) {
                return item;
            }
        }

        return null;
    }

    private boolean doesKeyOpenRoom(Key key, String roomName) {
        String roomToOpen = key.getRoomToOpen();

        return roomToOpen != null && roomToOpen.equals(roomName);
    }

    public void showItems() {
        System.out.println("Предметы в инвентаре:");
        int itemNumber = 0;

        for (Item item : items) {
            if (item != null) {
                itemNumber++;
                System.out.printf("%d. %s;%n", itemNumber, item.getName());
            }
        }
    }

    public void interact() {
        currentRoom.printItems();

        if (currentRoom.hasItems()) {
            interactWithItems(currentRoom.getItems());
        }
    }

    private void interactWithItems(List<Item> roomItems) {
        Item item = chooseItem(roomItems);

        if (item instanceof Collectible && !isInventoryFull()) {
            int itemActionNumber;

            do {
                System.out.printf("Выбранный предмет %s. Что с ним сделать?%n", item.getName());
                System.out.println("1. Положить в инвентарь");
                System.out.println("2. Использовать");
                System.out.println("3. Оставить");

                itemActionNumber = UserInput.getNumberInput(scanner);
            } while (itemActionNumber != 1 && itemActionNumber != 2 && itemActionNumber != 3);

            if (itemActionNumber == 1) {
                putItemToInventory(item);
            } else if (itemActionNumber == 2) {
                useItem(item);
            }

            return;
        }

        useItem(item);
    }

    private Item chooseItem(List<Item> roomItems) {
        int itemNumber;
        int itemIndex;

        do {
            System.out.println("Введите номер предмета:");

            itemNumber = UserInput.getNumberInput(scanner);
            itemIndex = itemNumber - 1;
        } while (itemIndex < 0 || itemIndex >= roomItems.size());

        return roomItems.get(itemIndex);
    }

    private void useItem(Item item) {
        ((Useful) item).use();
    }

    private void putItemToInventory(Item item) {
        items.add(item);
        currentRoom.removeItemFromRoom(item);
    }

    private boolean isInventoryFull() {
        return items.size() == INVENTORY_MAX_SIZE;
    }

    public boolean isInventoryEmpty() {
        return items.isEmpty();
    }

    public boolean useItemFromInventory(int itemNumber) {
        if (itemNumber == 0) {
            return true;
        }

        int itemIndex = itemNumber - 1;

        if (itemIndex < 0 || itemIndex >= items.size()) {
            System.out.println("Неправильный ввод. Введите вариант из списка.");
            return false;
        }

        Item item = items.get(itemIndex);

        ((Useful) item).use();
        items.remove(item);

        return true;
    }
}
