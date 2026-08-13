import java.awt.*;
import javax.swing.*;

public class StudentRegistrationForm extends JFrame {

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5, 5, 5, 5);
        g.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("Student Registration", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        g.gridwidth = 2; p.add(title, g); g.gridwidth = 1;

        // Form Fields
        JTextField fn = new JTextField(15), ln = new JTextField(15), em = new JTextField(15), ad = new JTextField(15);
        JRadioButton m = new JRadioButton("Male"), f = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup(); bg.add(m); bg.add(f);
        JPanel genP = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0)); genP.add(m); genP.add(f);

        JComboBox<String> cBox = new JComboBox<>(new String[]{"Select Course", "Computer Science", "Business Admin", "Electrical Eng", "Data Science"});

        addRow(p, g, "First Name:", fn, 1);
        addRow(p, g, "Last Name:", ln, 2);
        addRow(p, g, "Email Address:", em, 3);
        addRow(p, g, "Gender:", genP, 4);
        addRow(p, g, "Course:", cBox, 5);
        addRow(p, g, "Address:", ad, 6);

        // Submit Button
        JButton btn = new JButton("Submit Registration");
        g.gridx = 0; g.gridy = 7; g.gridwidth = 2; p.add(btn, g);

        btn.addActionListener(e -> {
            String gen = m.isSelected() ? "Male" : f.isSelected() ? "Female" : "";
            if (fn.getText().isBlank() || ln.getText().isBlank() || em.getText().isBlank() || ad.getText().isBlank() || gen.isEmpty() || cBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            } else {
                JOptionPane.showMessageDialog(this, "Registered:\n" + fn.getText() + " " + ln.getText() + "\nEmail: " + em.getText() + "\nGender: " + gen + "\nCourse: " + cBox.getSelectedItem() + "\nAddress: " + ad.getText());
            }
        });

        add(p);
        setVisible(true);
    }

    private void addRow(JPanel p, GridBagConstraints g, String lbl, Component c, int row) {
        g.gridy = row; g.gridx = 0; g.weightx = 0.3; p.add(new JLabel(lbl), g);
        g.gridx = 1; g.weightx = 0.7; p.add(c, g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistrationForm::new);
    }
}