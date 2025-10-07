package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        // Метод повертає об'єкт ігрової фігури (камінь, ножиці чи папір)
        // випадковим чином
        int random = new Random().nextInt(3);

        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
                return new Scissors();
            default:
                return new Rock(); // за замовчуванням
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
        // Метод отримує клас фігури гравця і комп'ютера за допомогою оператора instanceof
        // Метод повертає 1 якщо переміг гравець
        // Метод повертає 0 якщо нічия (обидві фігури однакові)
        // Метод повертає -1 якщо переміг комп'ютер

        // Перевіряємо нічию (однакові фігури)
        if (player.getClass().equals(computer.getClass())) {
            return 0;
        }

        // Перевіряємо виграш гравця
        if (player instanceof Rock && computer instanceof Scissors) {
            return 1; // Камінь б'є ножиці
        }
        if (player instanceof Scissors && computer instanceof Paper) {
            return 1; // Ножиці б'ють папір
        }
        if (player instanceof Paper && computer instanceof Rock) {
            return 1; // Папір б'є камінь
        }

        // Якщо не нічия і не виграш гравця, то виграє комп'ютер
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Генерується ход комп'ютеру
        GameShape computerShape = generateShape();

        GameShape playerShape = new GameShape();
        // Визначаємо, на яку кнопку натиснув гравець
        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Сформувати повідомлення
        String message = "Фігура гравця: " + playerShape + ". Фігура комп'ютера: " + computerShape + ". ";
        switch (gameResult) {
            case -1:
                message += "Переміг комп'ютер!";
                break;
            case 0:
                message += "Нічия!";
                break;
            case 1:
                message += "Переміг гравець!";
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
