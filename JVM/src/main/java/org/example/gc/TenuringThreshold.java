package org.example.gc;

/**
 * VM Args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=15
 */
public class TenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4]; // allocation1 + allocation2 > Survivor 空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
