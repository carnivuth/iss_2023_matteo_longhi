package unibo.configs;

import unibo.basicomm23.msg.ProtocolType;

public abstract class Configurator {
    protected ProtocolType getProtocolType(String conn){
        switch (conn){
            case "http" :
                return ProtocolType.http;

            case "ws":
                return ProtocolType.ws;
            case "tcp":
                return ProtocolType.tcp;
            case "udp":
                return ProtocolType.udp;

            default:
                return ProtocolType.http;

        }

    }
}
