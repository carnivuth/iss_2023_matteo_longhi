package unibo.console;

import unibo.basicomm23.utils.CommUtils;
import unibo.common.IAppl1Core;
import unibo.core.Appl1Core;

public class CmdConsoleSimulator {
    private IAppl1Core appl;

    public CmdConsoleSimulator( IAppl1Core appl ){
        this.appl = appl;
    }

    public void activate(   )   {
        try {
            cmdConsoleSimul.start();
            appl.start();
        } catch (Exception e) { }
    }
    private  Thread cmdConsoleSimul = new Thread("cmdConsole") {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                CommUtils.delay(3000);
                CommUtils.outmagenta("cmdConsoleSimul send STOP " + i);
                appl.stop();
                CommUtils.delay(1500);
                appl.resume();
            }
        }
    };
}
