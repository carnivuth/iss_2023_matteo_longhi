package unibo.core;

import unibo.basicomm23.enablers.ServerFactory;
import unibo.basicomm23.interfaces.*;
import unibo.basicomm23.msg.ProtocolType;


public class Appl1 implements IApplMsgHandler {
    private Appl1Core appl1Core;
    private ServerFactory server;
    private String name;

    private int port;
    public Appl1(String name, int port, ProtocolType pt,String robotAddress){
        server= new ServerFactory(name, port,pt,this);
        appl1Core=new Appl1Core(robotAddress);
        this.name=name;

    }
    public void start(){
        server.start();
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void elaborate(IApplMessage iApplMessage, Interaction interaction) {
        String command = iApplMessage.msgContent();
        if(command.contains("start")){
            Thread thread= new Thread(){
              public void run (){
                  try {
                      appl1Core.start();
                  } catch (Exception e) {
                      throw new RuntimeException(e);
                  }
              }
            };
            thread.start();
        }
        if(command.contains("stop")){
            appl1Core.stop();
        }
        if(command.contains("resume")){
            appl1Core.resume();
        }

    }
}
