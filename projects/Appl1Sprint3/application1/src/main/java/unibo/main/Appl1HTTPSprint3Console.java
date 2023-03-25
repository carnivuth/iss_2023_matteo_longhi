package unibo.main;

import unibo.basicomm23.utils.CommUtils;
import unibo.core.Appl1;
import unibo.core.Appl1Core;
import unibo.remoteconsole.RemoteCmdConsole;

public class Appl1HTTPSprint3Console {
    private RemoteCmdConsole remoteCmdConsole;
    public Appl1HTTPSprint3Console(){
        configureTheSystem();
    }
    public void doJob() throws Exception{
        //run console in a separate thread
                    remoteCmdConsole.init();
        }

    public static void main( String[] args ) throws Exception {
        CommUtils.aboutThreads("Before start - ");
        Appl1HTTPSprint3Console appl = new Appl1HTTPSprint3Console();
        appl.doJob();
        CommUtils.aboutThreads("At end - ");
    }
    private void configureTheSystem(){
        remoteCmdConsole =new RemoteCmdConsole("localhost",50000);
    }
}
