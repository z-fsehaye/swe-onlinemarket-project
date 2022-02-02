package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Order;
import edu.miu.cs.cs425.sweonlinemarketproject.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value="/list")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(value="/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping(value="/save")
    public Order saveOrder(@Valid @RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }

}
