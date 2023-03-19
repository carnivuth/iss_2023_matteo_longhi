package unibo.main;

import unibo.basicomm23.utils.CommUtils;
import unibo.common.CmdConsole;
import unibo.console.CmdConsoleSimulator;
import unibo.console.LocalCmdConsole;
import unibo.core.Appl1Core;

public class Appl1HTTPSprint2 {
    private Appl1Core appl1Core;
    private CmdConsole cmdConsole;

    public Appl1HTTPSprint2(){
        configureTheSystem();
    }
    private void configureTheSystem(){
        appl1Core  = new Appl1Core();
        cmdConsole = new LocalCmdConsole(appl1Core);
    }
    public void doJob() throws Exception{
        cmdConsole.init(  );   //imvoca start/stop/resume
    }

    public static void main( String[] args ) throws Exception {
        CommUtils.aboutThreads("Before start - ");
        Appl1HTTPSprint2 appl = new Appl1HTTPSprint2();
        appl.doJob();
        CommUtils.aboutThreads("At end - ");
    }
}
