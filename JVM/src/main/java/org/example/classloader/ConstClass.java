package org.example.classloader;

public class ConstClass {
    static {
        System.out.println("ConstClass  init!");
    }

    public static final String HELLO_WORLD = "hello world";
}
