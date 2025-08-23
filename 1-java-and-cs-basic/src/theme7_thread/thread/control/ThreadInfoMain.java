package theme7_thread.thread.control;

import theme7_thread.thread.start.HelloRunnable;

import static util.MyLogger.log;


public class ThreadInfoMain {
    public static void main(String[] args) {
        // main thread
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.getId() = " + mainThread.getId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority()); // 기본이 5
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        log("mainThread.getState = " + mainThread.getState());
        // myThread thread
        log("===============================================");
        Thread myThread = new Thread(new HelloRunnable(),"myThread");
        log("myThread = " + myThread);
        log("myThread.getId() = " + myThread.getId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority()); // 기본이 5
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("myThread.getState = " + myThread.getState());

    }
}
