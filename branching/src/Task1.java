public class Task1 {
    public static void main (String[] args)
    {
        int finalGrade = 71;
        if (finalGrade <= 25 && finalGrade >= 1)  { System.out.println("[Task 1] Оценка: Плохо."); }
        else if (finalGrade <= 50 && finalGrade >= 26)  { System.out.println("[Task 1] Оценка: Ниже среднего."); }
        else if (finalGrade <= 75 && finalGrade >= 51)  { System.out.println("[Task 1] Оценка: Выше среднего."); }
        else if (finalGrade <= 100 && finalGrade >= 76)  { System.out.println("[Task 1] Оценка: Отлично."); }
        else
        {
            { System.out.println("[Task 1] Ошибка: веденная переменная < 1 или > 100!"); }
        }
    }
}
