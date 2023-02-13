package com.example.demomybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.demomybatisplus.generator.mapper.TbUserMapper;
import com.example.demomybatisplus.generator.pojo.TbUser;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoMybatisPlusApplication {

    public static void main(String[] args) {
        tb_user(args);
    }

    private static void tb_user(String[] args) {
        TbUserMapper mapper = SpringApplication.run(DemoMybatisPlusApplication.class, args).getBean(TbUserMapper.class);
        mapper.insert(TbUser.builder().user_address("anhui").user_date(LocalDate.now()).user_name("karl").user_phone("17682893539").build());
        mapper.selectList(null).forEach(System.out::println);
    }

    @Bean
    MetaObjectHandler handler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.strictInsertFill(metaObject,"create_time", LocalDateTime.class,LocalDateTime.now());
            }

            @Override
            public void updateFill(MetaObject metaObject) {

            }
        };
    }
}
