package unibo.remoteconsole;

import unibo.basicomm23.utils.CommUtils;
import unibo.common.CmdConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoteCmdConsole implements CmdConsole {

    private String address;
    BufferedReader reader;
    private int port;
    private TcpConsoleSupport comm;
    @Override
    public void start() {
        try {
            comm.sendCommand("start");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void stop() {
        try {
            comm.sendCommand("stop");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void resume() {
        try {
            comm.sendCommand("resume");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() {

        String command;
        CommUtils.outblue("submit instruciton: (start|stop|resume) end to terminate");
        try {
            comm.connectTo(address,port);
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
    public RemoteCmdConsole(String address,int port){
        this.port=port;
        this.address=address;
        comm=new TcpConsoleSupport();
        this.reader= new BufferedReader(new InputStreamReader(System.in));
    }
}
