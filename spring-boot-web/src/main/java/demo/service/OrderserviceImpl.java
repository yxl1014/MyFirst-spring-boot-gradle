package demo.service;

import demo.dao.Orderdao;
import demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderserviceImpl {

    @Autowired
    private Orderdao orderdao;

    public int add_order(Order order){
        return orderdao.add_order(order);
    }

    public Integer selectallorder(){
        return orderdao.selectallorder();
    }

    public int deletebyuname(String uname){
        return orderdao.deletebyuname(uname);
    }
}
