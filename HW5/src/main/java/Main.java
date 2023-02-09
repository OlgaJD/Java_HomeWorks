//1. Создать словарь HashMap. Обобщение <Integer, String>.
//2. Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключь, если не было!)
//3. Изменить значения сделав пол большой буквой.
//4. Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
//5. *Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.

import java.util.*;
public class Main {
    public static void main(String[] args) {
//      1.
        HashMap<Integer, String> peopleGroup = new HashMap<>();

//      2.
        peopleGroup.put(1, "Тюрикова Мария Викторовна 109 ж");
        peopleGroup.putIfAbsent(2, "Романов Алексей Дмитриевич 34 м");
        peopleGroup.putIfAbsent(3, "Миронов Артем Сергеевич 21 м");
        peopleGroup.putIfAbsent(4, "Одинцова Людмила Николаевна 56 ж");
        peopleGroup.putIfAbsent(5, "Зыкова Ирина Александровна 28 ж");

//      3-4. Вариант без изменения значений, только вывод.
        PrintSimpleInfo(peopleGroup);
        System.out.println();
//
//      3.
        peopleGroup = GenderToUpperCase(peopleGroup);
        peopleGroup.forEach((k, v) -> System.out.println(v));
//        GenderToUpperCase(peopleGroup).forEach((k, v) -> System.out.println(v)); // только вывод
        System.out.println();
//
//      4.
        Print(peopleGroup);
        System.out.println();

//      5.
        peopleGroup = AgeSortedHashMap(peopleGroup);
//        peopleGroup = GenderToUpperCase(peopleGroup); // значения изменены в 3 пункте
        Print(peopleGroup);

    }
    static void PrintSimpleInfo (HashMap<Integer, String> hashMap) {
        for (Integer key : hashMap.keySet()) {
            String[] person = hashMap.get(key).split(" ");
            System.out.println(person[0] + " " + person[1].charAt(0) + "." + person[2].charAt(0) + "." + " " + person[4].toUpperCase());
        }
    }

    static void Print (HashMap<Integer, String> hashMap) {
        for (Integer key : hashMap.keySet()) {
            String[] person = hashMap.get(key).split(" ");
            System.out.println(person[0] + " " + person[1].charAt(0) + "." + person[2].charAt(0) + "." + " " + person[4]);
        }
    }

    static HashMap<Integer, String> GenderToUpperCase(HashMap<Integer, String> hashMap) {
        for (Integer key : hashMap.keySet()) {
            StringBuilder person = new StringBuilder();
            person.append(hashMap.get(key));
            person.setCharAt((person.length()-1), Character.toUpperCase(person.charAt(person.length()-1)));
            hashMap.put(key, person.toString());
        }
        return hashMap;
    }

    static HashMap<Integer, String> AgeSortedHashMap(HashMap<Integer, String> hashMap) {
        ArrayList<Integer> age = new ArrayList<>();
        HashMap<Integer, String> ageSortedHM = new HashMap<>();
        for (Integer key : hashMap.keySet()) {
            String[] person = hashMap.get(key).split(" ");
            age.add(Integer.valueOf(person[3]));
        }
        Collections.sort(age);
        for (int i = 0; i < age.size(); i++) {
            for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                if (entry.getValue().contains((age.get(i).toString()))) {
                    ageSortedHM.put(i, entry.getValue());
                }
            }
        }
        return ageSortedHM;
    }

}