package unibo.console;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction2021;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

import java.util.Observable;
import java.util.Observer;

public class StartStopGuiRemote implements Observer {
    private String[] buttonLabels  = new String[] {"start", "stop", "resume", "exit" };
    private String destName;
    private Interaction2021 conn;

    public StartStopGuiRemote(String destName, ProtocolType protocol, String address, String port) {
        ButtonAsGui concreteButton = ButtonAsGui.createButtons( "", buttonLabels );
        concreteButton.addObserver( this );
        this.destName = destName;
        conn = ConnectionFactory.createClientSupport(protocol,address, port);
    }

    @Override //For Observer
    public void update(Observable o , Object arg ) {
        String move = arg.toString();

        IApplMessage msg = CommUtils.buildDispatch("gui", move, move, destName);
        try {
            conn.forward(msg.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
