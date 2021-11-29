package practice.thread;

public class ThreadRunner {
    public static void main(String[] args) {
        ThreadRunner threadRunner = new ThreadRunner();
        Thread thread = new Thread(threadRunner::doSomething);
        thread.start();
            //OR
        thread = new Thread(()->threadRunner.doSomething());//The same
    }

    private void doSomething() {
        System.out.println("do something");
    }
}
