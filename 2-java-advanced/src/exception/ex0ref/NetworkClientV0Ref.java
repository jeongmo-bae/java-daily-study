package exception.ex0ref;

import static util.MyLogger.log;

public class NetworkClientV0Ref {
    private final String address;
    private boolean isConnectError ;
    private boolean isSendError ;
    private boolean isOtherError ;

    public NetworkClientV0Ref(String address) {
        this.address = address;
    }

    public void connect() throws ConnectException {
        if(isConnectError){
            throw new ConnectException("connectError", address , "서버 연결 실패!!");
        }
        log(address + " 서버 연결 성공");
    }

    public void send(String data) throws Exception {
        if(isSendError){
            throw new SendException("sendError", data ,"전송 실패");
        } else if(isOtherError){
            throw new Exception("Other Error Occurred");
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
        } else if (data.contains("error")){
            isOtherError = true;
        }
    }

}
