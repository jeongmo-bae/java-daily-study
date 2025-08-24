package exception.ex0ref;

import static util.MyLogger.log;

public class NetworkClientV1 {
    private final String address;
    private boolean isConnectError ;
    private boolean isSendError ;

    public NetworkClientV1(String address) {
        this.address = address;
    }

    public void connect() throws NetworkClientException {
        if(isConnectError){
            throw new NetworkClientException("connectError", address + " 서버 연결 실패!!");
        }
        log(address + " 서버 연결 성공");
    }

    public void send(String data) throws NetworkClientException {
        if(isSendError){
            throw new NetworkClientException("sendError", "전송 실패!! : " + data);
        }
        log(address + " 서버에 데이터 전송 : " + data);
    }

    public void disconnect() {
        log(address + " 서버 연결 종료");
    }

    public void initError(String data){
        if(data.contains("error1")){
            isConnectError = true;
        } else if (data.contains("error2")) {
            isSendError = true;
        }
    }

}
