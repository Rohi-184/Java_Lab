import java.awt.*;
import javax.swing.*;

public class Colorplatte {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Smiley Color Palette");
        JFrame palette = new JFrame("Color Palette");

        final Color[] smileyColor = {Color.YELLOW};
        final boolean[] changeSmiley = {true};

        JPanel canvas = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(smileyColor[0]);
                g.fillOval(50, 50, 300, 300);

                g.setColor(Color.BLACK);
                g.drawOval(50, 50, 300, 300);

                g.fillOval(135, 135, 35, 50);
                g.fillOval(230, 135, 35, 50);

                g.drawArc(125, 175, 150, 100, 200, 140);
            }
        };

        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(400, 400));

        JButton smiley = new JButton("Change Smiley Color");
        JButton background = new JButton("Change Background Color");

        JPanel buttons = new JPanel();
        buttons.add(smiley);
        buttons.add(background);

        frame.add(canvas);
        frame.add(buttons, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocation(100, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel colors = new JPanel(new GridLayout(4, 4, 5, 5));

        Color[] list = {
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
            Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA,
            Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK,
            Color.WHITE, Color.DARK_GRAY, Color.RED, Color.BLUE
        };

        for (Color c : list) {

            JButton b = new JButton();
            b.setBackground(c);

            b.addActionListener(e -> {

                if (changeSmiley[0])
                    smileyColor[0] = c;
                else
                    canvas.setBackground(c);

                canvas.repaint();
                palette.setVisible(false);
            });

            colors.add(b);
        }

        palette.add(colors);
        palette.setSize(400, 300);
        palette.setLocation(550, 150);

        smiley.addActionListener(e -> {
            changeSmiley[0] = true;
            palette.setVisible(true);
        });

        background.addActionListener(e -> {
            changeSmiley[0] = false;
            palette.setVisible(true);
        });
    }
}