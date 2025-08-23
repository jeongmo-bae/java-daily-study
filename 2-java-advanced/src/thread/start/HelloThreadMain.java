package theme7_thread.thread.start;


public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");
        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");
        // start() : 스레드를 실행하는 특별한 메서드 -> run() 메서드를 실행함
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");
        System.out.println(Thread.currentThread().getName() + " : main() end");
        // thread 는 순서와 실행기간을 보장하지 않는다! -> multiThread
    }
}
