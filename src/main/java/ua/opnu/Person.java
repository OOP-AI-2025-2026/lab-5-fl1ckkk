package ua.opnu;

public class Person {
    // Поля класу
    private String lastName;
    private String firstName;
    private int age;

    // Конструктор
    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    // Гетери
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    // Сетери
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Людина " + lastName + " " + firstName + ", вік: " + age;
    }
}