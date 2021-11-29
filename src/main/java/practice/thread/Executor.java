package practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Executor {

    public static void main(String[] args) {

        //SingleThreadExecutor
        //FixedThreadPool
        //SingleThreadScheduledExecutor
        //CachedThreadPool
        //ScheduledThreadPool
        //WorkStealingPool

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("SingleThread " + threadName);
        });
        executor.shutdown();

        executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("FixedThreadPool " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("FixedThreadPool " + Thread.currentThread().getName()));
        executor.shutdown();

        executor = Executors.newSingleThreadScheduledExecutor();
        executor = Executors.newCachedThreadPool();


        executor = Executors.newScheduledThreadPool(1);
        executor = Executors.newWorkStealingPool();

    }
}
