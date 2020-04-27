package com.king2.longyingqing;

import com.king2.longyingqing.pojo.Student;
import com.king2.longyingqing.utils.JsonUtils;
import com.king2.longyingqing.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ================================================================
 * 说明：当前类说说明
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  13:02            创建
 * =================================================================
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Redis_Distributed_LockMain.class})
public class TestRedis {

    @Autowired
    private RedisUtil redisUtil;

    //判断key是否存在
    @Test
    public void testHasKey(){
        System.out.println("是否存在："+redisUtil.hasKey("aaa1"));
    }

    //判断key是否存在
    @Test
    public void testExists(){
        System.out.println("是否存在："+redisUtil.exists("aaa".getBytes()));
    }

    //指定key缓存失效时间
    @Test
    public void testExpire(){
        System.out.println("指定key缓存失效时间："+redisUtil.expire("aaa",60));
    }
    //根据key 获期时间
    @Test
    public void testGetExpire(){
        System.out.println("根据key 获取过期时间："+redisUtil.getExpire("STUDENT2"));
    }

    //删除key
    @Test
    public void testDelete() {
        redisUtil.del("a1","a2");
    }

    @Test //添加
    public void testSet(){
        System.out.println(redisUtil.set("STUDENT1", new Student("liuzijiang","21","江西省")));
    }

    @Test //添加并有时间
    public void testSetX(){
        System.out.println(redisUtil.setex("STUDENT2", new Student("liuzijiang","21","江西省"),200));
    }

    @Test//对key递增
    public void testincr(){
        redisUtil.incr("adawda",1);
        System.out.println(redisUtil.incr("adawda", 4));
    }
    @Test//对key递减
    public void testdecr(){
        System.out.println(redisUtil.decr("a4", 2));
    }


    @Test //获取
    public void getSet(){
        String student = redisUtil.get("STUDENT1");
        Student student1 = JsonUtils.jsonToPojo(student, Student.class);
        System.out.println(student1);
    }


    @Test
    public void lock(){
        boolean lock = redisUtil.lock("STUDENT_LOCK", "STUDENT_LOCK", 200);
        System.out.println(lock+"==============");

    }

    public void mysql(String name){
        boolean lock = redisUtil.lock("STUDENT_LOCK", "STUDENT_LOCK", 200);
        System.out.println(lock+"==============");
        //开启锁
        if(lock){
            System.out.println("过五秒后才能解锁"+"name");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //解锁操作
            redisUtil.unlock("STUDENT_LOCK","STUDENT_LOCK");
        }else{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"没有获取倒锁");
        }
    }
}
