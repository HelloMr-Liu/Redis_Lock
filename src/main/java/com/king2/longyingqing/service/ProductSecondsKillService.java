package com.king2.longyingqing.service;

import com.king2.longyingqing.pojo.ProductSecondKillDesc;
import com.king2.longyingqing.vo.SystemResult;

/**
 * ================================================================
 * 说明：商品秒杀业务接口
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  14:44            创建
 * =================================================================
 **/
public interface ProductSecondsKillService {

    /**
     *  功能：添加对的秒杀商品
     *  时间：2020/4/27 14:43
     *  参数：名称                       类型                          描述
     *       productSecondKillDesc    ProductSecondKillDesc         秒杀商品信息
     *
     *  返回：SystemResult
     *  描述：封装响应请求信息 状态码及对应的信息
     */
    public SystemResult setProductSecondsKill(ProductSecondKillDesc productSecondKillDesc);

    /**
     *  功能：获取秒杀商品信息
     *  时间：2020/4/27 14:56
     *  参数：名称            类型            描述
     *       无             无              无
     *  返回：SystemResult
     *  描述：封装响应请求信息 状态码及对应的信息
     */
    SystemResult getProductSecondsKill();


    /**
     *  功能：获取秒杀商品时间
     *  时间：2020/4/27 14:54
     *  参数：名称            类型            描述
     *       无             无              无
     *  返回：SystemResult
     *  描述：封装响应请求信息 状态码及对应的信息
     */
    SystemResult getProductSecondsKillTime();



}