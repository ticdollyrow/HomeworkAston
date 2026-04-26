package ru.aston.step1.homework.module4.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    static class Friend {
        private final String name;
        private final Lock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void bow(Friend bower) {
            lock.lock();

            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
            System.out.println("bower bowBack");
            lock.unlock();
            System.out.println("method bow");
        }

        public void bowBack(Friend bower) {
            lock.lock();
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
            lock.unlock();
        }
    }

    static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();


    }
}
