package theme7_thread.thread.start;

public class HelloThread extends Thread{
    @Override
    public void run() {
//        super.run();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " : run()");
    }
}
