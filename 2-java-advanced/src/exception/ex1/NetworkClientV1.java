package exception.ex1;

import static util.MyLogger.log;

public class NetworkClientV1 {
    private final String address;
    private boolean connectError;
    private boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }

    public String connect() throws Exception {
        if(connectError){
            throw new Exception("connectError");
        }
        log(address + " 서버 연결 성공");
        return "success";
    }

    public String send(String data) throws Exception {
        if(sendError){
            throw new Exception("sendError");
        }
        log(address + " 서버에 데이터 전송 : " + data);
        return "success";
    }

    public void disconnect(){
        log(address + " 서버 연결 종료");
    }

    public void initError(String data){
        if(data.contains("error1")){
            connectError = true;
        } else if (data.contains("error2")) {
            sendError = true;
        }
    }
}
