package thread.start;

public class DemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main start()");
        DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true); // Demon Thread 여부
        demonThread.start();
        System.out.println(Thread.currentThread().getName() + " : main end()");
    }
    static class DemonThread extends Thread{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " : run() start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " : run() end");
        }
    }
}
