package com.example.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-21 18:33
 **/
//@Component
@Slf4j
public class ScheduleDemo {
    @Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public static void schedule() {
        log.info("inside schedule");
    }
}
