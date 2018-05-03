package com.nsfc.platform.ws;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 测试redis
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/3
 */
public class TestRedis extends PlatformWsApplicationTests{

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        redisTemplate.opsForValue().set("xxx", "dadsd");
        redisTemplate.opsForValue().set("zzz", "全职猎人");
        System.out.println("调用redis成功");
    }

    @Test
    public void getValue(){
        Object name = redisTemplate.opsForValue().get("ddd");
        Object name2 = redisTemplate.opsForValue().get("xxx");
        Object name3 = redisTemplate.opsForValue().get("zzz");
        Object name4 = redisTemplate.opsForValue().get("yyy");
        System.out.println(name.toString());
        System.out.println(name2.toString());
        System.out.println(name3.toString());
        System.out.println(name4.toString());
    }

}
