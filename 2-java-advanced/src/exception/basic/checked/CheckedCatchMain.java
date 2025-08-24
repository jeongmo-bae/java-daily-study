package exception.basic.checked;

import static util.MyLogger.log;

public class CheckedCatchMain {
    public static void main(String[] args) {
        Service service = new Service();
        service.callCatch();
        log("정상 종료 ~");
    }
}
