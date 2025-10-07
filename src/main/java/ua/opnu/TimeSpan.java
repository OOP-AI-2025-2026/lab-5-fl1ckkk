package ua.opnu;

public class TimeSpan {
    // Приватні поля для зберігання годин та хвилин
    private int hours;
    private int minutes;

    // Конструктор без аргументів (0 годин, 0 хвилин)
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // Конструктор з 1 аргументом (хвилини)
    public TimeSpan(int minutes) {
        this(0, minutes); // Викликаємо конструктор з 2 аргументами
    }

    // Конструктор з 2 аргументами (години та хвилини)
    public TimeSpan(int hours, int minutes) {
        setTime(hours, minutes);
    }

    // Конструктор з 1 аргументом типу TimeSpan (копіюючий конструктор)
    public TimeSpan(TimeSpan other) {
        this(other.hours, other.minutes);
    }

    // Приватний метод для нормалізації часу (переведення хвилин у години)
    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        } else if (minutes < 0) {
            // Обробка від'ємних хвилин
            int totalMinutes = hours * 60 + minutes;
            if (totalMinutes < 0) {
                hours = 0;
                minutes = 0;
            } else {
                hours = totalMinutes / 60;
                minutes = totalMinutes % 60;
            }
        }
    }

    // Метод для встановлення часу
    public void setTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    // Гетери
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // Метод додавання часу з 2 аргументами (години та хвилини)
    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    // Метод додавання часу з 1 аргументом (хвилини)
    public void add(int minutes) {
        add(0, minutes); // Викликаємо метод з 2 аргументами
    }

    // Метод додавання часу з 1 аргументом типу TimeSpan
    public void add(TimeSpan other) {
        add(other.hours, other.minutes);
    }

    // Метод віднімання часу з 2 аргументами (години та хвилини)
    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        // Переконуємося, що час не стає від'ємним
        if (this.hours < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else if (this.minutes < 0) {
            if (this.hours > 0) {
                this.hours--;
                this.minutes += 60;
            } else {
                this.minutes = 0;
            }
        }
        normalize();
    }

    // Метод віднімання часу з 1 аргументом (хвилини)
    public void subtract(int minutes) {
        subtract(0, minutes); // Викликаємо метод з 2 аргументами
    }

    // Метод віднімання часу з 1 аргументом типу TimeSpan
    public void subtract(TimeSpan other) {
        subtract(other.hours, other.minutes);
    }

    // Метод для отримання загальної кількості хвилин
    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // Перевизначення методу toString для зручного виводу
    @Override
    public String toString() {
        return String.format("%d год. %d хв.", hours, minutes);
    }

    // Перевизначення методу equals для порівняння об'єктів TimeSpan
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TimeSpan timeSpan = (TimeSpan) obj;
        return hours == timeSpan.hours && minutes == timeSpan.minutes;
    }

    // Демонстраційний метод main для тестування
    public static void main(String[] args) {
        // Тестування конструкторів
        System.out.println("=== Тестування конструкторів ===");
        TimeSpan ts1 = new TimeSpan(); // 0 год. 0 хв.
        TimeSpan ts2 = new TimeSpan(90); // 1 год. 30 хв.
        TimeSpan ts3 = new TimeSpan(2, 45); // 2 год. 45 хв.
        TimeSpan ts4 = new TimeSpan(ts3); // Копія ts3

        System.out.println("ts1 (без аргументів): " + ts1);
        System.out.println("ts2 (90 хвилин): " + ts2);
        System.out.println("ts3 (2 год. 45 хв.): " + ts3);
        System.out.println("ts4 (копія ts3): " + ts4);

        // Тестування методів додавання
        System.out.println("\n=== Тестування додавання ===");
        TimeSpan ts5 = new TimeSpan(1, 30);
        System.out.println("Початковий час: " + ts5);

        ts5.add(1, 15); // Додаємо 1 год. 15 хв.
        System.out.println("Після add(1, 15): " + ts5);

        ts5.add(45); // Додаємо 45 хв.
        System.out.println("Після add(45): " + ts5);

        TimeSpan toAdd = new TimeSpan(0, 30);
        ts5.add(toAdd); // Додаємо TimeSpan (30 хв.)
        System.out.println("Після add(TimeSpan 30 хв.): " + ts5);

        // Тестування методів віднімання
        System.out.println("\n=== Тестування віднімання ===");
        TimeSpan ts6 = new TimeSpan(3, 30);
        System.out.println("Початковий час: " + ts6);

        ts6.subtract(1, 15); // Віднімаємо 1 год. 15 хв.
        System.out.println("Після subtract(1, 15): " + ts6);

        ts6.subtract(30); // Віднімаємо 30 хв.
        System.out.println("Після subtract(30): " + ts6);

        TimeSpan toSubtract = new TimeSpan(0, 45);
        ts6.subtract(toSubtract); // Віднімаємо TimeSpan (45 хв.)
        System.out.println("Після subtract(TimeSpan 45 хв.): " + ts6);

        // Тестування граничних випадків
        System.out.println("\n=== Граничні випадки ===");
        TimeSpan ts7 = new TimeSpan(1, 70); // 70 хв. має перетворитись на 1 год. 10 хв.
        System.out.println("TimeSpan(1, 70): " + ts7);

        TimeSpan ts8 = new TimeSpan(2, 30);
        ts8.subtract(3, 0); // Спроба відняти більше, ніж є
        System.out.println("Після subtract(3, 0) з 2 год. 30 хв.: " + ts8);
    }
}