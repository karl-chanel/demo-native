package com.example.demoimports.anno;

import com.example.demoimports.config.HelloConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-29 14:49
 **/
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> types = importingClassMetadata.getAnnotationTypes();
        types.forEach(System.out::println);
        return new String[]{HelloConfig.class.getName()};
    }
}
