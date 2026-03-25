import org.apache.kafka.clients.producer.ProducerRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;

public class ChatGUI extends JFrame {
    private final MessageConsumer messageConsumer;
    private JTextArea chatView;
    private JPanel mainPanel;
    private JTextField message;
    private JButton sendButton;
    private JList list1;

    public ChatGUI(String topic, String id) throws HeadlessException {
        messageConsumer = new MessageConsumer(topic, id);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(mainPanel);
        this.setVisible(true);
        this.setTitle(topic + ": " + id);
        this.pack();

        Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                messageConsumer.kafkaConsumer.poll(Duration.of(1, ChronoUnit.SECONDS)).forEach(
                        m -> {
                            System.out.println(m);
                            chatView.append(m.value() + System.lineSeparator());
                        }
                );
            }
        });

        sendButton.addActionListener(e -> {
            String msg = message.getText().trim();
            if (!msg.isEmpty()) {
                String fullMessage = String.format("[%s] %s: %s",
                        LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), id, msg);
                MessageProducer.send(new ProducerRecord<>(topic, fullMessage));
                message.setText("");
            }

        });
    }
}
