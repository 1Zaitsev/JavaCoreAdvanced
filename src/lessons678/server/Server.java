package lessons678.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

    private Vector<ClientHandler> clients;

    public Server() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket client = null;

        try {
            AuthService.connection();
//            String nick = AuthService.getNickByLoginAndPass("login1", "pass1");       //DB connection test
//            System.out.println(nick);
            server = new ServerSocket(8189);
            System.out.println("Server is running...");

            while (true) {
                client = server.accept();
                System.out.println("Client connected");
                new ClientHandler(client, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadCastMsg(ClientHandler from, String msg){
        for (ClientHandler c: clients) {
            if(!c.checkNickBlackList(from.getNick())){
                c.sendMsg(msg);
            }
        }
    }

    public void sendPrivateMsg(ClientHandler client, String nick, String msg){
        for (ClientHandler c: clients) {
            if(c.getNick().equals(nick)) {
                c.sendMsg("Private from " + client.getNick() + ": " + msg);
                client.sendMsg("Private to " + c.getNick() + ": " + msg);
                return;
            }
        }
        client.sendMsg("/wFail: There is't " + nick + " in this chat");
    }

    public boolean isNickBusy(String nick){
        for (ClientHandler c: clients) {
            if(c.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public void subscribe(ClientHandler client){
        clients.add(client);
        broadCastClientList();
    }


    public void unsubscribe(ClientHandler client){
        clients.remove(client);
        broadCastClientList();
    }

    public void broadCastClientList(){
        StringBuffer sb = new StringBuffer();
        sb.append("/clientlist ");
        for (ClientHandler c: clients) {
            sb.append(c.getNick() + " ");
        }

        String out = sb.toString();

        for (ClientHandler c: clients) {
            c.sendMsg(out);
        }
    }
}
