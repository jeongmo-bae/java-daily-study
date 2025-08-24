package exception.basic.unchecked;

import static util.MyLogger.log;

public class Service {
    Client client = new Client();
    public void callCatch(){
        try{
            client.call();
        }catch (MyUncheckedException e){
            log("예외 처리, messege = " + e.getMessage());
        }
        log("정상 흐름 ~");
    }
    // throws 필요없음
    public void callThrow(){
        client.call();
    }
}
