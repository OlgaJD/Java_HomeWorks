import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int i = getRndNumber();
        int n = getMSbit(i);
        ArrayList<Integer> m1 = multiplesArraySMaxV(i, n);
        ArrayList<Integer> m2 = notMultiplesArraySMinV(i, n);

        print(String.valueOf(i+"\n" +"В двоичной системе = "+ Integer.toBinaryString(i) + "\n" +n +"\n" + m1 +"\n" + m2));
    }
    static void print(String text) {
        System.out.println(text);
    }

    //        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
    static int getRndNumber() {
        return new Random().nextInt(0, 2001);
    }

    //        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа (через побитовый сдвиг)
    static int getMSbit(int number) {
        int MSbit = 0;
        while (number != 1) {
            number >>=1;
            MSbit++;
        }
        return MSbit;
    }

    //    3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    static ArrayList<Integer> multiplesArraySMaxV (int number, int MSbit) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (number <= Short.MAX_VALUE) {
            if (number % MSbit == 0) {
                array.add(number);
            }
            number++;
        }
        return array;
    }

    //    4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    static ArrayList<Integer> notMultiplesArraySMinV (int number, int MSbit) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int temp = Short.MIN_VALUE;
        while (temp <= number) {
            if (temp % MSbit != 0) {
                array.add(temp);
            }
            temp++;
        }
        return array;
    }
}