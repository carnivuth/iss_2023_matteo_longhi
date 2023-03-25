package unibo.remoteconsole;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpConsoleSupport {
    private Socket socket;
    private OutputStream out;
    public void connectTo(String address, int port) throws IOException {
        socket  = new Socket();
        socket.connect(new InetSocketAddress(address, port));
        out= socket.getOutputStream();
    }
    public void sendCommand(String cmd) throws IOException {
        String msg= "{command :"+cmd+" }";
        out.write(msg.getBytes());
    }
}
