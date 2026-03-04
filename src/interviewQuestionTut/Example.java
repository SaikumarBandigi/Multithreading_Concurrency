package interviewQuestionTut;


class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("sai");
    }
}


public class Example {
    public static void main(String[] args) {


        Thread t1 = new Thread(new MyThread());
        t1.start();

    }
}
