import java.awt.*;
import javax.swing.*;

public class MetricConverter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Length Converter");
            frame.setSize(550, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            JPanel middlePanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.BOTH;

            String[] lengthUnits = {"Meter", "Kilometer", "Mile", "Inch", "Centimeter"};

            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
            leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            JTextField inputField = new JTextField("1", 8);
            inputField.setFont(new Font(inputField.getFont().getName(), Font.PLAIN, 24));
            inputField.setHorizontalAlignment(JTextField.CENTER);
            JComboBox<String> unitFromBox = new JComboBox<>(lengthUnits);
            leftPanel.add(inputField);
            leftPanel.add(unitFromBox);

            JLabel equalLabel = new JLabel(" = ");
            equalLabel.setFont(new Font(equalLabel.getFont().getName(), Font.BOLD, 24));
            equalLabel.setHorizontalAlignment(JLabel.CENTER);

            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
            rightPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            JTextField outputField = new JTextField("0.001", 8);
            outputField.setFont(new Font(outputField.getFont().getName(), Font.PLAIN, 24));
            outputField.setHorizontalAlignment(JTextField.CENTER);
            outputField.setEditable(false);
            JComboBox<String> unitToBox = new JComboBox<>(lengthUnits);
            if (unitToBox.getItemCount() > 1) unitToBox.setSelectedIndex(1);
            rightPanel.add(outputField);
            rightPanel.add(unitToBox);

            gbc.gridx = 0; gbc.weightx = 0.45; middlePanel.add(leftPanel, gbc);
            gbc.gridx = 1; gbc.weightx = 0.10; middlePanel.add(equalLabel, gbc);
            gbc.gridx = 2; gbc.weightx = 0.45; middlePanel.add(rightPanel, gbc);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton convertBtn = new JButton("Convert");
            convertBtn.setFont(new Font(convertBtn.getFont().getName(), Font.BOLD, 14));
            buttonPanel.add(convertBtn);

            mainPanel.add(middlePanel);
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(buttonPanel);

            frame.add(mainPanel);

            convertBtn.addActionListener(e -> {
                try {
                    if (inputField.getText().trim().isEmpty()) {
                        outputField.setText("");
                        return;
                    }
                    double v = Double.parseDouble(inputField.getText());
                    String from = (String) unitFromBox.getSelectedItem();
                    String to = (String) unitToBox.getSelectedItem();

                    if (from == null || to == null) return;

                    if (from.equals(to)) {
                        outputField.setText(String.valueOf(v));
                        return;
                    }

                    double baseMeters = switch (from) {
                        case "Meter" -> v;
                        case "Kilometer" -> v * 1000;
                        case "Mile" -> v * 1609.344;
                        case "Inch" -> v * 0.0254;
                        case "Centimeter" -> v * 0.01;
                        default -> v;
                    };

                    double result = switch (to) {
                        case "Meter" -> baseMeters;
                        case "Kilometer" -> baseMeters / 1000;
                        case "Mile" -> baseMeters / 1609.344;
                        case "Inch" -> baseMeters / 0.0254;
                        case "Centimeter" -> baseMeters / 0.01;
                        default -> baseMeters;
                    };

                    outputField.setText(String.format("%.4f", result).replaceAll("0+$", "").replaceAll("\\.$", ""));

                } catch (NumberFormatException ex) {
                    outputField.setText("Error");
                }
            });

            frame.setVisible(true);
        });
    }
}