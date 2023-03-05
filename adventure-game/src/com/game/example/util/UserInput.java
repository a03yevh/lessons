package com.game.example.util;

import java.util.Scanner;

public final class UserInput {
    private UserInput() {
        // util class
    }

    public static int getNumberInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Ошибка: неверный ввод, попробуйте еще раз");
        }

        return scanner.nextInt();
    }
}
