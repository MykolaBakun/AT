package practice.thread_2;

public class CustomThread2 implements Runnable{
    @Override
    public void run(){
//        System.out.println("CustomThread2 run");
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);}
        System.out.println(Thread.currentThread().getName()+ " stop");
    }
}
