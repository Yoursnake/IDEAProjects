package homework.second.QueueNumber;

public class Queue {
    private int num;

    public Queue(int num) {
        this.num = num;
    }

    public void numberOff(int seq) {
        for (int i = 0; i < num; i++) {
            System.out.println("Queue " + seq + ": " + (i + 1));
        }
    }
}

