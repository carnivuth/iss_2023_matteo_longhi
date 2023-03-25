package unibo.console;

import unibo.basicomm23.utils.CommUtils;
import unibo.common.CmdConsole;
import unibo.core.Appl1Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LocalCmdConsole implements CmdConsole {
    Appl1Core appl1Core;
    BufferedReader reader;
    @Override
    public void start() {
            Thread thread=new Thread("start thread"){
                public void run(){
                    try {
                        appl1Core.start();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            };

        thread.start();
    }

    @Override
    public void stop() {
        Thread thread=new Thread("start thread"){
            public void start(){

                    appl1Core.stop();

            }
        };
        thread.start();

    }

    @Override
    public void resume() {
        Thread thread=new Thread("start thread"){
            public void start(){

                appl1Core.resume();

            }
        };
        thread.start();


    }
    public LocalCmdConsole(Appl1Core appl1Core){
        this.appl1Core=appl1Core;
        this.reader= new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public void init() {
        String command;
        CommUtils.outblue("submit instruciton: (start|stop|resume) end to terminate");
        try {
            command = this.reader.readLine();
            while (!command.equals("end")) {
                switch (command){
                    case "start":
                        this.start();
                        break;
                    case "stop":
                        this.stop();
                        break;
                    case "resume":
                        this.resume();
                        break;
                    default:
                        break;
                }
                command = this.reader.readLine();


            }
        } catch (IOException e) {
        }
    }
}
