import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class color extends JFrame {

    JButton bgButton, textButton;
    JLabel label;

    color() {

        label = new JLabel("Hello Java Swing!");
        label.setFont(new Font("Arial", Font.BOLD, 24));

        bgButton = new JButton("Background Color");
        textButton = new JButton("Text Color");

        // Background color
        bgButton.addActionListener(e -> {
            java.awt.Color c = JColorChooser.showDialog(
                this,
                "Select Background Color",
                java.awt.Color.WHITE
            );

            if (c != null) {
                getContentPane().setBackground(c);
            }
        });

        // Text color
        textButton.addActionListener(e -> {
            java.awt.Color c = JColorChooser.showDialog(
                this,
                "Select Text Color",
                java.awt.Color.BLACK
            );

            if (c != null) {
                label.setForeground(c);
            }
        });

        add(label);
        add(bgButton);
        add(textButton);

        setLayout(new FlowLayout());
        setSize(500, 300);
        setTitle("Color Palette");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new color();
    }
}