package homework.second.QueueNumber;

public class Caller implements Runnable {
    private Queue queue;
    private int seq;

    public Caller(Queue queue, int seq) {
        this.queue = queue;
        this.seq = seq;
    }

    @Override
    public void run() {
        synchronized (queue) {
            queue.numberOff(seq);
        }
    }
}
