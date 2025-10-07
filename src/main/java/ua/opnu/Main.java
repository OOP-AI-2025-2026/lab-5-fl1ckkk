package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкти за допомогою висхідного перетворення
        Person person1 = new Student("Петренко", "Іван", 20, "КН-21", "KN21001");
        Person person2 = new Lecturer("Іваненко", "Марія", 45, "Комп'ютерних наук", 25000.0);
        Person person3 = new Student("Сидоренко", "Олена", 19, "ПМ-22", "PM22015");
        Person person4 = new Lecturer("Коваленко", "Олександр", 52, "Математики", 28000.0);
        Person person5 = new Person("Шевченко", "Тарас", 30);
        Person person6 = new Student("Мельник", "Андрій", 21, "ФІ-20", "FI20025");

        // Створюємо масив, який може містити об'єкти Person, Student та Lecturer
        Person[] people = new Person[6];

        // Заповнюємо масив об'єктами
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;
        people[3] = person4;
        people[4] = person5;
        people[5] = person6;

        // Виводимо інформацію про кожен об'єкт за допомогою циклу
        System.out.println("=== Інформація про всіх людей у масиві ===\n");

        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + ". " + people[i].toString());
        }

        // Альтернативний варіант з використанням foreach
        System.out.println("\n=== Альтернативний вивід (foreach) ===\n");

        int counter = 1;
        for (Person person : people) {
            System.out.println(counter + ". " + person.toString());
            counter++;
        }

        // Демонстрація поліморфізму
        System.out.println("\n=== Демонстрація поліморфізму ===\n");

        for (Person person : people) {
            // Перевіряємо тип об'єкта за допомогою instanceof
            if (person instanceof Student) {
                System.out.println("Це студент: " + ((Student) person).getGroup());
            } else if (person instanceof Lecturer) {
                System.out.println("Це викладач: " + ((Lecturer) person).getDepartment());
            } else {
                System.out.println("Це звичайна людина");
            }
        }
    }
}