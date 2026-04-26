package ru.aston.step1.homework.module4.livelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Livelock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static void main() {
        final Livelock livelock = new Livelock();
        new Thread(livelock::operation1, "Thread1").start();
        new Thread(livelock::operation2, "Thread2").start();

    }

    public void operation1(){

        while (true){
            try {
                lock1.tryLock(100, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("operation1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(lock2.tryLock()){
                System.out.println("lock2 operation1");
            }else{
                lock1.unlock();
                continue;
            }

            break;

        }

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2(){

        while (true){
            try {
                lock2.tryLock(100, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("operation2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(lock1.tryLock()){
                System.out.println("lock1 operation2");
            }else{
                lock2.unlock();
                continue;
            }
            break;
        }

        lock2.unlock();
        lock1.unlock();
    }
}
