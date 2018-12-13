package homework.second.QueueNumber;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Queue queue = new Queue(10);
        Thread t1 = new Thread(new Caller(queue, 1));
        Thread t2 = new Thread(new Caller(queue, 2));
        t1.start();
        t2.start();

    }
}
