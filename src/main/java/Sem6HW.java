
// Задание:
// Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать, что во входной
// структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными
// телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sem6HW {
    public static void main(String[] args) {
                PhoneBook pb = new PhoneBook();
                pb.put("Jane", 1000);
                pb.put("Jane", 1001);
                pb.put("Jane", 1002);
                System.out.println(pb.find("Alex"));
                System.out.println(pb.find("Jane"));

                pb.put("Daniel", 1003);
                pb.put("Daniel", 1004);
                pb.put("Daniel", 1005);
                pb.put("Daniel", 1006);
                pb.put("Jake", 1007);
                pb.put("Jake", 1008);
                pb.put("Jake", 1009);
                pb.getPhoneBook();
            }
        }

        class PhoneBook {
            private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

            public void put(String name, Integer phoneNum) {
                ArrayList<Integer> phones = new ArrayList<>();

                if (phoneBook.containsKey(name)) phones.addAll(phoneBook.get(name));
                if (!phones.contains(phoneNum)) phones.add(phoneNum);

                if (!phoneBook.containsKey(name)) phoneBook.put(name, phones);
                else phoneBook.replace(name, phones);
            }

            public ArrayList<Integer> find(String name) {
                if (!phoneBook.containsKey(name)) return new ArrayList<Integer>();
                return phoneBook.get(name);
            }

            public void getPhoneBook() {
                List<Map.Entry<String, ArrayList<Integer>>> entries = new ArrayList<>(phoneBook.entrySet());
                entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

                phoneBook.clear();
                for (Map.Entry<String, ArrayList<Integer>> entry : entries) phoneBook.put(entry.getKey(), entry.getValue());

                System.out.println(entries);

    }
}
