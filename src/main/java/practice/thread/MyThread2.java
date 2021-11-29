package practice.thread;

import java.util.stream.IntStream;

public class MyThread2 implements Runnable{
    public void run(){
        System.out.println("MyThread2 Start");
        IntStream.range(0, 200).forEach(i->{
            System.out.println("MyThread2 "+i);
        });
        System.out.println("MyThread2 End");
    }


}
