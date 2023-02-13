package com.example.asm;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-30 21:23
 **/
public class HelloRun {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = classLoader.loadClass("sample.HelloWorld");
        Object instance = clazz.newInstance();
        System.out.println(instance);
    }
}
