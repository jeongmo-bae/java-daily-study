package exception.basic.unchecked;

import static util.MyLogger.log;

public class UncheckedThrowMain {
    public static void main(String[] args) {
        Service service = new Service();
        service.callThrow();
        log("정상 종료 ~");

    }
}
