package exception.basic.checked;

import static util.MyLogger.log;

public class Service {
    Client client = new Client();

    // Exception 처리
    public void callCatch(){
        try {
            client.call();
        } catch (MyCheckedException e) {
            log("예외 처리, messege = " + e.getMessage());
        }
        log("정상 흐름 ~");
    }
    // Exception 던지기
    public void catchThrow() throws MyCheckedException {
        client.call();
    }

}
