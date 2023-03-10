package com.example.property;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-22 16:32
 **/
public class YmlConfigFactory extends DefaultPropertySourceFactory {
    private static String YML = ".yml";
    private static String YAML = ".yaml";

    /**
     * @param name：@PropertySource 注解 name 的值
     * @param resource：资源
     */
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        // 文件名称
        String filename = resource.getResource().getFilename();
        // 属性源的名称
        String resourceName = Optional.ofNullable(name).orElse(filename);
        if (filename.endsWith(YML) || filename.endsWith(YAML)) {
            List<PropertySource<?>> yamlSources = new YamlPropertySourceLoader().load(resourceName, resource.getResource());
            return yamlSources.get(0);
        } else {
            // 其他文件后缀
            return new DefaultPropertySourceFactory().createPropertySource(name, resource);
        }
    }
}