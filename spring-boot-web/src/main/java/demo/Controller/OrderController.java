package demo.Controller;

import demo.service.OrderserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderserviceImpl orderservice;
}
