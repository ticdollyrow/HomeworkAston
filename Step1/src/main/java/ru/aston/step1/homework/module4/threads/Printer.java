package ru.aston.step1.homework.module4.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    private final Lock lock = new ReentrantLock();
    private final static int FIRST = 1;
    private final static int SECOND = 2;

    private final Condition turn1 = lock.newCondition();
    private final Condition turn2 = lock.newCondition();
    private int currentThread = 1;


    public void print1() {
        while (true) {
            lock.lock();
            try {
                while (currentThread != FIRST) {
                    turn1.await();
                }
                System.out.println("1");
                Thread.sleep(1000);
                currentThread = SECOND;
                turn2.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void print2() {
        while (true) {
            lock.lock();
            try {
                while (currentThread != SECOND) {
                    turn2.await();
                }
                System.out.println("2");
                Thread.sleep(1000);
                currentThread = FIRST;
                turn1.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    static void main() {
        final Printer printer = new Printer();
        new Thread(printer::print1, "Thread 1").start();
        new Thread(printer::print2, "Thread 2").start();

    }
}
