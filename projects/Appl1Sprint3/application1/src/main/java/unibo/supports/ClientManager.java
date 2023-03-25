package unibo.supports;

import unibo.basicomm23.interfaces.IObservable;
import unibo.basicomm23.interfaces.IObserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ClientManager extends Thread implements IObservable {

    private Socket client;
    private List<IObserver> observers;
    private InputStream in;
    public ClientManager(Socket client) throws IOException {
        this.client=client;
        this.in= client.getInputStream();
        observers= new ArrayList<>();
    }
    @Override
    public void run(){
        while (!client.isClosed()){
            byte [] buffer = new byte[100];
            try {
                in.read(buffer);
                updateObservers(new String(buffer, StandardCharsets.UTF_8));


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

    @Override
    public void addObserver(IObserver iObserver) {
        this.observers.add(iObserver);
    }

    @Override
    public void deleteObserver(IObserver iObserver) {
        this.observers.remove(iObserver);
    }
    public void updateObservers(String s){
        observers.stream().forEach((observer)->{observer.update(s);});
    }
}
