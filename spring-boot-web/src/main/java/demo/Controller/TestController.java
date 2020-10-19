package demo.Controller;

import demo.service.UserserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserserviceImpl userservice;

    @GetMapping(value = "/hello")
    public String index(){
        return "Hello World";
    }

  /*  @PostMapping(value = "add_user")
    public String add_user(){
        userservice.insertuser();
    }*/
}
