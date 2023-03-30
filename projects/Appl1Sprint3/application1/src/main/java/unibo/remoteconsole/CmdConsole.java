package unibo.remoteconsole;

import unibo.basicomm23.enablers.CallerAsClient;
import unibo.basicomm23.msg.ProtocolType;

public class CmdConsole {
        private CallerAsClient client;
        public CmdConsole(String name, String host, String entry, ProtocolType pt){
            client=new CallerAsClient(name, host, entry,pt);

        }
        public void init (){

        }

}
