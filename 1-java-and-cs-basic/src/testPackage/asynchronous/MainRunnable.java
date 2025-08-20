package testPackage.asynchronous;

import java.lang.Runnable;
import java.lang.Thread;



public class MainRunnable {
    public static void main(String[] args) {
        System.out.println("Main Thread");                    
        Runnable runnable = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + "test");                    
                };
        };
        Thread thread = new Thread(runnable);
        thread.start();

        // try {
        //     thread.join();
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        try{
            Thread.sleep(600);
        } catch (InterruptedException e ){
            throw new RuntimeException(e);
        }
        System.out.println("Sub Thread");
        };
}
