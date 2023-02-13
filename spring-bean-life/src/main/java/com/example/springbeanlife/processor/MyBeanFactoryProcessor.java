package com.example.springbeanlife.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-25 15:00
 **/

public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(beanFactory + " inside the processor");
        System.out.println(System.currentTimeMillis() + " in the processor");
    }
}
