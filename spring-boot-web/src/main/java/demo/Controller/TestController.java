package demo.Controller;

import demo.entity.User;
import demo.service.UserserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import java.time.LocalTime;

@RestController
public class TestController {


    @GetMapping(value = "/hello")
    public String index(){
        return "Hello World\nNow time is:"+ LocalTime.now();
    }


}
