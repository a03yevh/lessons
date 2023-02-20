//Знаю, что можно было сделать проще через if, не используя switch.
//Но так как "просто if" был в Task1, в Task2 же решил чуть "разнообразить" switch-ом.
public class Task2 {
    public static void main (String[] args)
    {
        int amountMoney = 500000;
        String industryName = "Transport";
        double tax = 0, taxAmount = 0;

        switch (industryName) {
            case "Health": {
                if (amountMoney < 400000) {tax = 7; taxAmount = (amountMoney * tax)/100;}
                else if (amountMoney >= 400000 && amountMoney <= 899999) {tax = 12; taxAmount = (amountMoney * tax)/100;}
                else if (amountMoney >= 900000) {tax = 15; taxAmount = (amountMoney * tax)/100;}
                System.out.println("[Task 2] Налог на сумму: " + amountMoney + " для отрасли " + industryName + " составляет: " + taxAmount + ". Это составляет: " + tax +  " процентов.");
            }
            break;

            case "Bank": {
                if (amountMoney < 250000) {tax = 10; taxAmount = (amountMoney * tax)/100;}
                else if (amountMoney >= 250000 && amountMoney <= 499999) {tax = 15; taxAmount = (amountMoney * tax)/100;}
                else if (amountMoney >= 500000) {tax = 18; taxAmount = (amountMoney * tax)/100;}
                System.out.println("[Task 2] Налог на сумму: " + amountMoney + " для отрасли " + industryName + " составляет: " + taxAmount + ". Это составляет: " + tax +  " процентов.");
            }
            break;

            case "Transport": {
                if (amountMoney < 100000) {tax = 9; taxAmount = (amountMoney * tax)/100;}
                else if (amountMoney >= 100000 && amountMoney <= 299999) {tax = 13; taxAmount = (amountMoney * tax)/100;}
                else if (amountMoney >= 300000) {tax = 17; taxAmount = (amountMoney * tax)/100;}
                System.out.println("[Task 2] Налог на сумму: " + amountMoney + " для отрасли " + industryName + " составляет: " + taxAmount + ". Это составляет: " + tax +  " процентов.");
            }
            break;

            default: {
                System.out.println("[Task 2] Ошибка: Вы ввели незвестную индустрию!");
            }
        }

    }
}
