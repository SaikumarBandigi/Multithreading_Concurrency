package interviewQuestionTut;

class Task implements Runnable {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Thread running...");
        }
        System.out.println("Thread stopped");
    }

    public void stop() {
        running = false;
    }
}


public class Example {
    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();
        Thread t = new Thread(task);

        t.start();

        Thread.sleep(2000);

        task.stop();

        System.out.println("Stop requested");

    }
}