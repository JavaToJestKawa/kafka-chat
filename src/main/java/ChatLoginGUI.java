import javax.swing.*;
import java.awt.*;

public class ChatLoginGUI extends JFrame {
    public ChatLoginGUI() {
        setTitle("Login to Chat");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JTextField nicknameField = new JTextField();
        JTextField topicField = new JTextField();
        JButton loginButton = new JButton("Login");

        add(new JLabel("Nickname:"));
        add(nicknameField);
        add(new JLabel("Room (topic):"));
        add(topicField);
        add(new JLabel());
        add(loginButton);

        loginButton.addActionListener(e -> {
            String nickname = nicknameField.getText().trim();
            String topic = topicField.getText().trim();
            if (!nickname.isEmpty() && !topic.isEmpty()) {
                new ChatGUI(topic, nickname);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Fill in all fields.");
            }
        });

        setVisible(true);
    }
}
