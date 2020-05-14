package com.king2.longyingqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ================================================================
 * 说明：redis分布式锁的启动入口
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  11:21            创建
 * =================================================================
 **/
@SpringBootApplication
//引入多个配置文件
@PropertySources(
    {@PropertySource(value = "classpath:redisConfig.properties",encoding = "utf-8")}
)
public class Redis_Distributed_LockMain {
    public static void main(String[] args) {
        SpringApplication.run(Redis_Distributed_LockMain.class);
    }
}
