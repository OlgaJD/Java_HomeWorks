import java.util.Scanner;
//Дана прямоугольная карта размера MxN (N, M меньше 20)
//        На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
//        Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку
//        * * На карте могут быть стены
//        * ** M и N могут быть до 1000
//        Задачу разбить на методы
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        CountSteps();
    }
    public static int GetNumber(String text) {
        System.out.printf(text);
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число, попробуйте еще раз");
                scanner.next();
            }
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Число должно быть равно 0 больше 0, попробуйте еще раз");
            } else {
                return number;
            }
        }
    }
    public static int CountSteps() {
        int m = GetNumber("Введите количетство столбцов карты: ");
        int n = GetNumber("Введите количетство строк карты: ");
        int x = GetNumber("Введите координату X для точки старта, она не должна превышать количество введенных столбцов: ");
        int y = GetNumber("Введите координату Y для точки старта, она не должна превышать количество введенных строк: ");
        int[][] field = new int[m][n];
        for (int i = x; i < m; i++) {
            field[i][y] = 1;
        }
        for (int j = y; j < n; j++) {
            field[x][j] = 1;
        }
        for (int i = x + 1; i < m; i++) {
            for (int j = y + 1; j < n; j++) {
                field[i][j] = field[i - 1][j] + field[i][j - 1];
            }
        }
        System.out.println("Количество маршрутов для прохожения карты " + field[m - 1][n - 1]);
        return field[m - 1][n - 1];
    }
}