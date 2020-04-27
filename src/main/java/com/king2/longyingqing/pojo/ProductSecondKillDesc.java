package com.king2.longyingqing.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ================================================================
 * 说明：秒杀商品秒杀类
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  16:06            创建
 * =================================================================
 **/
@Data
public class ProductSecondKillDesc {
    private String productName; //商品名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;    //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date validTime;     //有效时间
}
