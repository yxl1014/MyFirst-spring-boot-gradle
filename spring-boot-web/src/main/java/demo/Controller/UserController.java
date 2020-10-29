package demo.Controller;

import demo.annotation.LogRecord;
import demo.entity.User;
import demo.service.UserserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserserviceImpl userservice;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping(value = "add_user")
    @LogRecord(operation = "用户操作", type = "添加用户")
    public String add_user(@RequestBody User user){
        if(userservice.insertuser(user)){
            return "Welcome "+user.getName();
        }else{
            return "ERROR";
        }
    }

    @PostMapping(value = "login")
    @LogRecord(operation = "用户操作", type = "登陆")
    public String login(@RequestParam(name = "username")String username,@RequestParam(name = "password")String password){
        User user=userservice.fingbyup(username,password);
        if(user!=null){
            return "Hello "+user.getName();
        }else{
            return "login error!";
        }
    }

    @GetMapping(value = "find_name")
    @Cacheable(cacheNames = "user", key = "#name")
    @LogRecord(operation = "用户操作", type = "通过用户名查用户")
    public String findByName(@RequestParam(name = "name")String name){
        User user= userservice.findByName(name);
        if(user!=null){
            return "Id : "+user.getId()+
                    "Name : "+user.getName()+
                    "gender : "+user.getGender();
        }else {
            return "Not find";
        }
    }
    @GetMapping(value = "update")
    @LogRecord(operation = "用户操作", type = "更新用户")
    public String updateUser(@RequestParam User user){
        if(userservice.updateUser(user)!=0){
            return "Update OK!";
        }else{
            return "Update ERROR!";
        }
    }
}
