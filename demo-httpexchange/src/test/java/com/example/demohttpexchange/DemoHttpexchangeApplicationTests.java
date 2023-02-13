package com.example.demohttpexchange;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoHttpExchangeApplicationTests {
    @Autowired
    AlbumClient albumClient;

    @Test
    void contextLoads() {
        System.out.println(albumClient.getAll());
    }

}
