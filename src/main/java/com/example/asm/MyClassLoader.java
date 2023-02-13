package com.example.asm;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-30 21:22
 **/

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if ("sample.HelloWorld".equals(name)) {
            byte[] bytes = HelloWorld.dump();
            Class<?> clazz = defineClass(name, bytes, 0, bytes.length);
            return clazz;
        }
        throw new ClassNotFoundException("Class Not Found: " + name);
    }
}
