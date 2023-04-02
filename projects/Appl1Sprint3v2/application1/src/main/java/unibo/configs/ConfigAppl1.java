package unibo.configs;

import org.json.simple.JSONObject;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConfigAppl1 extends Configurator{

    private String vrconn;
    private String vitualRobotIp;
    private String serverPort;
    private String serverConn;
    public String getServerConn(){
        return serverConn;
    }
    public ConfigAppl1(String filename) throws Exception {
        readConfigFromFile(filename);

    }
    public String getServerPort(){
        return this.serverPort;
    }
    public String getVitualRobotIp(){
        return this.vitualRobotIp;
    }

    public ProtocolType getRobotProtocol(){
        return getProtocolType(this.vrconn);
    }
    public ProtocolType getServerProtocol(){
        return getProtocolType(this.serverConn);
    }
    protected void readConfigFromFile(String filename) throws Exception{

        File cfgfile          = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(cfgfile));
        String currentLine    = reader.readLine();
        CommUtils.outblue("Appl1Core currentLine=" + currentLine);
        JSONObject cj         = CommUtils.parseForJson(currentLine);
        vitualRobotIp         = cj.get("virtualrobotip").toString();
        serverPort         = cj.get("serverPort").toString();
        vrconn         = cj.get("virtualrobotconn").toString();
        serverConn         = cj.get("serverConn").toString();

    }
}
