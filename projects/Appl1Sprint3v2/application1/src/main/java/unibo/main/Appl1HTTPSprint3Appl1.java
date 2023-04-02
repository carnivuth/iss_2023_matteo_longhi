package unibo.main;

import unibo.configs.ConfigAppl1;
import unibo.core.Appl1;

public class Appl1HTTPSprint3Appl1 {

    private Appl1 appl1;
    private ConfigAppl1 configurator;


    public Appl1HTTPSprint3Appl1(){
        configureTheSystem();
    }
    private void configureTheSystem()
    {
        try {
            configurator=new ConfigAppl1("/home/matteo/universita/iss/iss_2023_matteo_longhi/projects/Appl1Sprint3v2/application1/src/main/resources/Appl1config.json");
            appl1 = new Appl1("Appl1",Integer.parseInt(configurator.getServerPort()),configurator.getServerProtocol(),configurator.getVitualRobotIp());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void doJob() throws Exception{

        appl1.start(  );
    }

    public static void main( String[] args ) throws Exception {
        Appl1HTTPSprint3Appl1 appl = new Appl1HTTPSprint3Appl1();
        appl.doJob();
    }
}
