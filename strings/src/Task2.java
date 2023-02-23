import java.util.Scanner;

//realization only for a-z, A-Z.

public class Task2 {
    public static void main (String[] args) {
        int shifrNumber;
        String word = "";
        Scanner in = new Scanner(System.in);

        System.out.print("Введите слово (англ.): ");
        word = in.nextLine();

        System.out.print("Введите шифр: ");
        shifrNumber = in.nextInt();

        in.close();

//        char[] shifr = new char[word.length()];
//
//        for (int i=0; i < word.length(); i++)  {
//            shifr[i] = word.charAt(i);
//        }

        char[] shifr = word.toCharArray(); // заменяем лоигку 19-23 строк одной строкой.

        for (int i=0; i < shifr.length; i++) {
            char temp = shifr[i];
            int ascii = (int)temp+shifrNumber;

            if (Character.isUpperCase(temp)) {
                if (ascii > 'Z') {
                    ascii = ascii - 26;
                }
                if (ascii < 'A') {
                    ascii = ascii + 26;
                }
            }

            else {
                if (ascii > 'z') {
                    ascii = ascii - 26;
                }

                if (ascii < 'a') {
                    ascii = ascii + 26;
                }
            }
            shifr[i] = (char)ascii;
        }

        String encryptedWord = String.valueOf(shifr);

        String message = String.format("Исходное сообщение: %s, зашифрованное сообщение: %s, шифр: %d", word, encryptedWord, shifrNumber);
        System.out.println(message);
    }
}