package theme7_thread.thread.start;

import static util.MyLogger.*;

public class HelloRunnable implements Runnable{
    @Override
    public void run(){
        log("run()");
    }
}
