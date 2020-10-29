package demo.Controller;

import demo.annotation.LogRecord;
import demo.entity.Order;
import demo.entity.User;
import demo.service.OrderserviceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class OrderController {

    @Autowired
    private OrderserviceImpl orderservice;

    @GetMapping(value = "add_order")
    @CacheEvict(cacheNames = "order", key = "all")
    @LogRecord(operation = "订单操作",type = "添加订单")
    public String add_Order(@Param(value = "uname")String uname,@Param(value = "cname")String cname){
        Order order=new Order();
        order.setUname(uname);
        order.setCname(cname);
        order.setTime(LocalTime.now().toString());
        if(orderservice.add_order(order)==1){
            return "ADD OK!";
        }else{
            return "ADD ERROR!";
        }
    }

    @GetMapping(value = "select_order_all")
    @Cacheable(cacheNames = "order", key = "all")
    @LogRecord(operation = "订单操作",type = "查询订单")
    public String select_all(){
        int all=orderservice.selectallorder();
        return "all is"+all;
    }

    @GetMapping(value = "delete_order_uname")
    @LogRecord(operation = "订单操作",type = "用户名删除订单")
    public String deletebyuname(@Param(value = "uname")String uname){
        int all=orderservice.deletebyuname(uname);
        return uname+"have delete all order is"+all;
    }
}
