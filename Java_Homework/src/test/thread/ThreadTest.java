package test.thread;

import static java.lang.Thread.sleep;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread:" + i);
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("runnable:" + i);

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main:" + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
