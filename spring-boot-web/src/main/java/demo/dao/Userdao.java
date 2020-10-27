package demo.dao;

import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Userdao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertuser(User user){
        return jdbcTemplate.update("insert into g_user(name, username, password,sax, weight, height) values (?,?,?,?,?,?)",
                new Object[]{user.getName(),user.getUsername(),user.getPassword(),user.getGender(),user.getWeight(),user.getHeight()});
    }

    public Integer selectall(){
        return jdbcTemplate.queryForObject("select count(1) from g_user", Integer.class);
    }

    public int deleteall(){
        return jdbcTemplate.update("delete from g_user");
    }

    public int deletebyup(String username,String password){
        return jdbcTemplate.update("delete from g_user where username=?and password =?",username,password);
    }

    public User fingbyUsernameAndPassword(String username,String password){
        User user;
        user=jdbcTemplate.queryForObject("select id,name,username,password,sax,weight,height from g_user where username=? and password =?",
                User.class,
                username,
                password);
        return user;
    }

    public User findbyname(String name) {
        User user;
        user = jdbcTemplate.queryForObject("select id,name,username,password,sax,weight,height from g_user where name=?", User.class,name);
        return user;
    }

    public User fingbyId(int id) {
        User user;
        user = jdbcTemplate.queryForObject("select id,name,username,password,sax,weight,height from g_user where id=?", User.class,id);
        return user;
    }
}
