package com.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-30 23:52
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class DateTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ConfigurableApplicationContext context;

    @SneakyThrows
    @Disabled
    @Test
    @DisplayName("测试/homo/entity接口")
    public void test() {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/homo/entity")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
        ;

    }

    @SneakyThrows
    @Test
    @Disabled
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("测试context")
    public void testContext() {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @SneakyThrows
    @Disabled
    @Test
    @DisplayName("测试runtimeMXBean")
    public void runaTimeDemo() {

//        Class<?> name = Class.forName("com.example.entity.User");
//        Constructor<?> constructor = name.getDeclaredConstructor(String.class, String.class, int.class);
//        Object instance = constructor.newInstance("hello", "who", 20);
//        System.out.println(instance);
        StringBuilder sb = new StringBuilder();
        RuntimeMXBean mb = ManagementFactory.getRuntimeMXBean();
        if (mb != null) {
            sb.append(String.format("Java Name: %s\n", mb.getVmName()));
            sb.append(String.format("Java Version: %s\n", mb.getVmVersion()));
            sb.append(String.format("Java Vendor: %s\n", mb.getVmVendor()));
            sb.append(String.format("Uptime: %s\n", mb.getUptime() / 1000));
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
        System.out.println(sb);
    }

    @Test
    @DisplayName("测试DateTime")
    public void dateDemo() {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        String formattedDate = formatter.format(LocalDate.now());
        String formattedZonedDate = formatter.format(ZonedDateTime.now());
        System.out.println("LocalDate          : " + formattedDate);
        System.out.println("formattedZonedDate : " + formattedZonedDate);
        LocalDateTime dateTime = LocalDateTime.now();
        // 20180303
        String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        // 2013-03-03
        String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        // 当前时间
        String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        // 2018-03-03
        String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // 今天是：2018年 三月 03日 星期六
        String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("今天是：yyyy年 MMMM dd日 E", Locale.CHINESE));
        System.out.println(strDate1);
        System.out.println(strDate2);
        System.out.println(strDate3);
        System.out.println(strDate4);
        System.out.println(strDate5);
        // 将一个字符串解析成一个日期对象
        String strDate6 = "2018-03-03";
        String strDate7 = "2017-03-03 15:30:05";
        LocalDate date = LocalDate.parse(strDate6, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime dateTime1 = LocalDateTime.parse(strDate7, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(date);
        System.out.println(dateTime1);
    }
}
