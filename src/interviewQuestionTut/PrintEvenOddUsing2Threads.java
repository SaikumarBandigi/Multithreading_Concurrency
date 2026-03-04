package interviewQuestionTut;


class NumberPrinter {

    int number = 1;

    int limit;

    public NumberPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (number <= limit) {
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Odd:" + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= limit) {
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Even:" + number);
                number++;
                notify();
            }
        }
    }
}

public class PrintEvenOddUsing2Threads {
    public static void main(String[] args) {

        NumberPrinter np = new NumberPrinter(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                np.printOdd();
            }
        });
        Thread t2 = new Thread(np::printEven);

        t1.start();
        t2.start();

    }
}
