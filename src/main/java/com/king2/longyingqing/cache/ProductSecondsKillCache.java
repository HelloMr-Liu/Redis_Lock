package com.king2.longyingqing.cache;

import com.king2.longyingqing.pojo.ProductSecondKillDesc;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ================================================================
 * 说明：当前类说说明
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  16:05            创建
 * =================================================================
 **/
@Component
public class ProductSecondsKillCache {
    private Logger logger= LoggerFactory.getLogger(ProductSecondKillDesc.class);

    //存储商品秒杀缓存容器
    private Map<String, ProductSecondKillDesc> productSecondsKill=new ConcurrentHashMap<>();

    /**
     *  功能：获取有效秒杀商品的信息集合
     *  时间：2020/4/27 16:18
     *  返回：List
     *  描述：存储有效时间内的商品秒杀信息集合
     */
    public List<ProductSecondKillDesc> validProducts(){
        return productSecondsKill.entrySet().stream()
        .filter(e->{
            return e.getValue().getValidTime().getTime()>new Date().getTime();
        })
        .map(e->{
            return e.getValue();
        })
        .collect(Collectors.toList());
    }
    /**
     *  功能：定时更新商品秒杀信息缓存
     *  时间：2020/4/27 16:38
     */
    @Scheduled(cron = "0 08 18 ? * *")  //每天上午10:15触发
    public void refreValidProductSecondKill(){
        productSecondsKill=productSecondsKill.entrySet().stream()
        .filter(e -> {
            return e.getValue().getValidTime().getTime()>new Date().getTime();
        })
        .map(e->{return e.getValue();})
        .collect(Collectors.toMap(ProductSecondKillDesc::getProductName, Function.identity(), (key1, value1) -> key1));
        logger.info("刷新对应的秒杀商品信息："+productSecondsKill.size());
    }

}
