package demo.service;

import demo.dao.Userdao;
import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class UserserviceImpl {

    @Autowired
    private Userdao userdao;

    public boolean insertuser(User user){
        User fuser=userdao.findbyname(user.getName());
        if(fuser==null){
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            return userdao.insertuser(user)!=0;
        }
        return false;
    }

    public User fingbyup(String username,String password){
        User user;
        user= userdao.fingbyUsernameAndPassword(username,DigestUtils.md5DigestAsHex(password.getBytes()));
        return user;
    }


    public User findByName(String name) {
        User user;
        user = userdao.findbyname(name);
        return user;
    }

    public int deleteByup(String username,String password){
        return userdao.deletebyup(username,password);
    }

    public int updateUser(User user){
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        if(deleteByup(user.getUsername(), user.getPassword())!=0){
            return userdao.insertuser(user);
        }else{
            return 0;
        }
    }

    public User findById(int id) {
        User user;
        user=userdao.fingbyId(id);
        return user;
    }
}
