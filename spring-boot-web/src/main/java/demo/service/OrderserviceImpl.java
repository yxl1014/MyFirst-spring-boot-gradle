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
    /*public int add_order(Order order){
        return jdbcTemplate.update("insert into g_order(uname, cname, time) values (?,?,?)",
                new Object[]{order.getUname(),order.getCname(),order.getTime()});
    }

    public Integer selectallorder(){
        return jdbcTemplate.queryForObject("select count(1) from g_order",Integer.class);
    }

    public int deletebyuname(String uname){
        return jdbcTemplate.update("delete from g_order where uname=?",uname);
    }*/
}
