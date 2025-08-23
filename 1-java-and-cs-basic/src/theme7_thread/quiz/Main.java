package theme7_thread.quiz;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        Product productA = new Product("ProdA");
        Product productB = new Product("ProdB");
        Product productSet = new Product("ProdSet");

        BlockingQueue<Integer> qa = new ArrayBlockingQueue<>(5);
        BlockingQueue<Integer> qb = new ArrayBlockingQueue<>(5);

        Runnable runnableA = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    productA.make();
                    qa.put(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable runnableB = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    productB.make();
                    qb.put(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);
        threadA.start();
        threadB.start();

//        try {
//            threadA.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            threadB.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for (int i = 0; i < 5; i++) {
//            productSet.make();
//        }
        // A,B 1개씩 만들어지면 바로 Set1개 만들기 시작하는거로 해보자.
        for (int i = 0; i < 5; i++) {
            try {
                Integer isAReady = qa.take();
                Integer isBReady = qb.take();
                productSet.make();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
