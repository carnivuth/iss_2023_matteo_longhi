package unibo.core;

import unibo.basicomm23.interfaces.IObservable;
import unibo.basicomm23.interfaces.IObserver;
import unibo.basicomm23.utils.ApplAbstractObserver;
import unibo.supports.TcpAppl1Support;

import java.io.IOException;
import java.util.Observable;

public class Appl1 extends ApplAbstractObserver {
    private TcpAppl1Support support;
    private Appl1Core appl1Core;

    private int port;
    public Appl1(int port){
        this.port=port;
        appl1Core=new Appl1Core();
        try {
            support=new TcpAppl1Support(port,this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void start(){
        support.start();
    }

    @Override
    public void update(String s) {
        if(s.contains("start")){
            Thread thread=new Thread("start"){
                public void run(){
                    try {
                        appl1Core.start();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            thread.start();

        }else if(s.contains("stop")){
            Thread thread=new Thread("stop"){
                public void start(){

                    appl1Core.stop();

                }
            };
            thread.start();

        }else if(s.contains("resume")){
            Thread thread=new Thread("resume"){
                public void start(){

                    appl1Core.resume();

                }
            };
            thread.start();

        }

    }


}
