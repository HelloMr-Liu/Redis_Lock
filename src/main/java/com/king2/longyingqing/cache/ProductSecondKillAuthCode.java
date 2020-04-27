package com.king2.longyingqing.cache;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ================================================================
 * 说明：商品秒杀授权码缓存
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  15:08            创建
 * =================================================================
 **/
@Data
@Component
public class ProductSecondKillAuthCode {

    //私有
    private ProductSecondKillAuthCode(){}

    //创建一个存储商品秒杀对应的授权码
    private ConcurrentLinkedDeque<String> authCode=new ConcurrentLinkedDeque<>();

    //创建一个lock锁
    private Lock lock=new ReentrantLock();

    /**
     *  功能：默认初始化生产1万个商品秒杀授权码
     *  时间：2020/4/27 15:16
     */
    @PostConstruct
    public void initProductSecondKillAuthCode(){
        refreshAuthCode();
    }
    /**
     *  功能：获取商品秒杀授权码
     *  时间：2020/4/27 15:45
     *  返回：String
     *  描述：获取一个32位的商品秒杀授权码
     */
    public String getProductSecondKillAuthCode(){
        try{
            lock.lock();
            //判断当前授权码数量是否小于200个
            if(authCode.size()<200){
                refreshAuthCode();
            }
            return authCode.getFirst();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
            return "";
        }
    }
    /**
     *  功能：默认更新一万加授权码
     *  时间：2020/4/27 15:44
     */
    public void refreshAuthCode(){
        while(authCode.size()<10000){
            authCode.addLast(getUUID());
        }
    }
    /**
     *  功能：获取最长32位的UUID
     *  时间：2020/4/27 15:19
     *  参数：名称            类型            描述
     *  返回：String
     *  描述：返回最长32位的UUID
     */
    private String getUUID(){
        //获取UUID
        String simpleUUID1 = IdUtil.simpleUUID();
        return simpleUUID1;
    }

}
