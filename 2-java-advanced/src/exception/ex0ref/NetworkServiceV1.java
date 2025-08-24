package exception.ex0ref;

import static util.MyLogger.log;

public class NetworkServiceV1 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (NetworkClientException e) {
            log( "["+ e.getErrorCode() + "] " + e.getMessage());
        } finally{
            client.disconnect();
        }
    }
}
