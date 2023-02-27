import java.util.Scanner;
public class Game {
    static boolean isGameFinished = false;
    private Bathroom bathroom;
    private Bedroom bedroom;
    private Kitchen kitchen;

    public Game() {
        this.bathroom = new Bathroom("Ванная комната", "Обычный совмещенный санузел.");
        this.bedroom = new Bedroom("Спальня", "Просторная спальня с двуспальной кроватью.");
        this.kitchen = new Kitchen("Кухня", "Большая кухня с совмещенной столовой.");
    }
    public static void main (String[] args) {
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");
        Player player = new Player();
        Scanner in = new Scanner(System.in);
        System.out.print("Введи ваше имя: ");
        String playerName = in.nextLine();
        player.name = playerName;
        in.close();

        Game mygame = new Game();

        System.out.println("Привет, " + player.name + "!");
        System.out.println("В доме есть следующие комнаты:");
        System.out.println(mygame.bathroom.name + " -> " + mygame.bathroom.description);
        System.out.println(mygame.bedroom.name + " -> " + mygame.bedroom.description);
        System.out.println(mygame.kitchen.name + " -> " + mygame.kitchen.description);
    }
}
