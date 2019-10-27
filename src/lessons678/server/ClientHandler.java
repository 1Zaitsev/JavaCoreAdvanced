package lessons678.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {

    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;

    private String nick;
    List<String> blackList;

    public String getNick() {
        return nick;
    }

    public boolean checkNickBlackList(String nick){
        return blackList.contains(nick);
    }

    public ClientHandler(Socket client, Server server) {
        try {
            this.client = client;
            this.server = server;
            this.blackList = new ArrayList<>();

            this.in = new DataInputStream(client.getInputStream());
            this.out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        while (true){
                            String str = in.readUTF();
                            if(str.startsWith("/auth")){
                                String[] tokens = str.split(" ");
                                String tempNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if(tempNick != null){
                                    if(server.isNickBusy(tempNick)){
                                        sendMsg("/authFail: nick: " + tempNick +" is busy.");
                                    }else {
                                        sendMsg("/authOK");
                                        nick = tempNick;
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    }
                                }
                            }else{
                                sendMsg("/authFail: Wrong login or password");
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }
                                if (str.startsWith("/w")) {
                                    String[] tokens = str.split(" ", 3);
                                    if (tokens.length >= 3) {
                                        server.sendPrivateMsg(ClientHandler.this, tokens[1], tokens[2]);
                                    } else {
                                        sendMsg("/wFail: There isn't nick or message");
                                    }
                                }
                                if(str.startsWith("/blacklist")){
                                    String[] tokens = str.split(" ");
                                    blackList.add(tokens[1]);
                                    sendMsg(tokens[1] + " added to blackList");
                                }
                            }else {
                                server.broadCastMsg(ClientHandler.this,nick + ": " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            in.close();
                            out.close();
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    server.unsubscribe(ClientHandler.this);
            }
        }).start();
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
