package practice.thread_2;

public class CustomThread1 extends Thread{
    @Override
    public void run(){
//        System.out.println("CustomThread1 run");

        for(int i=0; i<10; i++){
        System.out.println(Thread.currentThread().getName()+" "+i);}
        System.out.println(Thread.currentThread().getName()+" stop");
    }
}
