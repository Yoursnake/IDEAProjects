package test.thread;

public class NotifyTest {
    static class Middle {
        private int n;
        private boolean isValueSet = false;

        public synchronized void get() {
            if (!isValueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("get: " + n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isValueSet = false;
            notify();
        }

        public synchronized void put(int n) {
            if (isValueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.n = n;
            System.out.println("put: " + n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isValueSet = true;
            notify();
        }
    }

    static class Getter implements Runnable {
        Middle middle;

        public Getter(Middle middle) {
            this.middle = middle;
        }

        @Override
        public void run() {
            while (true) {
                middle.get();
            }
        }
    }

    static class Putter implements Runnable {
        Middle middle;

        public Putter(Middle middle) {
            this.middle = middle;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                middle.put(i++);
            }
        }
    }

    public static void main(String[] args) {
        Middle middle = new Middle();
        new Thread(new Putter(middle)).start();
        new Thread(new Getter(middle)).start();
    }

}
