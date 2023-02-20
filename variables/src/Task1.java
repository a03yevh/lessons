public class Task1 {
    public static void main (String[] args)
    {
        byte temp1 = 15;
        short temp2 = 2992;
        int temp3 = 90;
        long temp4 = 2824433244334324l;
        float temp5 = 3.14f;
        double temp6 = 15.2;
        char temp7 = 'M';
        boolean temp8 = false;
        String temp9 = "It's test message";
        System.out.println(temp1);
        System.out.println(temp2);
        System.out.println(temp3);
        System.out.println(temp4);
        System.out.println(temp5);
        System.out.println(temp6);
        System.out.println(temp7);
        System.out.println(temp8);
        System.out.println(temp9);


        int MathOperation1 = temp1+temp2;
        int MathOperation2 = temp1*temp2;
        double MathOperation3 = (double)temp1/(double)temp2;
        int MathOperation4 = temp3-temp1;
        int MathOperation5 = (temp1+temp2)*temp3;
        float MathOperation6 = temp5 + (float)temp6;

        System.out.println("===============================");
        System.out.println("Result MathOperation1 -> " + MathOperation1);
        System.out.println("Result MathOperation2 -> " + MathOperation2);
        System.out.println("Result MathOperation3 -> " + MathOperation3);
        System.out.println("Result MathOperation4 -> " + MathOperation4);
        System.out.println("Result MathOperation5 -> " + MathOperation5);
        System.out.println("Result MathOperation6 -> " + MathOperation6);
        System.out.println("===============================");
    }
}
