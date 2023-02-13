package com.example.demohttpexchange;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-03 21:07
 **/
@Configuration
public class HttpExhangeConfig {
    @Bean
    public AlbumClient albumsClient(WebClient.Builder webClientBuilder) {
        WebClient webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
        return HttpServiceProxyFactory.builder().clientAdapter(WebClientAdapter.forClient(webClient)) //
                .build().createClient(AlbumClient.class);
    }
}
