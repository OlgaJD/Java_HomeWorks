// Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
// Пример 1: а = 3, b = 2, ответ: 9
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000

import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        File fileIn = new File("input.txt");
        File fileOut = new File("output.txt");
        writeToFile(fileOut, getResult(getNumbers(fileIn)));
    }
    public static int[] getNumbers(File filename) throws IOException {
        BufferedReader input= new BufferedReader(new FileReader(filename));
        String text;
        String a = "";
        String b = "";
        char ch;
        while ((text = input.readLine()) != null) {
            if (text.contains("a")) {
                for (int i = 0; i < text.length(); i++) {
                    ch = text.charAt(i);
                    if (Character.isDigit(ch))
                        a += ch;
                }
                if (text.contains("-")) {
                    a = "-" + a;
                }
            } else if (text.contains("b")) {
                for (int i = 0; i < text.length(); i++) {
                    ch = text.charAt(i);
                    if (Character.isDigit(ch))
                        b += ch;
                }
                if (text.contains("-")) {
                    b = "-" + b;
                }
            }
        }
        input.close();
        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);
        int[] numbers = {numberA, numberB};
        return numbers;
    }

    public static double degree(int value, int degreeValue) {
        double result = 1;
        if (degreeValue < 0) {
            for (int i = degreeValue; i < 0; i++) {
                result /= value;
            }
        } else {
            for (int i = 1; i <= degreeValue; i++) {
                result *= value;
            }
        }
        return result;
    }

    public static String getResult (int[] numbersArray) {
        String result = "";
        double res;
        int a = numbersArray[0];
        int b = numbersArray[1];
        if (a == 0) {
            result = "Не определено";
        } else {
            res = degree(a,b);
            result = Double.toString(res);
        }
        return result;
    }
    public static void writeToFile(File file, String strOut) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(strOut);
        writer.flush();
        writer.close();
    }

}






















//        //    парсим строку
//        String s = "dkvd:-12354l";
//        int pos = s.indexOf(":");  // находим разделитель и берем значение после него
//        System.out.println(pos);
//        System.out.println(s);
//        System.out.println(Integer.parseInt(s.substring(pos+ 1)));


//        Задача 2 для дз 3
//                Найти сколько вариантов путей. поле 8х8
//        Фигура ходит только вниз или вправо.
//        Дополнительно если есть препятствия
//        +допонлительно есть поле не 8х8, а 1000х1000

//        основной код-функция в 2 цикла
//        for (int i = 0; i < длина ; i++) {
//            for (int j = 0; j < высота; j++) {
//                a[i][j] = a[i-1][j] + a[i][j-1]
//                  прогнать по n(квадрат) числам
//        если препятствие - в клетке 0 - то в формуле ппринудительно стоит 0, формула при этом не меняется

//            }
//        }


//
//    }
//
//
//
//}
