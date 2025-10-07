package ua.opnu;

public class Lecturer extends Person {
    // Додаткові поля для викладача
    private String department;
    private double salary;

    // Конструктор
    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age); // Виклик конструктора батьківського класу
        this.department = department;
        this.salary = salary;
    }

    // Гетери
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Сетери
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Викладач кафедри " + department + ", " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Зарплата: " + salary;
    }
}