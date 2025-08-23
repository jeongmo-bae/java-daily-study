package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("main() start");
        String ex = "start example";
        Thread thread = new Thread(() -> log("run() " + ex));
        thread.start();
        log("main() end");
    }
}
