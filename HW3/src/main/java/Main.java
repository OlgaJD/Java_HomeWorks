import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();

//        1 Объявить два списка список ArrayList, в каждый добавить по 20 случайных чисел.
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(rnd.nextInt(50));
        }
        System.out.println(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list2.add(rnd.nextInt(50));
        }
        System.out.println(list2);

//        Удалить из первого списка элементы отсутствующие во втором списке.
        System.out.println("Удаление элементов");
        list1.retainAll(list2);
        System.out.println(list1);

//        Отсортировать первый список методом sort класса Collections.
        System.out.println("Сортировка первого списка методом sort класса Collections");
        Collections.sort(list1);
        System.out.println(list1);

//        2 * Отсортировать второй список методом sort списка и компаратором по уменьшению.
        System.out.println("Сортировка второго списка методом sort списка и компаратором по уменьшению");
        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list2);

//        3 **Отсортировать первый список пузырьковой сортировкой самостоятельно, без использования доп методов и классов.
        System.out.println("Сортировка пузырьком");
        int[] list = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            list[i] = list1.get(i);
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                int tmp = list[i];
                if (tmp < list[j]) {
                    int tmp2 = list[j];
                    list[i] = tmp2;
                    list[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }

}
