package exception.ex0ref;

import static util.MyLogger.log;

public class NetworkServiceV0Ref {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV0Ref client = new NetworkClientV0Ref(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectException e) {
            log( "[Connection Error] Code : "+ e.getErrorCode() + ", Instance : " + e.getAddress() + ", Messege : " + e.getMessage());
        } catch (NetworkClientException e){
            log( "[Network Error] Code : " + e.getErrorCode() + ", Messege : " + e.getMessage());
        } catch(Exception e){
            log("[Unknown Error] Messege : " + e.getMessage());
        } finally{
            client.disconnect();
        }
    }
}
