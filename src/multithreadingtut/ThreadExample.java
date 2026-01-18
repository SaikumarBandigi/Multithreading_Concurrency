package multithreadingtut;

public class ThreadExample {
    public static void main(String[] args) throws Exception {

        ThreadExample obj = new ThreadExample();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                obj.increment();
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                obj.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(obj.getCount());

    }


    int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }


}

