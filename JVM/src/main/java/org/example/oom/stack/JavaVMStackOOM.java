package org.example.oom.stack;

/**
 * VM Args: -Xss2M
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            final Thread thread = new Thread(() -> {
                final int[] ints = new int[1024];
                final int length = ints.length;
                dontStop();
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        final JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
