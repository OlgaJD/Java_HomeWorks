// Разработать программу, имитирующую поведение коллекции HashSet.
// В программе содать метод add добавляющий элемент, и метод позволяющий выводить эллементы коллекции в консоль.
// Формат данных Integer.

import java.util.HashMap;
public class Main {
    private static HashMap<Integer, Object> hashMap = new HashMap<>();
    private static final Object OBJECT = new Object();
    public static void main(String[] args) {
        add(5);
        add(27);
        add(15);
        add(8);
        add(15);
        System.out.println(toStr());
    }
    public static void add(Integer num) {
        hashMap.put(num, OBJECT);
    }
    private static String toStr() {
        return hashMap.keySet().toString();
    }
}
