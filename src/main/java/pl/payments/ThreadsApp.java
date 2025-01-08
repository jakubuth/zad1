package pl.payments;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsApp {

    public static void main(String[] args) {
        WatekLiczacy w1 = new WatekLiczacy();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        Thread t4 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }


    public static class WatekLiczacy implements Runnable {
        int i = 0;
        int j = 0;
        AtomicInteger licznik = new AtomicInteger();
        @Override
        public void run() {

            AtomicInteger licznik2 = new AtomicInteger();

            for (int j=0; j < 100_000; j++) {
                synchronized (licznik) {
                    i++;
                }

//                System.out.println("hello");
//                System.out.printf("Watek: %d i: %d j: %d\n", Thread.currentThread().threadId(), i, j);
//                System.out.printf("Watek: %d %d %d\n", Thread.currentThread().threadId(), i, licznik.get());
//                licznik.incrementAndGet();
            }
            System.out.println("end i: " + i);
        }
    }

}
