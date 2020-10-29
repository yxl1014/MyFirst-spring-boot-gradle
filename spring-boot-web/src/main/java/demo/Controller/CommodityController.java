package demo.Controller;

import demo.annotation.LogRecord;
import demo.entity.Commodity;
import demo.service.CommodityServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @PostMapping(value = "add_commodity")
    @CacheEvict(cacheNames = "commotidy", key = "all")
    @LogRecord(operation = "商品操作",type = "添加商品")
    public String add_commodity(@Param(value = "commodity")Commodity commodity){
        if(commodityService.AddCommodity(commodity)!=0){
            return "ADD OK!";
        }else{
            return "ADD ERROR!";
        }
    }

    @GetMapping(value = "select_commodity_all")
    @Cacheable(cacheNames = "commotidy", key = "all")
    @LogRecord(operation = "商品操作",type = "查询商品")
    public String select_all(){
        int all=commodityService.SelectAll();
        return "all is"+all;
    }

    @GetMapping(value = "select_commodity_cname")
    @Cacheable(cacheNames = "commodity", key = "#cname")
    @LogRecord(operation = "商品操作",type = "商品名查询商品")
    public String selectbycname(@Param(value = "cname")String cname){
        Commodity commodity=commodityService.SelectByCname(cname);
        return commodity.getId()+"  "+commodity.getCname()+"  "+commodity.getCategory()+"  "+commodity.getPrice();
    }

    @GetMapping(value = "select_commodity_id")
    @Cacheable(cacheNames = "commodity", key = "#id")
    @LogRecord(operation = "商品操作",type = "商品号查询商品")
    public String selectbycid(@Param(value = "id")int id){
        Commodity commodity=commodityService.SelectById(id);
        return commodity.getId()+"  "+commodity.getCname()+"  "+commodity.getCategory()+"  "+commodity.getPrice();
    }

    @GetMapping(value = "delete_commodity_cname")
    @LogRecord(operation = "商品操作",type = "商品名删除商品")
    public String deletebycname(@Param(value = "cname")String cname){
        int all=commodityService.DeleteByCname(cname);
        return cname+"have delete all order is"+all;
    }
}
