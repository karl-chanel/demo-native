package com.example.demohttpexchange;

import com.example.demohttpexchange.entity.AlbumsReq;
import com.example.demohttpexchange.entity.AlbumsResp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoHttpExchangeApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoHttpExchangeApplication.class, args);
        AlbumClient client = context.getBean(AlbumClient.class);
        AlbumsResp resp = client.add(AlbumsReq.builder().title("artpop").userId(50L).build());
        System.out.println(resp);
        client.getAll().forEach(System.out::println);
//        System.out.println(client.getById(1L));
    }
}
