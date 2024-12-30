package org.example.classloader;

/**
 * 被动实用类字段演示二：
 * 使用数组定义来引用类，不会导致此类初始化
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca = new  SuperClass[10];
    }
}
