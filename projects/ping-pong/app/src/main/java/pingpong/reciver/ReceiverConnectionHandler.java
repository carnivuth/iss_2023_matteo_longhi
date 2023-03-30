package pingpong.reciver;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ApplMsgHandler;
import unibo.basicomm23.utils.CommUtils;


public class ReceiverConnectionHandler extends ApplMsgHandler {
private ReceiverLogic reciverLogic;
    public ReceiverConnectionHandler(String name,ReceiverLogic receiverLogic) {
        super(name);
        this.reciverLogic=receiverLogic;
    }

    @Override//connection handler called from server class
    public void elaborate(IApplMessage message, Interaction conn) {
        try {

            String msgReply=reciverLogic.getPong(message.msgContent());
            CommUtils.outblue(msgReply);
            IApplMessage reply= CommUtils.buildReply("reciver","pong",msgReply,"sender");
            conn.reply(reply);
        }catch (Exception e){}

    }
}
