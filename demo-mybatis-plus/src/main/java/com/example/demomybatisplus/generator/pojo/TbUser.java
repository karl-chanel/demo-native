package com.example.demomybatisplus.generator.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @TableName tb_user
 */
@TableName(value ="tb_user")
@Data
@Builder
public class TbUser implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer user_id;
    /**
     *
     */
    @TableField(value = "user_address")
    private String user_address;
    /**
     *
     */
    @TableField(value = "user_date")
    private LocalDate user_date;
    /**
     *
     */
    @TableField(value = "user_phone")
    private String user_phone;
    /**
     *
     */
    @TableField(value = "user_name")
    private String user_name;
}