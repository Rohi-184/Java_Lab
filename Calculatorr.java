import java.awt.*;
import javax.swing.*;

public class Calculatorr extends JFrame {
    private JTextField display;
    private boolean isResultShown = false;

    public Calculatorr() {
        setTitle("Calculator");
        setSize(360, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField();
        display.setFont(new Font("SansSerif", Font.BOLD, 26));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(360, 60));

        JPanel panel = new JPanel(new GridLayout(4, 4, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(buttonFont);
            button.addActionListener(e -> handleButtonClick(e.getActionCommand()));
            panel.add(button);
        }

        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private void handleButtonClick(String command) {
        if (command.equals("C")) {
            display.setText("");
            return;
        }

        if (command.equals("=")) {
            calculate();
            return;
        }

        // Clear screen if entering a new digit right after getting a result
        if (isResultShown && "0123456789".contains(command)) {
            display.setText("");
        }
        isResultShown = false;

        String text = display.getText();

        // Replace operator if two operators are pressed in a row
        if (!text.isEmpty() && "+-*/".contains(command)) {
            char lastChar = text.charAt(text.length() - 1);
            if ("+-*/".indexOf(lastChar) != -1) {
                text = text.substring(0, text.length() - 1);
            }
        }

        display.setText(text + command);
    }

    private void calculate() {
        try {
            String expr = display.getText();

            // Find which operator was used (+, -, *, /)
            for (char op : new char[]{'+', '-', '*', '/'}) {
                int idx = expr.indexOf(op);
                if (idx > 0) { // Ensures operator exists and isn't the first character
                    double n1 = Double.parseDouble(expr.substring(0, idx));
                    double n2 = Double.parseDouble(expr.substring(idx + 1));

                    double result = switch (op) {
                        case '+' -> n1 + n2;
                        case '-' -> n1 - n2;
                        case '*' -> n1 * n2;
                        case '/' -> n2 != 0 ? n1 / n2 : Double.NaN;
                        default  -> 0;
                    };

                    if (Double.isNaN(result)) {
                        display.setText("Error");
                    } else {
                        // Format output to remove trailing zeros
                        display.setText(String.format("%.6f", result)
                                              .replaceAll("0+$", "")
                                              .replaceAll("\\.$", ""));
                    }
                    isResultShown = true;
                    return;
                }
            }
        } catch (Exception ex) {
            display.setText("Error");
            isResultShown = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculatorr().setVisible(true));
    }
}