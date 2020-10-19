package demo;

import demo.entity.User;
import demo.service.UserserviceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserserviceImpl userservice;

    @Resource
    private RedisTemplate<String, User> redisTemplate;


    @Before
    public void load() {
        userservice.deleteall();
    }

    @Test
    public void test(){
        userservice.insertuser(new User(1,"y","yxl","123456"));
        userservice.insertuser(new User(2,"a","aaa","234567"));
        userservice.insertuser(new User(3,"b","bbb","345678"));
        userservice.insertuser(new User(4,"c","ccc","456789"));
        userservice.insertuser(new User(5,"d","ddd","147258"));

        Assert.assertEquals(5,userservice.selectall().intValue());

        userservice.deletebyname("a");
        userservice.deletebyname("c");

        Assert.assertEquals(3,userservice.selectall().intValue());
    }

    @Test
    public void testredis(){

        // 保存字符串
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象
        User user = new User(1, "aaa", true);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User(2, "bbb", true);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User(3, "ccc", false);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(1, redisTemplate.opsForValue().get("aaa").getId());
        Assert.assertEquals(2, redisTemplate.opsForValue().get("bbb").getId());
        Assert.assertEquals(3, redisTemplate.opsForValue().get("ccc").getId());
    }

}
