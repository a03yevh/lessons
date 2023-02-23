import java.util.Scanner;

public class Task1 {
    public static void main (String[] args)
    {
        int[] myArray = new int[5];
        Scanner in = new Scanner(System.in);
        for (int i=0; i < 5; i++)
        {
            System.out.print("Введите число: ");
            myArray[i] = in.nextInt();
        }
        in.close();

        System.out.println("\n=====================");
        for (int i = 0; i < 5; i++)
        {
            if (myArray[i] % 2 == 0) {System.out.println("Число: " + myArray[i] + " - четное.");}
            else {System.out.println("Число: " + myArray[i] + " - нечетное.");}
        }
        System.out.println("=====================");
    }
}