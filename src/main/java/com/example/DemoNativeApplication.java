package com.example;

import cn.hutool.core.util.ReflectUtil;
import com.example.anno.Log;
import com.example.controller.HelloController;
import com.example.entity.User;
import com.example.property.MyCustomProperties;
import com.example.reflectdemo.ReflectCaseDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;

class MyCustomerControllerRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerMethod(ReflectUtil.getMethod(ReflectCaseDemo.class, "hello", int.class), ExecutableMode.INVOKE).registerType(ReflectCaseDemo.class);
        hints.reflection().registerType(HelloController.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS)).registerType(Log.class);
        hints.proxies().registerJdkProxy(FactoryBean.class, BeanClassLoaderAware.class, ApplicationListener.class);
        hints.proxies().registerJdkProxy(ApplicationAvailability.class, ApplicationListener.class);
        hints.resources().registerPattern("test.yml");
    }
}

@EnableAspectJAutoProxy
@SpringBootApplication
@Slf4j
@ImportRuntimeHints(MyCustomerControllerRuntimeHints.class)
public class DemoNativeApplication {
    public static Class<?> Class;
    public static Method method;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private int count;
    private ReflectCaseDemo reflectCaseDemo;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoNativeApplication.class, args);
        MyCustomProperties myconfig = (MyCustomProperties) context.getBean("myCustomProperties");
        System.out.println(myconfig);
        User userBean = (User) context.getBean("user");
        System.out.println(userBean.getAddress());
//        Arrays.stream(context.getBeanDefinitionNames()).filter((n) -> {
//            return n.startsWith("m");
//        }).forEach(System.out::println);
//        MyCustomProperties bean = (MyCustomProperties) context.getBean("myCustomProperties");
//        System.out.println(bean.getAge());
//        System.out.println(bean.getName());
//        System.out.println(Arrays.toString(args));
//        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
//        List<String> arguments = runtimeMXBean.getInputArguments();
//        for (String argument : arguments) {
//            System.out.println(argument);
//        }
//        // jvmName
//        System.out.printf("jvmName: %s %n", runtimeMXBean.getVmName());
//        // jvmVersion
//        System.out.printf("jvmVersion: %s %n", runtimeMXBean.getVmVersion());
//        // jvmVendor
//        System.out.printf("jvmVendor: %s %n", runtimeMXBean.getVmVendor());


        // startTime 使用hutool中DateUtil进行转换
//        long startTime = runtimeMXBean.getStartTime();
//        System.out.printf("startTime: %s %n", DateUtil.date(startTime).toString());
        // classPath
//        System.out.printf("classPath: %s %n", runtimeMXBean.getClassPath());
        // systemProperties
//        System.out.printf("jvmName: %s %n", runtimeMXBean.getSystemProperties());
        // bootClassPath
//        System.out.printf("bootClassPath: %s %n", runtimeMXBean.getBootClassPath());
        // processId
//        System.out.printf("processId: %s %n", runtimeMXBean.getName().split("@")[0]);
    }
}

