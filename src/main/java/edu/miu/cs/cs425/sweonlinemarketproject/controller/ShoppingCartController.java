package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.ShoppingCart;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping("/shopingcart/{id}")
    public ShoppingCart loadShoppinfCartById(@PathVariable long id) {
        return shoppingCartService.getShoppingCartById(id);
    }

    @DeleteMapping("/shoppingcart/{id}")
    public void deleteShoppingCart(@PathVariable long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }

}
