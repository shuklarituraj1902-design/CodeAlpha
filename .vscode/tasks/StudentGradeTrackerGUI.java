 import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeTrackerGUI extends JFrame implements ActionListener {

    JLabel nameLabel, marksLabel, resultLabel;
    JTextField nameField, marksField;
    JButton addButton, summaryButton, clearButton;
    JTable table;
    DefaultTableModel model;

    double total = 0;
    double highest = -1;
    double lowest = 101;
    int count = 0;

    public StudentGradeTrackerGUI() {
        setTitle("Student Grade Tracker");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Labels
        nameLabel = new JLabel("Student Name:");
        marksLabel = new JLabel("Marks:");

        // TextFields
        nameField = new JTextField(15);
        marksField = new JTextField(10);

        // Buttons
        addButton = new JButton("Add Student");
        summaryButton = new JButton("Show Summary");
        clearButton = new JButton("Clear");

        // Action Listeners
        addButton.addActionListener(this);
        summaryButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Table
        model = new DefaultTableModel();
        model.addColumn("Student Name");
        model.addColumn("Marks");

        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(650, 250));

        // Result Label
        resultLabel = new JLabel("Summary will appear here");

        // Add Components
        add(nameLabel);
        add(nameField);
        add(marksLabel);
        add(marksField);
        add(addButton);
        add(summaryButton);
        add(clearButton);
        add(pane);
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            try {
                String name = nameField.getText();
                double marks = Double.parseDouble(marksField.getText());

                model.addRow(new Object[]{name, marks});

                total += marks;
                count++;

                if (marks > highest)
                    highest = marks;

                if (marks < lowest)
                    lowest = marks;

                nameField.setText("");
                marksField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid data!");
            }
        }

        if (e.getSource() == summaryButton) {
            if (count == 0) {
                resultLabel.setText("No student data available.");
            } else {
                double average = total / count;

                resultLabel.setText(
                        "Total Students: " + count +
                        " | Average: " + average +
                        " | Highest: " + highest +
                        " | Lowest: " + lowest
                );
            }
        }

        if (e.getSource() == clearButton) {
            model.setRowCount(0);
            total = 0;
            count = 0;
            highest = -1;
            lowest = 101;
            resultLabel.setText("Data Cleared!");
        }
    }

    public static void main(String[] args) {
        new StudentGradeTrackerGUI();
    }
}