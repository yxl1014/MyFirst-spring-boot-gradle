package demo.service.LogInterface;

import demo.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface ILogservice extends MongoRepository<Log,Integer> {

    Log findById(int id);

    ArrayList<Log> findByLogOp(String op);

    ArrayList<Log> findByLogType(String type);
}
