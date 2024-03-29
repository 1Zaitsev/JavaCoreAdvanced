package lessons678.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox authPanel;

    @FXML
    TextField loginField;

    @FXML
    TextField passwordField;

    @FXML
    ListView<String> clientList;

    private boolean isAuthorized;

    public void setAuthorized(boolean isAuthorized){
        this.isAuthorized = isAuthorized;
        if(!isAuthorized){
            authPanel.setVisible(true);
            authPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientList.setVisible(false);
            clientList.setManaged(false);
        }else{
            authPanel.setVisible(false);
            authPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientList.setVisible(true);
            clientList.setManaged(true);
        }
    }

    Socket client;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public void connect() {
        try {
            client = new Socket(IP_ADRESS, PORT);

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String str = in.readUTF();
                            if(str.startsWith("/authOK")){
                                setAuthorized(true);
                                break;
                            }else {
                                textArea.appendText(str + "\n");
                            }
                        }

                        while (true) {
                            String str = in. readUTF();
                            if(str.equals("/serverclose")) break;
                            if(str.startsWith("/clientlist")){
                                String[] tokens = str.split(" ");
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        clientList.getItems().clear();
                                        for (int i = 1; i < tokens.length; i++) {
                                            clientList.getItems().add(tokens[i]);
                                        }
                                    }
                                });
                            }else {
                                textArea.appendText(str + "\n");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setAuthorized(false);
                    }
                }
            }).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        try {
            out.writeUTF(textField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        textField.clear();
        textField.requestFocus();
    }

    public void tryToAuth(ActionEvent actionEvent) throws IOException {
        if(client == null || client.isClosed()){
            connect();
        }

        out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
        loginField.clear();
        passwordField.clear();
    }

    public void dispose() throws IOException {
        if(out != null) {
            out.writeUTF("/end");
        }
    }

    public void selectClient(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            System.out.println("double click");
        }
    }
}
