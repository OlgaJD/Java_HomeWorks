//1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
//2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
//4.Отсортировать по возрасту используя дополнительный список индексов.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("db.sql");
        writer.append("Иванов Иван Иванович 32 М\n");
        writer.append("Петрова Петра Петровна 12 Ж\n");
        writer.append("Сидоров Сидр Сидрович 100 М\n");
        writer.append("Антонова Ирина Викторовна 50 Ж\n");
        writer.append("Мартынова Татьяна Владимировна 10 Ж\n");
        writer.flush();
        writer.close();
        
        String text = "";
        FileReader reader = new FileReader("db.sql");
        while (reader.ready()) {
            text += (char) reader.read();
        }
        reader.close();

        ArrayList<String> firstname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> midlename = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

//          1. Вывод в строку
        System.out.println(text);

        String[] content = text.split("\n");
        for (int i = 0; i < content.length; i++) {
            String[] info = content[i].split(" ");
//            2. Вывод в формате Фамилия И.О. лет пол
            System.out.println(info[0] + " " + info[1].charAt(0) + "." + info[2].charAt(0) + "." + " " + info[3] + " " + info[4]);
//            3. Текст загрузить в подготовленные списки
            firstname.add(info[0]);
            name.add(info[1]);
            midlename.add(info[2]);
            age.add((Integer.valueOf(info[3])));
            gender.add(info[4].equals("М") ? true : false);
            index.add(i);
        }
        System.out.println();

//        4.Отсортировать по возрасту используя дополнительный список индексов.
        ArrayList<Integer> tmpAge = new ArrayList<>(age);
        tmpAge.sort(new Comparator<Integer>() {
             @Override
             public int compare(Integer o1, Integer o2) {
                 return o1-o2;
             }
        });
        for (int i = 0; i < tmpAge.size(); i++) {
            int j = age.indexOf(tmpAge.get(i));
            index.set(i, j);
        }
        for (int i = 0; i < index.size(); i++) {
            System.out.printf(firstname.get(index.get(i)) + " ");
            System.out.printf(name.get(index.get(i)).charAt(0) + ".");
            System.out.printf(midlename.get(index.get(i)).charAt(0) + "." + " ");
            System.out.printf(age.get(index.get(i)).toString() + " ");
            System.out.printf(gender.get(index.get(i)) ? "М" : "Ж");
            System.out.println();
        }
    }

}

