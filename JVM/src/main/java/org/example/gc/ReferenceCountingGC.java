package org.example.gc;

/**
 * VM Args: -verbose:gc
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1027 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = objB = null;

        // objA、objB 是否能够被回收？
        // [0.073s][info][gc] GC(0) Pause Full (System.gc()) 11M->0M(16M) 2.979ms
        // 11M -> 0M 成功回收，所以 java 使用的不是 ReferenceCountingGC 引用计数
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
