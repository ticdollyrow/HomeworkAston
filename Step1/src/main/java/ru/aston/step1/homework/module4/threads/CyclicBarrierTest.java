package ru.aston.step1.homework.module4.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier secondCanRun = new CyclicBarrier(2);
    static CyclicBarrier firstCanRun = new CyclicBarrier(2);

    public void firstMethod() {
        while (true) {
            try {
                firstCanRun.await();
                System.out.println("1");
                Thread.sleep(1000);
                secondCanRun.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void secondMethod() {
        try {
            firstCanRun.await();
            while (true) {
                secondCanRun.await();
                System.out.println("2");
                Thread.sleep(1000);
                firstCanRun.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }

    static void main() {
        final CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();

        new Thread(() -> cyclicBarrierTest.firstMethod(), "Thread1").start();
        new Thread(() -> cyclicBarrierTest.secondMethod(), "Thread1").start();


    }
}
