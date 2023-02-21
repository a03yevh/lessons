public class Task1 {
    public static void main (String[] args)
    {
        String[] name = new String[] {"John", "Bob", "Mary", "Peter", "Sarah"};
        System.out.println("============[loop: for]==============");
        for (int i=0; i<name.length; i++)
        {
            if (name[i].length() < 4) {System.out.println("Ваше имя короче 4 букв, (имя: " + name[i] + ")");}
            else if (name[i].length() > 4) {System.out.println("Ваше имя длиннее 4 букв, (имя: "+ name[i] + ")");}
            else {
                System.out.println("Ваше имя состоит из 4 букв, (имя: "+ name[i] + ")");;
            }
        }
        System.out.println("=====================================");

        System.out.println("\n============[loop: while]==============");
        int i = 0;
        while (i < name.length)
        {
            if (name[i].length() < 4) {System.out.println("Ваше имя короче 4 букв, (имя: " + name[i] + ")");}
            else if (name[i].length() > 4) {System.out.println("Ваше имя длиннее 4 букв, (имя: "+ name[i] + ")");}
            else {
                System.out.println("Ваше имя состоит из 4 букв, (имя: "+ name[i] + ")");;
            }
            i++;
        }
        System.out.println("=======================================");

        System.out.println("\n============[loop: do...while]==============");
        int j = 0;
        do {
            if (name[j].length() < 4) {System.out.println("Ваше имя короче 4 букв, (имя: " + name[j] + ")");}
            else if (name[j].length() > 4) {System.out.println("Ваше имя длиннее 4 букв, (имя: "+ name[j] + ")");}
            else {
                System.out.println("Ваше имя состоит из 4 букв, (имя: "+ name[j] + ")");;
            }
            j++;
        }
        while (j < (name.length));
        System.out.println("============================================");
    }
}
