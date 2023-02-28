import java.util.Scanner;
public class Game {
    static boolean isGameFinished = false;

    private Kitchen kitchen;
    private Bathroom bathroom;
    private Bedroom bedroom;

    Game() {
        kitchen = new Kitchen("Кухня", "Большая кухня с совмещенной столовой.");
        bathroom = new Bathroom("Ванная комната", "Обычный совмещенный санузел.");
        bedroom = new Bedroom("Спальня", "Просторная спальня с двуспальной кроватью.");
    }

    Room[] rooms  = {kitchen, bathroom, bedroom};

    public Room[] getRooms() {
        return rooms;
    }
    public int showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Меню:");
            System.out.println("2. Показать инвентарь");
            System.out.println("1. Перейти в другую комнату");
            System.out.println("0. Выход");
            System.out.print("Введите номер действия: ");
            choice = scanner.nextInt();

            if (choice == 0 || choice == 1 || choice == 2) {
                break;
            } else {
                System.out.println("Ошибка: неверный ввод, попробуйте еще раз");
            }
        }

        return choice;
    }

    public int showRooms() {
        System.out.println("Выберите комнату:");

        for (int i = 0; i < rooms.length; i++) {
            System.out.println((i + 1) + ". " + rooms[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int roomNumber = scanner.nextInt();

        return roomNumber;
    }
    public static void main (String[] args) {
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");
        Player player = new Player();
        Scanner in = new Scanner(System.in);
        System.out.print("Введи ваше имя: ");
        String playerName = in.nextLine();
        player.name = playerName;

        Game game = new Game();
        player.setCurrentRoom(game.getRooms()[0]); // установим начальную комнату

        while (true) {
            if (game.isGameFinished) {
                System.out.println("Поздравляем, вы победили!");
                break;
            }
            int choice = game.showMenu();
            if (choice == 0) {
                System.out.println("Выход из игры.");
                break;
            } else if (choice == 1) {
                int roomNumber = game.showRooms();
                if (roomNumber > 0 && roomNumber <= game.getRooms().length) {
                    Room selectedRoom = game.getRooms()[roomNumber - 1];
                    player.setCurrentRoom(selectedRoom);
                    System.out.println("Вы перешли в комнату " + selectedRoom.getName());
                }
            } else if (choice == 2) {
                player.showItems();
            } else {
                System.out.println("Ошибка: неверный номер действия.");
            }
        }
        in.close();
    }

}
