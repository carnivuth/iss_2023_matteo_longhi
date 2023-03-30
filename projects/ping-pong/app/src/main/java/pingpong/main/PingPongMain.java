package pingpong.main;

import pingpong.reciver.Receiver;
import pingpong.sender.Sender;
import unibo.basicomm23.msg.ProtocolType;

public class PingPongMain {
    private Receiver receiver;
    private String hostAddr="localhost";
    private Sender sender;

    public void startServer(){
        Thread thread =new Thread("Server"){
            public void run() {
            receiver.start();

        }
    };
        thread.start();
    }
    public PingPongMain(){
        this.sender=new Sender("sender", ProtocolType.tcp,hostAddr,"8888");
        this.receiver=new Receiver("receiver");
    }
    public static void main(String args[]){
        PingPongMain pingPongMain=new PingPongMain();
        pingPongMain.startServer();
        pingPongMain.sender.activate();
    }
}
