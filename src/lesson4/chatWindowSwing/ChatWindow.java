package lesson4.chatWindowSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChatWindow extends JFrame {

    public ChatWindow(){

        setTitle("Chat19012");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());

        centerPanel.setBackground(Color.gray);
        bottomPanel.setBackground(Color.darkGray);

        bottomPanel.setPreferredSize(new Dimension(1, 40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel,BorderLayout.CENTER);


        JButton sent = new JButton("Sent");
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 28));
        textField.grabFocus();
        bottomPanel.add(textField);
        bottomPanel.add(sent);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        centerPanel.add(jScrollPane, BorderLayout.CENTER);

        sent.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
                textField.grabFocus();
            }
        });
    }
}
