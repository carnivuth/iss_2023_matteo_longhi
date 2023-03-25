package unibo.supports;

import unibo.basicomm23.interfaces.IObserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpAppl1Support extends Thread{
    private ServerSocket server;
    private int port;
    private IObserver commObserver;
    private List<ClientManager> clients;
    public TcpAppl1Support(int port,IObserver commObserver) throws IOException {
        server=new ServerSocket(port);
        clients=new ArrayList<>();
        this.commObserver=commObserver;

    }
    @Override
    public void run(){
        Socket client;
        while(true){
            try {
                client=server.accept();
                ClientManager cm=new ClientManager(client);
                clients.add(cm);
                cm.addObserver(commObserver);
                cm.start();

                //run thread to serve client
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
