package demo.service;

import demo.dao.Userdao;
import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserserviceImpl {

    @Autowired
    private Userdao userdao;

    public int insertuser(User user){
        return userdao.insertuser(user);
    }

    public Integer selectall(){
        return userdao.selectall();
    }

    public int deleteall(){
        return userdao.deleteall();
    }

    public int deletebyname(String name){
        return userdao.deletebyname(name);
    }
}
