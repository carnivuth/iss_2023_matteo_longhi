package pingpong.reciver;

import pingpong.common.Config;
import unibo.basicomm23.enablers.ServerFactory;
import unibo.basicomm23.interfaces.IApplMsgHandler;


public class Receiver {
    private ServerFactory server;

    public Receiver(String name){

        ReceiverLogic receiverLogic = new ReceiverLogic();
        IApplMsgHandler handler;
        handler = new ReceiverConnectionHandler("consumerhanlder", receiverLogic );
        server = new ServerFactory("server", Config.port, Config.protocol);
        server.addMsgHandler(handler);
    }

    public void start(){
        server.start();
    }
}
