package com.example.filter;

import com.example.TestBean;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-31 04:40
 **/
@EqualsAndHashCode(callSuper = false)
public class MyFilter extends TypeExcludeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return metadataReader.getClassMetadata().getClassName().equals(TestBean.class.getName()+"dfsv");
    }
}
