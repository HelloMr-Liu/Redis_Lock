package com.king2.longyingqing.controller;

import com.king2.longyingqing.pojo.ProductSecondKillDesc;
import com.king2.longyingqing.utils.JsonUtils;
import com.king2.longyingqing.vo.SystemResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ================================================================
 * 说明：商品秒杀,请求控制类
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  14:41            创建
 * =================================================================
 **/
@Controller
public class ProductSecondsKillController {


    @RequestMapping("/testDate")
    @ResponseBody
    public SystemResult testDate(ProductSecondKillDesc productSecondKillDesc){
        return SystemResult.ok(JsonUtils.objectToJson(productSecondKillDesc));
    }


    /**
     *  功能：添加对的秒杀商品
     *  时间：2020/4/27 14:43
     *  参数：名称            类型            描述
     *       productName    String         秒杀的商品名称
     *
     *  返回：SystemResult
     *  描述：封装响应请求信息 状态码及对应的信息
     */
    @RequestMapping("/setProductSecondsKill")
    @ResponseBody
    public SystemResult setProductSecondsKill(String productName){

        return null;
    }

    /**
     *  功能：获取秒杀商品信息
     *  时间：2020/4/27 14:56
     *  参数：名称            类型            描述
     *       无             无              无
     *  返回：SystemResult
     *  描述：封装响应请求信息 状态码及对应的信息
     */
    @RequestMapping("/getProductSecondsKill")
    @ResponseBody
    public SystemResult getProductSecondsKill() {
        return null;
    }

    /**
     *  功能：获取秒杀商品时间
     *  时间：2020/4/27 14:54
     *  参数：名称            类型            描述
     *       无             无              无
     *  返回：SystemResult
     *  描述：封装响应请求信息 状态码及对应的信息
     */
    @RequestMapping("/getProductSecondsKillTime")
    @ResponseBody
    public SystemResult getProductSecondsKillTime() {
        return null;
    }
}
