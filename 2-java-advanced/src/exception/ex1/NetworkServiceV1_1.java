package exception.ex1;

public class NetworkServiceV1_1 {
    public void sendMessage(String data) throws Exception {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);

        try {
            client.connect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        client.send(data);
        client.disconnect();
    }
}
