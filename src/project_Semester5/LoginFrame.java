package project_Semester5;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton, cancelButton;

    public LoginFrame() {
        setTitle("Library Management System - Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Username Label and Text Field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        // Password Label and Password Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        // Login, Cancel, and Register Buttons
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 80, 80, 25);
        panel.add(cancelButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(190, 80, 100, 25);
        panel.add(registerButton);

        // Add Action Listeners
        loginButton.addActionListener(new LoginButtonListener());
        cancelButton.addActionListener(new CancelButtonListener());
        registerButton.addActionListener(new RegisterButtonListener());
    }

    // Listener for the Login Button
    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (validateUser(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                dispose(); // Close the login frame
                new DashboardFrame(); // Open the Dashboard
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials");
            }
        }

        // Validate user credentials by reading the users.txt file
        private boolean validateUser(String username, String password) {
            try (Scanner scanner = new Scanner(new File("C:\\Users\\User\\eclipse-workspace\\project_Semester5\\src\\project_Semester5\\users.txt"))) {
                while (scanner.hasNextLine()) {
                    String[] credentials = scanner.nextLine().split(",");
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        return true;
                    }
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    // Listener for the Cancel Button
    private class CancelButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose(); // Close the login frame
        }
    }

    // Listener for the Register Button
    private class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Append the new user credentials to the users.txt file
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\User\\eclipse-workspace\\project_Semester5\\src\\project_Semester5\\users.txt", true)))) {
                out.println(username + "," + password);
                JOptionPane.showMessageDialog(null, "User Registered Successfully");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
