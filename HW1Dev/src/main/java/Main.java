//Написать программу вычисления n-ого треугольного числа
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int a = getNumber("Введите число: ");
        int result = triangularResult(a);
        System.out.println(String.format("Для числа %d, треугольное число равно %d", a, result));
    }

    public static int getNumber(String text) {
        System.out.printf(text);
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число, попробуйте еще раз");
                scanner.next();
            }
            int number = scanner.nextInt();
            if (number < 1) {
                System.out.println("Число должно быть больше 0, попробуйте еще раз");
            } else {
                return number;
            }
        }
    }
    // // Формула расчета взята с сайти википедии
    // public static int triangularResult(int number) {
    //     if (number == 1) {
    //         return 1;
    //     }
    //     return triangularResult(number - 1) + number;
    // }

    // Вариант 2 без рекурсии
    public static int triangularResult(int number) {
        return ((number * (number + 1)) / 2);
    }

}
