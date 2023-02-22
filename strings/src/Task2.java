import java.util.Scanner;

public class Task2 {
    public static void main (String[] args)
    {
        int shifrNumber;
        String word = "";
        Scanner in = new Scanner(System.in);

        System.out.print("Введите слово (англ.): ");
        word = in.nextLine();

        System.out.print("Введите шифр: ");
        shifrNumber = in.nextInt();

        in.close();

        char[] shifr = new char[word.length()];

        for (int i=0; i < word.length(); i++)  {shifr[i] = word.charAt(i);}

        for (int i=0; i < shifr.length; i++)
        {
            char temp = shifr[i];
            int ascii = (int)temp+shifrNumber;

            if (ascii > 'z')
            {
                ascii = ascii - 26;
                //shifr[i] = (char)ascii; -> не работает, если эту строку вставить в if ([!] разобраться).
            }

            if (ascii < 'a')
            {
                ascii = ascii + 26;
                //shifr[i] = (char)ascii; -> не работает, если эту строку вставить в if ([!] разобраться).
            }
            shifr[i] = (char)ascii;
        }

        String encryptedWord = String.valueOf(shifr);

        System.out.print("Исходное сообщение: " + word + ", зашифрованное сообщение: " + encryptedWord + ", шифр: " + shifrNumber);

    }
}