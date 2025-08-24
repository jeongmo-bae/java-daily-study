package exception.basic.checked;

import static util.MyLogger.log;

public class CheckedThrowMain {
    public static void main(String[] args) throws MyCheckedException {
        Service service = new Service();
        service.catchThrow();
        log("정상 종료 ~");
    }
}

//Stack Trace
//Exception in thread "main" exception.basic.checked.MyCheckedException: ex
//at exception.basic.checked.Client.call(Client.java:6)
//at exception.basic.checked.Service.catchThrow(Service.java:20)
//at exception.basic.checked.CheckedThrowMain.main(CheckedThrowMain.java:8)
