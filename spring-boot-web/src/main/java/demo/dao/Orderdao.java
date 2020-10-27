package demo.dao;

import demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class Orderdao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add_order(Order order){
        return jdbcTemplate.update("insert into g_order(uname, cname, time) values (?,?,?)",
                new Object[]{order.getUname(),order.getCname(),order.getTime()});
    }

    public Integer selectallorder(){
        return jdbcTemplate.queryForObject("select count(1) from g_order",Integer.class);
    }

    public int deletebyuname(String uname){
        return jdbcTemplate.update("delete from g_order where uname=?",uname);
    }
}
