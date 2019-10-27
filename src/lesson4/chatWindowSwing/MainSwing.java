package lesson4.chatWindowSwing;

import javax.swing.*;

public class MainSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatWindow();
            }
        });
    }
}
