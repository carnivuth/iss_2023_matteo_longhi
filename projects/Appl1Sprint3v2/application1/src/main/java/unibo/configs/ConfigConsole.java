package unibo.configs;

import org.json.simple.JSONObject;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConfigConsole extends Configurator{
    private String serverAddress;
    private String serverPort;
    private String serverConn;

    public ConfigConsole(String filename) throws Exception {
        readConfigFromFile(filename);

    }
    public String getServerPort(){
        return serverPort;
    }
    public String getServerAddress(){
        return serverAddress;
    }
    public ProtocolType getServerProtocol(){
        return this.getProtocolType(serverConn);
    }
    protected void readConfigFromFile(String filename) throws Exception{

        File cfgfile          = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(cfgfile));
        String currentLine    = reader.readLine();
        CommUtils.outblue("Appl1Core currentLine=" + currentLine);
        JSONObject cj         = CommUtils.parseForJson(currentLine);
        serverAddress         = cj.get("serverAddress").toString();
        serverPort         = cj.get("serverPort").toString();
        serverConn         = cj.get("serverConn").toString();

    }
}
