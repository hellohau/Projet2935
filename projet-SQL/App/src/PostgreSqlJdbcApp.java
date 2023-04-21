import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class PostgreSqlJdbcApp {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        JFrame frame = new JFrame("PostgreSQL JDBC App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JButton button1 = new JButton("Question 1");
        button1.setBounds(50, 20, 150, 25);
        panel.add(button1);

        JButton button2 = new JButton("Question 2");
        button2.setBounds(210, 20, 150, 25);
        panel.add(button2);

        JButton button3 = new JButton("Question 3");
        button3.setBounds(370, 20, 150, 25);
        panel.add(button3);

        JButton button4 = new JButton("Question 4");
        button4.setBounds(530, 20, 150, 25);
        panel.add(button4);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 60, 500, 250);
        panel.add(scrollPane);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // textArea.setText(getDataFromDb("SELECT * FROM your_table WHERE ..."));
                    textArea.setText("Button 1 TEST");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // textArea.setText(getDataFromDb("SELECT * FROM your_table WHERE ..."));
                    textArea.setText("Button 2 TEST");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // textArea.setText(getDataFromDb("SELECT * FROM your_table WHERE ..."));
                    textArea.setText("Button 3 TEST");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // textArea.setText(getDataFromDb("SELECT * FROM your_table WHERE ..."));
                    textArea.setText("Button 4 TEST");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    private static String getDataFromDb(String query) throws Exception {
        StringBuilder result = new StringBuilder();

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            // À changer plus tard, juste pour tester
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            result.append("ID: ").append(id).append(", Name: ").append
            (name).append(", Age: ").append(age).append("\n");
        } 
        resultSet.close();
        statement.close();
        connection.close();
    
        return result.toString();
    }
}