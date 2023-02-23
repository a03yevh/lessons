import java.util.Scanner;

//realization for all.

public class Task3 {
    public static void main (String[] args) {
        int shifrNumber;
        String word = "";
        Scanner in = new Scanner(System.in);

        System.out.print("Введите слово (англ.): ");
        word = in.nextLine();

        System.out.print("Введите шифр: ");
        shifrNumber = in.nextInt();

        in.close();

        char[] shifr = word.toCharArray();

        for (int i=0; i < shifr.length; i++) {
            char temp = shifr[i];
            int ascii = (int)temp+shifrNumber;
            shifr[i] = (char)ascii;
        }

        String encryptedWord = String.valueOf(shifr);

        String message = String.format("Исходное сообщение: %s, зашифрованное сообщение: %s, шифр: %d", word, encryptedWord, shifrNumber);
        System.out.println(message);
    }
}