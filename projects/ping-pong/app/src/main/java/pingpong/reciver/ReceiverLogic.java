package pingpong.reciver;

public class ReceiverLogic {
    public String getPong(String ping){
        if(ping.toLowerCase().equals("ping"))return"PONG";
        return "";

    }
}
