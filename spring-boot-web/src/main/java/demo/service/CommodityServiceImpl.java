package demo.service;

import demo.dao.Commoditydao;
import demo.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl {

    @Autowired
    private Commoditydao commoditydao;

    public int AddCommodity(Commodity commodity){
        Commodity commodity1=commoditydao.selectbycname(commodity.getCname());
        if(commodity1==null||commodity.getCname()==null||!commodity.getCategory().equals(commodity.getCategory())) {
            return commoditydao.add_commodity(commodity);
        }else{
            return 0;
        }
    }

    public Integer SelectAll(){
        return commoditydao.selectallcommotidy();
    }

    public int DeleteByCname(String cname){
        return commoditydao.deletebycname(cname);
    }

    public Commodity SelectByCname(String cname){
        return commoditydao.selectbycname(cname);
    }

    public Commodity SelectById(int id){
        return commoditydao.selectbycid(id);
    }
}
