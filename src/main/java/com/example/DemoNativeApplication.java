package com.example;

import cn.hutool.core.util.ReflectUtil;
import com.example.anno.Log;
import com.example.controller.HelloController;
import com.example.dao.User_Batia_Mapper;
import com.example.entity.User_Batis;
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
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

class HintsDemo {

    public static void main(String[] args) {
        var list = getList();
    }

    private static List<String> getList() {
        return Arrays.asList("hello", "world");
    }
}

@EnableAspectJAutoProxy
@SpringBootApplication
@Slf4j
@EnableAsync
@ServletComponentScan
@ImportRuntimeHints({MyCustomerControllerRuntimeHints.class})
public class DemoNativeApplication {
    public static Class<?> Class;
    public static Method method;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private int count;
    private ReflectCaseDemo reflectCaseDemo;

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(DemoNativeApplication.class);
//        ConfigurableApplicationContext context = application.run(args);
        ConfigurableApplicationContext run = SpringApplication.run(DemoNativeApplication.class, args);
//        operateDb(context);

//        System.out.println(context.getBean(TestBean.class));
//        System.out.println(context.getBean("myfilter"));
//        System.out.println(context.getBean("hola"));
//        Thread.currentThread().setName("hello");
//        System.out.println(context.getBean("ho"));
//        getRunTimeInfo();
    }

    private static void operateDb(ConfigurableApplicationContext context) {
        User_Batia_Mapper bean = context.getBean(User_Batia_Mapper.class);
        System.out.println(bean.getById(2));
        User_Batis userBatis = new User_Batis();
        userBatis.setUsername("amy");
        userBatis.setPassword("535177972");
        int i = bean.insert(userBatis);
        bean.update(5, new User_Batis("ron processly","21158492"));
    }

    private static void getRunTimeInfo() {
        StringBuilder sb = new StringBuilder();
        RuntimeMXBean mb = ManagementFactory.getRuntimeMXBean();
        if (mb != null) {
            sb.append(String.format("Java Name: %s\n", mb.getVmName()));
            sb.append(String.format("Java Version: %s\n", mb.getVmVersion()));
            sb.append(String.format("Java Vendor: %s\n", mb.getVmVendor()));
            sb.append(String.format("Uptime: %s milliseconds\n", mb.getUptime()));
            sb.append(String.format("PID: %s\n", mb.getPid()));
            if (!mb.getInputArguments().isEmpty()) {
                sb.append("Input Arguments:");
                String cp = String.join("\n    ", mb.getInputArguments());
                sb.append("\n    ").append(cp).append("\n");
            }
            if (mb.isBootClassPathSupported()) {
                sb.append("Boot Classpath:");
                String cp = String.join("\n    ", mb.getBootClassPath().split("[:|;]"));
                sb.append("\n    ").append(cp).append("\n");
            }
            sb.append("Classpath:");
            String cp = String.join("\n    ", mb.getClassPath().split(";"));
            sb.append("\n    ").append(cp).append("\n");
        }
        System.out.println(sb.toString());
    }
    

}
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


