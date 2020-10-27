package demo.service;


import demo.entity.Log;
import demo.service.LogInterface.ILogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogserciveImpl {

    @Autowired
    private ILogservice iLogservice;

    public Integer addlog(Log log){
        if(log!=null){
            iLogservice.save(log);
            return 1;
        }else{
            return 0;
        }
    }
    public ArrayList<Log> selectbyop(String op){
        return iLogservice.findByLogOp(op);
    }

    public ArrayList<Log> selectbytype(String type){
        return iLogservice.findByLogType(type);
    }

    public Log selectbyid(int id){
        return iLogservice.findById(id);
    }
}
