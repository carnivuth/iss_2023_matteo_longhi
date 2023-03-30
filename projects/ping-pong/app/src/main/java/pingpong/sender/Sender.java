package pingpong.sender;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

public class Sender extends ActorNaiveCaller {
    private SenderLogic senderLogic;
    public Sender(String name, ProtocolType protocol, String hostAddr, String entry) {
        super(name, protocol, hostAddr, entry);
        senderLogic= new SenderLogic();
    }

    @Override
    protected void body() throws Exception {

            String message= senderLogic.getPing(   );
            CommUtils.outblue(message);
            IApplMessage req = CommUtils.buildRequest( name, "ping", message, "reciver");
            CommUtils.outblue(name + " | sends request " + connSupport);
            IApplMessage answer = connSupport.request(req);  //raise exception
            CommUtils.outblue(name + " | answer=" + answer);
            CommUtils.delay(2000);


    }
}
