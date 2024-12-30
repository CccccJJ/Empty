package org.example.oom.stack;

/**
 * VM Args: -Xss180k
 */
public class JavaVMStackSOF1 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        final JavaVMStackSOF1 oom = new JavaVMStackSOF1();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
