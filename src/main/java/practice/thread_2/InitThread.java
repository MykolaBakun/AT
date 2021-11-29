package practice.thread_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InitThread {

    public static void main(String[] args) {
        Thread customThead1= new CustomThread1();
       // customThead1.start();

        Thread customThead2= new Thread(new CustomThread2());
       // customThead2.start();

        Thread customThead3= new Thread(()->{
            System.out.println("customThead3 run");
        });
        customThead3.start();

        Thread customThead4= new Thread(()-> System.out.println("customThead4 run"));
        customThead4.start();

        CustomThread5 customThread5=new CustomThread5();
        Thread customThead5= new Thread(customThread5::doSome);
        customThead5.start();

        //priority
        //customThead1.setPriority(1);
        //customThead2.setPriority(10);

        //customThead1.start();
        //customThead2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(customThead1);
        executorService.submit(customThead2);

        executorService.shutdown();

    }
}
