package org.example.bytecode;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class MethodHandleTest2 {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            try {
                final MethodType methodType = MethodType.methodType(void.class);

                final Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);

                final MethodHandle thinking = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class,
                        "thinking", methodType, GrandFather.class);

                thinking.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MethodHandleTest2().new Son().thinking();
    }

}
