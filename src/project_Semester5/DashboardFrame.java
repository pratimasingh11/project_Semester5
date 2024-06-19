package project_Semester5;

import javax.swing.*;
import java.awt.Checkbox;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DashboardFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel addStudentPanel, addBookPanel, issueBookPanel, displayRecordPanel;

    public DashboardFrame() {
        setTitle("Library Management System - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        addStudentPanel = new JPanel();
        addBookPanel = new JPanel();
        issueBookPanel = new JPanel();
        displayRecordPanel = new JPanel();

        setupAddStudentPanel();
        setupAddBookPanel();
        setupIssueBookPanel();
        setupDisplayRecordPanel();

        tabbedPane.add("Add Student", addStudentPanel);
        tabbedPane.add("Add Book", addBookPanel);
        tabbedPane.add("Issue Book", issueBookPanel);
        tabbedPane.add("Display Record", displayRecordPanel);

        add(tabbedPane);
        setVisible(true);
    }

    private void setupAddStudentPanel() {
        addStudentPanel.setLayout(new GridLayout(6, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel programLabel = new JLabel("Program:");
        JLabel sectionLabel = new JLabel("Section:");

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField programField = new JTextField();
        JTextField sectionField = new JTextField();

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> {
            Student student = new Student(firstNameField.getText(), lastNameField.getText(), genderField.getText(), programField.getText(), sectionField.getText());
            DatabaseOperation.writeStudentData(student);
            JOptionPane.showMessageDialog(null, "Student Added Successfully");
        });

        addStudentPanel.add(firstNameLabel);
        addStudentPanel.add(firstNameField);
        addStudentPanel.add(lastNameLabel);
        addStudentPanel.add(lastNameField);
        addStudentPanel.add(genderLabel);
        addStudentPanel.add(genderField);
        addStudentPanel.add(programLabel);
        addStudentPanel.add(programField);
        addStudentPanel.add(sectionLabel);
        addStudentPanel.add(sectionField);
        addStudentPanel.add(new JLabel());
        addStudentPanel.add(addButton);
    }

    private void setupAddBookPanel() {
        addBookPanel.setLayout(new GridLayout(5, 2));

        JLabel authorLabel = new JLabel("Author Name:");
        JLabel titleLabel = new JLabel("Title:");
        JLabel publicationLabel = new JLabel("Publication Name:");
        JLabel subjectLabel = new JLabel("Subject:");

        JTextField authorField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField publicationField = new JTextField();
        JTextField subjectField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            Book book = new Book(authorField.getText(), titleField.getText(), publicationField.getText(), subjectField.getText());
            DatabaseOperation.writeBookData(book);
            JOptionPane.showMessageDialog(null, "Book Added Successfully");
        });

        addBookPanel.add(authorLabel);
        addBookPanel.add(authorField);
        addBookPanel.add(titleLabel);
        addBookPanel.add(titleField);
        addBookPanel.add(publicationLabel);
        addBookPanel.add(publicationField);
        addBookPanel.add(subjectLabel);
        addBookPanel.add(subjectField);
        addBookPanel.add(new JLabel());
        addBookPanel.add(addButton);
    }

    private void setupIssueBookPanel() {
        issueBookPanel.setLayout(new GridLayout(5, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JLabel bookIdLabel = new JLabel("Book ID:");
        JLabel issueDateLabel = new JLabel("Issue Date:");
        JLabel dueDateLabel = new JLabel("Due Date:");

        JTextField studentIdField = new JTextField();
        JTextField bookIdField = new JTextField();
        JTextField issueDateField = new JTextField();
        JTextField dueDateField = new JTextField();

        JButton issueButton = new JButton("Issue Book");
        issueButton.addActionListener(e -> {
            BookIssue bookIssue = new BookIssue(Integer.parseInt(studentIdField.getText()), Integer.parseInt(bookIdField.getText()), issueDateField.getText(), dueDateField.getText());
            DatabaseOperation.writeBookIssued(bookIssue);
            JOptionPane.showMessageDialog(null, "Book Issued Successfully");
        });

        issueBookPanel.add(studentIdLabel);
        issueBookPanel.add(studentIdField);
        issueBookPanel.add(bookIdLabel);
        issueBookPanel.add(bookIdField);
        issueBookPanel.add(issueDateLabel);
        issueBookPanel.add(issueDateField);
        issueBookPanel.add(dueDateLabel);
        issueBookPanel.add(dueDateField);
        issueBookPanel.add(new JLabel());
        issueBookPanel.add(issueButton);
    }

    private void setupDisplayRecordPanel() {
        displayRecordPanel.setLayout(new BorderLayout());

        JTextArea displayArea = new JTextArea();
        JButton displayButton = new JButton("Display Records");
        displayButton.addActionListener(e -> {
            ArrayList<BookIssue> issues = DatabaseOperation.readBookIssue();
            StringBuilder records = new StringBuilder();
            for (BookIssue issue : issues) {
                records.append(issue.toString()).append("\n");
            }
            displayArea.setText(records.toString());
        });

        displayRecordPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        displayRecordPanel.add(displayButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new DashboardFrame();
    }
}
