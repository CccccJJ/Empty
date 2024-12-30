package org.example.jhsdb;

/**
 * staticObj、instanceObj、localObj 存放在哪里？
 * staticObj 放在方法区
 * instanceObj 放在 Java 堆
 * localObject 放在 foo() 方法栈针的局部变量（引用类型）
 *
 * -Xmx10m -XX:+UseSerialGC
 *
 * jhsdb hsdb --pid 33732
 */
public class JHSDBTestCase {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            final ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设置一个断点
        }
    }

    private static class ObjectHolder {
        public static void main(String[] args) {
            final Test test = new Test();
            test.foo();
        }
    }
}
