package exception.ex0;

import static util.MyLogger.log;

public class NetworkClientV0 {
    private final String address;

    public NetworkClientV0(String address) {
        this.address = address;
    }

    public String connect(){
        log(address + " 서버 연결 성공");
        return "success";
    }

    public String send(String data){
        log(address + " 서버에 데이터 전송 : " + data);
        return "success";
    }

    public void disconnect(){
        log(address + " 서버 연결 종료");
    }
}
