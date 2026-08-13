import java.awt.*;
import javax.swing.*;

public class MultiConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mertic Converter");
        frame.setLayout(new GridLayout(2, 1, 5, 5));
        frame.setSize(440, 140);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bold Font Definition
        Font boldFont = new Font("SansSerif", Font.BOLD, 12);

        // Defined sizes to align component dimensions
        Dimension textBoxSize = new Dimension(90, 25);     // Equal size for input & output text boxes
        Dimension controlSize = new Dimension(130, 25);    // Equal size for modeBox & convertBtn

        // --- Row 1 Components ---
        JLabel inputLabel = new JLabel("Input :");
        inputLabel.setFont(boldFont);

        JTextField input = new JTextField("1");
        input.setFont(boldFont);
        input.setPreferredSize(textBoxSize);

        JComboBox<String> modeBox = new JComboBox<>(new String[]{
            "Meter -> Km", "Km -> Meter",
            "C -> F", "F -> C",
            "Gram -> Kg", "Kg -> Gram",
            "Sin (deg)", "Cos (deg)", "Tan (deg)", "Sqrt"
        });
        modeBox.setFont(boldFont);
        modeBox.setPreferredSize(controlSize);

        // --- Row 2 Components ---
        JLabel resultLabel = new JLabel("Result :");
        resultLabel.setFont(boldFont);

        JTextField output = new JTextField("0.001");
        output.setFont(boldFont);
        output.setEditable(false);
        output.setPreferredSize(textBoxSize);

        JButton convertBtn = new JButton("Convert");
        convertBtn.setFont(boldFont);
        convertBtn.setPreferredSize(controlSize);

        // Panels to hold each row
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        row1.add(inputLabel);
        row1.add(input);
        row1.add(modeBox);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        row2.add(resultLabel);
        row2.add(output);
        row2.add(convertBtn);

        // Add rows to frame
        frame.add(row1);
        frame.add(row2);

        convertBtn.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText().trim());
                double result = switch ((String) modeBox.getSelectedItem()) {
                    case "Meter -> Km" -> val / 1000;
                    case "Km -> Meter" -> val * 1000;
                    case "C -> F"       -> (val * 9 / 5) + 32;
                    case "F -> C"       -> (val - 32) * 5 / 9;
                    case "Gram -> Kg"   -> val / 1000;
                    case "Kg -> Gram"   -> val * 1000;
                    case "Sin (deg)"   -> Math.sin(Math.toRadians(val));
                    case "Cos (deg)"   -> Math.cos(Math.toRadians(val));
                    case "Tan (deg)"   -> Math.tan(Math.toRadians(val));
                    case "Sqrt"        -> Math.sqrt(val);
                    default            -> 0;
                };

                String formatted = String.format("%.4f", result)
                                         .replaceAll("0+$", "")
                                         .replaceAll("\\.$", "");

                output.setText(formatted);
            } catch (NumberFormatException ex) {
                output.setText("Error");
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}