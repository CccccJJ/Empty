package org.example.classloader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        final ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    final InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] ba = new byte[is.available()];
                    is.read(ba);
                    return defineClass(name, ba, 0, ba.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        final Object obj = classLoader.loadClass("org.example.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof org.example.classloader.ClassLoaderTest);
    }

}
