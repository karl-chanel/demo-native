package com.example.controller;

import cn.hutool.core.util.StrUtil;
import com.example.Counter;
import com.example.anno.Log;
import com.example.entity.PayLoad;
import com.example.entity.User;
import com.example.reflectdemo.ReflectCaseDemo;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-20 01:33
 **/
@RestController
@Slf4j
@RequestMapping("homo")
public class HelloController {
    public static Class<?> aClass;
    public static Method method;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private int count;
    private ReflectCaseDemo reflectCaseDemo;

    @SneakyThrows
    private static void extracted() {
        val set = new HashSet<String>();
        PayLoad payLoad = PayLoad.builder().age(10).who("").location("").build();
        Class<?> name = Class.forName("com.example.reflectdemo.RfDemo2");
        Method main = name.getMethod("main", String[].class);
        main.invoke(null, (Object) new String[]{"sd", "svfds"});
    }

    @SneakyThrows
    private static void extracted1(String... args) {
        Arrays.stream(args).forEach(
                (a) -> {
                    log.info("the arg is {}", a);
                }
        );
        Class<?> name = Class.forName("com.example.reflectdemo.RfDemo2");
        Method main = name.getMethod("main", String[].class);
        main.invoke(null, (Object) new String[]{"sd", "svfds"});
    }

    @SneakyThrows
    @PostConstruct
    public void init() {
        reflectCaseDemo = new ReflectCaseDemo();
        aClass = Class.forName("com.example.reflectdemo.ReflectCaseDemo");
        method = aClass.getDeclaredMethod("hello", int.class);
    }

    @SneakyThrows
    @GetMapping("/json")
    public User json() {
        HelloController.method.invoke(reflectCaseDemo, Counter.count);
        extracted1("hello", "gaga", "peter");
        return new User("in-side", "Beijing", 100);
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @Log
    public PayLoad say(@RequestParam(required = false, name = "location") String location,
                       @RequestParam(required = false, name = "age") Integer age,
                       @RequestParam(required = false, name = "who") String who,
                       HttpServletRequest httpServletRequest) {

        Map<String, String[]> map = httpServletRequest.getParameterMap();
        for (String s : map.keySet()) {
            System.out.println(s + " " + Arrays.toString(map.get(s)));
        }
        String contextPath = httpServletRequest.getContextPath();
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRequestURL());
        String urlPath = httpServletRequest.getRequestURI().substring(httpServletRequest.getServletContext().getContextPath().length());
        System.out.println(contextPath);
        System.out.println(urlPath);
        String header = httpServletRequest.getHeader("my_header");
        log.info("my_header is {}", header);
        String name = httpServletRequest.getParameter("name");
        httpServletRequest.getSession().setAttribute("user", name);
        count++;
        if (StrUtil.isBlank(location)) {
            location = "hebei";
        }
        log.info(String.valueOf(count));
        return new PayLoad(location, age, who);
    }

    @GetMapping("/hello")
    @Log
    public void sayHello(@RequestParam(required = false, name = "who") String who, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cooki : cookies) {
                if (cooki.getName().equals("JSESSIONID")) {
                    cookie = cooki;
                }
            }
        }
        String s = null;
        String s1 = null;
        if (cookie != null) {
            s = cookie.getName();
        } else {
            s = "无cookie";
        }
        if (cookie != null) {
            s1 = cookie.getValue();
        } else {
            s1 = "无cookie";
        }
//        session.setMaxInactiveInterval(10);
//        int interval = session.getMaxInactiveInterval();
//        System.out.println(interval);
        // 获取 session 创建时间
        Date createTime = new Date(session.getCreationTime());
        // 获取该网页的最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        //设置日期输出的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String title = "Servlet Session 实例 - 菜鸟教程";
        Integer visitCount = Integer.valueOf(0);
        String visitCountKey = new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("Runoob");
        if (session.getAttribute(visitCountKey) == null) {
            session.setAttribute(visitCountKey, Integer.valueOf(0));
        }
        // 检查网页上是否有新的访问者
        if (session.isNew()) {
            title = "Servlet Session 实例 - 菜鸟教程";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userID = (String) session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session 信息</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "  <th>Session 信息</th><th>值</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>创建时间</td>\n" +
                "  <td>" + df.format(createTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>最后访问时间</td>\n" +
                "  <td>" + df.format(lastAccessTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>用户 ID</td>\n" +
                "  <td>" + userID +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>访问统计：</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>线程：</td>\n" +
                "  <td>" + Thread.currentThread().getName() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>session_left_time：</td>\n" +
                "  <td>" + session.getMaxInactiveInterval() + "s</td></tr>\n" + "<tr>\n" +
                "  <td> " + s + ":</td>\n" +
                "  <td>" + s1 + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>");
        log.info("visited time : " + dateTimeFormatter.format(LocalDateTime.now()));
    }
}