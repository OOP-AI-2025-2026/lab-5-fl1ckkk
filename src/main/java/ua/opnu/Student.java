package ua.opnu;

public class Student extends Person {
    // Додаткові поля для студента
    private String group;
    private String studentId;

    // Конструктор
    public Student(String lastName, String firstName, int age, String group, String studentId) {
        super(lastName, firstName, age); // Виклик конструктора батьківського класу
        this.group = group;
        this.studentId = studentId;
    }

    // Гетери
    public String getGroup() {
        return group;
    }

    public String getStudentId() {
        return studentId;
    }

    // Сетери
    public void setGroup(String group) {
        this.group = group;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Студент групи " + group + ", " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Номер студентського квитка: " + studentId;
    }
}