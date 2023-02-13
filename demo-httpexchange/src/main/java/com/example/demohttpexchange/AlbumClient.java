package com.example.demohttpexchange;

import com.example.demohttpexchange.entity.AlbumsReq;
import com.example.demohttpexchange.entity.AlbumsResp;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-03 20:54
 **/
@HttpExchange("/albums")
public interface AlbumClient {
    @GetExchange
    List<AlbumsResp> getAll();
    @GetExchange("/{id}")
    AlbumsResp getById(@PathVariable Long id);
    @PostExchange
    AlbumsResp add(@RequestBody @Valid AlbumsReq req);
}
