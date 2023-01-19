public class Main {
    public static void main(String[] args) {
//        1-2.
        String str1 = "In a hole in the ground there lived a hobbit...";
        String str2 = "round";
        isStrContainStr(str1, str2);  // 1. найти вхождение в строке (содержащей все символы другой строки)
        isStrContainStr(str1, new StringBuilder(str2).reverse().toString()); // 2. проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке)

//        3. перевернуть строку с помощью рекурсии
        System.out.println(recursionReverse(str1));

//        4-6. С созданием переменных
        StringBuilder sb = new StringBuilder(makeText(3, 56, '+'));
        int index = sb.indexOf("=");
        sb.deleteCharAt(index).insert(index, "равно");
        sb.replace(index, index+1, "равно");

//        4-6. Сразу вывод результата
        System.out.println(makeText(3, 56 , '-')); // 4. составить строки используя StringBuilder.append()
        System.out.println(makeText(3, 56 , '-').deleteCharAt((makeText(3, 56 , '-').indexOf("="))).insert((makeText(3, 56 , '-').indexOf("=")), "равно"));  // 5 Заменить символ “=” на слово “равно”. методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        System.out.println(makeText(3, 56 , '-').replace((makeText(3, 56 , '-').indexOf("=")),((makeText(3, 56 , '-').indexOf("=")))+1, "равно"));  // 6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().

//        7. Сравнить время выполнения
        StringBuilder test1 = addSymbols(sb);
        StringBuilder test2 = addSymbols(sb);
        String test3 = test1.toString();

//        Для StringBuilder Вариант 1
        double begin = System.currentTimeMillis();
        for (int i = test1.indexOf("="); i < test1.lastIndexOf("="); i++) {
            test1.replace(test1.indexOf("="), test1.indexOf("=")+1, "равно");
        }
        System.out.println(System.currentTimeMillis() - begin);

//        StringBuilder Вариант 2
        begin = System.currentTimeMillis();
        int sIndex;
        while ((sIndex = test2.indexOf("=")) != -1) {
            test2.replace(sIndex, sIndex+1, "равно");
        }
        System.out.println(System.currentTimeMillis() - begin);

//        Для String

        begin = System.currentTimeMillis();
        test3.replace("=", "равно");
        System.out.println(System.currentTimeMillis() - begin);

    }
    private static void isStrContainStr(String str1, String str2) {
        System.out.println(str1.contains(str2));
    }

    private static StringBuilder makeText(int x, int y, char simbol) {
        int result =0;
        char p = ' ';
        switch (simbol) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
        }
        StringBuilder text = new StringBuilder("");
        text.append(Integer.toString(x) + p + simbol + p + Integer.toString(y) + p + "=" + p + Integer.toString(result));
        return text;
    }

    public static String recursionReverse(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return recursionReverse(str.substring(1)) + str.charAt(0);
    }

    public static StringBuilder addSymbols(StringBuilder str) {
        for (int i = 0; i <10001; i++) {
            str.append('=');
        }
        return str;
    }

}
