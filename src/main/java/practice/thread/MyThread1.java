package practice.thread;

import java.util.stream.IntStream;

public class MyThread1 extends Thread{
    public void run(){
        System.out.println("MyThread1 Start");
        IntStream.range(0, 200).forEach(i->{
            System.out.println("MyThread1 "+i);
        });
        System.out.println("MyThread1 End");
    }

}
