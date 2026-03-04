package interviewQuestionTut;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    public static void main(String[] args) {

        ThreadSafeCounter counter = new ThreadSafeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 99; i++) {
                counter.decrement();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {

        }

        System.out.println(counter.getCount());


    }

    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
