package com.example.resource;

import sun.misc.URLClassPath;

import java.lang.reflect.Field;
import java.net.URL;

public class ClassLoaderResource {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final ClassLoader classLoader = ClassLoaderResource.class.getClassLoader();
        Class<? extends ClassLoader> classLoaderClass = classLoader.getClass();
        System.out.println(classLoaderClass); // class sun.misc.Launcher$AppClassLoader
        System.out.println(classLoader.getParent()); // sun.misc.Launcher$ExtClassLoader@762efe5d
        System.out.println(classLoader.getParent().getParent()); // null

        System.out.println();
        Field urlClassPathField = classLoaderClass.getDeclaredField("ucp");
        urlClassPathField.setAccessible(true);
        URLClassPath urlClassPath = (URLClassPath) urlClassPathField.get(classLoader);
        for (URL url : urlClassPath.getURLs()) {
            System.out.println(url);
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/charsets.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/deploy.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/cldrdata.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/dnsns.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/jaccess.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/jfxrt.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/localedata.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/nashorn.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/sunec.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/ext/zipfs.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/javaws.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/jce.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/jfr.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/jfxswt.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/jsse.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/management-agent.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/plugin.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/resources.jar
            //file:/Users/cc/Modules/Jdk/jdk1.8.0_431.jdk/Contents/Home/jre/lib/rt.jar
            //file:/Users/cc/Projects/Empty/Resource/target/classes/
            //file:/Users/cc/.m2/repository/org/springframework/boot/spring-boot-starter/2.6.13/spring-boot-starter-2.6.13.jar
            //file:/Users/cc/.m2/repository/org/springframework/boot/spring-boot/2.6.13/spring-boot-2.6.13.jar
            //file:/Users/cc/.m2/repository/org/springframework/spring-context/5.3.23/spring-context-5.3.23.jar
            //file:/Users/cc/.m2/repository/org/springframework/spring-aop/5.3.23/spring-aop-5.3.23.jar
            //file:/Users/cc/.m2/repository/org/springframework/spring-beans/5.3.23/spring-beans-5.3.23.jar
            //file:/Users/cc/.m2/repository/org/springframework/spring-expression/5.3.23/spring-expression-5.3.23.jar
            //file:/Users/cc/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.6.13/spring-boot-autoconfigure-2.6.13.jar
            //file:/Users/cc/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.6.13/spring-boot-starter-logging-2.6.13.jar
            //file:/Users/cc/.m2/repository/ch/qos/logback/logback-classic/1.2.11/logback-classic-1.2.11.jar
            //file:/Users/cc/.m2/repository/ch/qos/logback/logback-core/1.2.11/logback-core-1.2.11.jar
            //file:/Users/cc/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.17.2/log4j-to-slf4j-2.17.2.jar
            //file:/Users/cc/.m2/repository/org/apache/logging/log4j/log4j-api/2.17.2/log4j-api-2.17.2.jar
            //file:/Users/cc/.m2/repository/org/slf4j/jul-to-slf4j/1.7.36/jul-to-slf4j-1.7.36.jar
            //file:/Users/cc/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar
            //file:/Users/cc/.m2/repository/org/springframework/spring-core/5.3.23/spring-core-5.3.23.jar
            //file:/Users/cc/.m2/repository/org/springframework/spring-jcl/5.3.23/spring-jcl-5.3.23.jar
            //file:/Users/cc/.m2/repository/org/yaml/snakeyaml/1.29/snakeyaml-1.29.jar
            //file:/Users/cc/.m2/repository/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar
            //file:/Applications/IntelliJ%20IDEA.app/Contents/lib/idea_rt.jar
            //file:/Users/cc/Library/Caches/JetBrains/IntelliJIdea2024.2/captureAgent/debugger-agent.jar
        }
        System.out.println();

        final URL abcTxt = classLoader.getResource("abc.txt");
        System.out.println(abcTxt); // file:/Users/cc/Projects/Empty/Resource/target/classes/abc.txt

        final URL classpathAbcTxt = classLoader.getResource("classpath:abc.txt");
        System.out.println(classpathAbcTxt); // null
    }

}
