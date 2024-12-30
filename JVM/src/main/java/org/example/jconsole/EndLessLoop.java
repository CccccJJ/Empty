package org.example.jconsole;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndLessLoop {

    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        final Thread thread = new Thread(() -> {
            while (true)
                ;
        }, "testBusyThread");

        thread.start();
    }

    /**
     * 线程锁等待演示
     *
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        final Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread");

        thread.start();
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        final Object obj = new Object();
        createLockThread(obj);
    }

}
