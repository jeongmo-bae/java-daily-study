package theme7_thread.thread.start;

import static util.MyLogger.*;

public class HelloRunnableMain {
    public static void main(String[] args) {
        log("main() start");
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        thread.start();
        log("main() end");
    }
}
