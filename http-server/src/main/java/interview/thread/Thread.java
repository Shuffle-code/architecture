package interview.thread;

import interview.ping_pong.PingPong;
import java.util.concurrent.locks.ReentrantLock;

public class Thread {
        public static void main(String[] args) {
            PingPong pingPong = new PingPong();
            java.lang.Thread thread1 = new java.lang.Thread(pingPong::printPing);
            java.lang.Thread thread2 = new java.lang.Thread(pingPong::printPong);
            thread1.start();
            thread2.start();
        }
        public class Count {
            ReentrantLock lock = new ReentrantLock();
            int count = 0;

            void increment() {
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }
        }
}
