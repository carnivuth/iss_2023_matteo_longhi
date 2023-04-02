package unibo.main;

import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.configs.ConfigConsole;
import unibo.console.StartStopGuiRemote;
import unibo.core.Appl1;
import unibo.core.Appl1Core;
import unibo.remoteconsole.RemoteCmdConsole;

public class Appl1HTTPSprint3Console {
    private StartStopGuiRemote remoteCmdConsole;
    private ConfigConsole configurator;
    public Appl1HTTPSprint3Console(){
        try {
            configurator=new ConfigConsole("/home/matteo/universita/iss/iss_2023_matteo_longhi/projects/Appl1Sprint3v2/application1/src/main/resources/Consoleconfig.json");
            configureTheSystem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void doJob() throws Exception{

        }

    public static void main( String[] args ) throws Exception {
        Appl1HTTPSprint3Console appl = new Appl1HTTPSprint3Console();
        appl.doJob();
    }
    private void configureTheSystem(){
        remoteCmdConsole =new StartStopGuiRemote("console", configurator.getServerProtocol(),configurator.getServerAddress(), configurator.getServerPort());
    }
}
