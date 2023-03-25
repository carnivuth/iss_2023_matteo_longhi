package unibo.main;

import unibo.basicomm23.utils.CommUtils;
import unibo.core.Appl1;
import unibo.core.Appl1Core;

public class Appl1HTTPSprint3Appl1 {

    private Appl1 appl1;

    public Appl1HTTPSprint3Appl1(){
        configureTheSystem();
    }
    private void configureTheSystem(){
        appl1 = new Appl1(50000);
    }
    public void doJob() throws Exception{

        appl1.start(  );
    }

    public static void main( String[] args ) throws Exception {
        CommUtils.aboutThreads("Before start - ");
        Appl1HTTPSprint3Appl1 appl = new Appl1HTTPSprint3Appl1();
        appl.doJob();
        CommUtils.aboutThreads("At end - ");
    }
}
