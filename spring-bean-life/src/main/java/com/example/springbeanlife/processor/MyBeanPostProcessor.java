package com.example.springbeanlife.processor;

import com.example.springbeanlife.bean.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-25 14:32
 **/

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("hello")) {
            if (bean instanceof Hello hello) {
                hello.test();
            }
            log.info(beanName);
            log.info(bean.toString());
//        Hello hello = (Hello) bean;
//        hello.test();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("hello")) {
            if (bean instanceof Hello hello) {
                hello.test();
            }
            log.info(beanName);
            log.info(bean.toString());
//        Hello hello = (Hello) bean;
//        hello.test();
        }
        return bean;
    }
}
