package handlers;

import javax.swing.JTextArea;

public class MessageHandler {

    public static void displayTextMessage(String message, JTextArea jtextarea) {
        jtextarea.setText(message);
    }
}
