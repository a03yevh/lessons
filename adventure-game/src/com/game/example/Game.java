package com.game.example;

import com.game.example.room.Anteroom;
import com.game.example.room.Bathroom;
import com.game.example.room.Bedroom;
import com.game.example.room.GuestRoom;
import com.game.example.room.Kitchen;
import com.game.example.room.Room;
import com.game.example.util.UserInput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static boolean isGameFinished = false;

    private static final Scanner SCANNER = new Scanner(System.in);

    private final List<Room> rooms;

    public Game() {
        rooms = Arrays.asList(
                new Kitchen("Кухня", "Большая кухня с совмещенной столовой."),
                new Bathroom("Ванная комната", "Обычный совмещенный санузел."),
                new Bedroom("Спальня", "Просторная спальня с двуспальной кроватью."),
                new GuestRoom("Гостевая", "Пустая гостевая"),
                new Anteroom("Прихожая", "Прихожая с шкафом и тумбочкой")
        );
    }


    public List<Room> getRooms() {
        return rooms;
    }

    private int showMenu() {
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("3. Иследовать комнату");
            System.out.println("2. Показать инвентарь");
            System.out.println("1. Перейти в другую комнату");
            System.out.println("0. Выход");
            System.out.print("Введите номер действия: ");

            choice = UserInput.getNumberInput(SCANNER);
        } while (choice != 0 && choice != 1 && choice != 2 && choice != 3);

        return choice;
    }

    private int chooseRoomNumber() {
        System.out.println("Выберите комнату:");

        for (int i = 0; i < rooms.size(); i++) {
            System.out.println((i + 1) + ". " + rooms.get(i).getName());
        }

        // Ждем от пользователя ввода порядкового номера комнаты и возвращаем
        return UserInput.getNumberInput(SCANNER);
    }

    public void startGame() {
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");

        Player player = new Player();

        System.out.print("Введи ваше имя: ");
        player.setName(SCANNER.nextLine());

        player.setCurrentRoom(getRooms().get(0)); // установим начальную комнату

        while (true) {
            if (isGameFinished) {
                System.out.printf("Поздравляем, %s, вы победили!%n", player.getName());
                break;
            }

            int choice = showMenu();

            if (choice == 0) {
                System.out.println("Выход из игры.");
                break;
            } else if (choice == 1) {
                enterToRoom(player);
            } else if (choice == 2) {
                interactWithPlayerInventory(player);
            } else if (choice == 3) {
                player.interact();
            } else {
                System.out.println("Ошибка: неверный номер действия.");
            }
        }

        SCANNER.close();
    }

    private void enterToRoom(Player player) {
        int roomNumber = chooseRoomNumber();

        if (roomNumber > 0 && roomNumber <= getRooms().size()) {
            Room selectedRoom = getRooms().get(roomNumber - 1);

            player.openRoom(selectedRoom);
        } else {
            System.out.println("Ошибка: выбранная комната не существует.");
        }
    }

    private void interactWithPlayerInventory(Player player) {
        if (player.isInventoryEmpty()) {
            System.out.println("Инвентарь пуст.");
            return;
        }

        player.showItems();
        System.out.println("Выберите предмет, что б использовать его или 0 для отемены:");
        int itemNumber;

        do {
            itemNumber = UserInput.getNumberInput(SCANNER);
        } while (!player.useItemFromInventory(itemNumber));
    }
}
