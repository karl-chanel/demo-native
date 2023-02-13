package com.example.demoimports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-29 09:59
 **/
public class TestImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> types = importingClassMetadata.getAnnotationTypes();
        types.forEach(System.out::println);
        return new String[0];
    }
}
