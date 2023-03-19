package unibo.daevitare;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import unibo.basicomm23.http.HTTPCommApache;
import unibo.basicomm23.utils.CommUtils;
import unibo.common.VrobotMsgs;

import java.net.URI;

public class FlatApplication1HTTPNoStop {

    private final String localHostName = "localhost";
    private final int port = 8090;
    private final String URL = localHostName + ":" + port + "/api/move";
    private HTTPCommApache client=new HTTPCommApache(URL);
    private JSONParser simpleparser = new JSONParser();
    private int Nedges = 0;  //For testing
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    //Procedura responsabile della business logic
    public void walkAtBoundary() {
        for (int i = 1; i <= 4; i++) {
            walkAheadUntilCollision(i);
            client.requestSynch( VrobotMsgs.turnleftcmd); //discard result
            Nedges++;  //For testing
        }
    }

    //Procedura responsabile del movimento in avanti, con collisione
    private void walkAheadUntilCollision(int n) {
        String cmd = VrobotMsgs.forwardlongcmd;

        JSONObject result = client.requestSynch( cmd);
        if (!result.toString().contains("collision")) {
            CommUtils.outred("Flatal error: no collision");
        }
    }

    public int getNedges() { //For testing
        return Nedges;

    }
   


}
