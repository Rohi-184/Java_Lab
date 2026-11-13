
import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {

        JFrame f = new JFrame("Calculator");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField result = new JTextField();

        JButton b1 = new JButton("+");
        JButton b2 = new JButton("-");
        JButton b3 = new JButton("*");
        JButton b4 = new JButton("/");

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2, 5, 5));

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);

        b1.addActionListener(e -> result.setText(
            "" + (Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText()))
        ));

        b2.addActionListener(e -> result.setText(
            "" + (Integer.parseInt(t1.getText()) - Integer.parseInt(t2.getText()))
        ));

        b3.addActionListener(e -> result.setText(
            "" + (Integer.parseInt(t1.getText()) * Integer.parseInt(t2.getText()))
        ));

        b4.addActionListener(e -> {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());

            if (b != 0)
                result.setText("" + (a / b));
            else
                result.setText("Cannot divide by zero");
        });

        f.setLayout(new GridLayout(4, 1, 5, 5));

        f.add(t1);
        f.add(t2);
        f.add(p);
        f.add(result);

        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
