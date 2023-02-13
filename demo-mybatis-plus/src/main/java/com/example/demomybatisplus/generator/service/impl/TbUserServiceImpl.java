package com.example.demomybatisplus.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatisplus.generator.pojo.TbUser;
import com.example.demomybatisplus.generator.service.TbUserService;
import com.example.demomybatisplus.generator.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

/**
* @author devgeek
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-02-02 18:33:04
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
    implements TbUserService{

}




