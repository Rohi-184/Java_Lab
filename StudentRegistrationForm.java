import java.awt.*;
import javax.swing.*;

public class StudentRegistrationForm extends JFrame {

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Student Registration", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        addFormField(panel, gbc, "First Name:", new JTextField(15), 1);
        addFormField(panel, gbc, "Last Name:", new JTextField(15), 2);
        addFormField(panel, gbc, "Email Address:", new JTextField(15), 3);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        addFormField(panel, gbc, "Gender:", genderPanel, 4);

        String[] courses = {"Select Course", "Computer Science", "Business Admin", "Electrical Eng", "Data Science"};
        JComboBox<String> courseCombo = new JComboBox<>(courses);
        addFormField(panel, gbc, "Course:", courseCombo, 5);

        addFormField(panel, gbc, "Address:", new JTextField(15), 6);

        JButton submitButton = new JButton("Submit Registration");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(74, 144, 226));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 8, 8, 8);
        panel.add(submitButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void addFormField(JPanel panel, GridBagConstraints gbc, String labelText, Component comp, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 0.7;
        panel.add(comp, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationForm());
    }
}