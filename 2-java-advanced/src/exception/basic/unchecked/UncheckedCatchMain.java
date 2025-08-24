package exception.basic.unchecked;

import static util.MyLogger.log;

public class UncheckedCatchMain {
    public static void main(String[] args) {
        Service service = new Service();
        service.callCatch();
        log("정상 종료 ~");
    }
}
