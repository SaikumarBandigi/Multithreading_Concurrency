package multithreadingtut;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {

        ThreadExample example = new ThreadExample();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                example.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                example.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(example.getCount());

    }

    int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

