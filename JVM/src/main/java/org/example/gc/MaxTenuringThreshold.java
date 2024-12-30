package org.example.gc;

/**
 * VM Args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
 * VM Args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=15
 */
public class MaxTenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4]; // 什么时候进入老年代取决于 XX:MaxTenuringThreshold
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
