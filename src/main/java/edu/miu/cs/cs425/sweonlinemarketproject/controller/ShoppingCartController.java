package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.ShoppingCart;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping("/shopingCart/{id}")
    public String loadShoppinfCartById(@PathVariable("id") long id, Model model){
        model.addAttribute("shoppingCarts", shoppingCartService.getShoppingCartById(id));
        return "shoppingCart/shoppingCart-view";
    }

    @DeleteMapping("/shoppingcart/{id}")
    public String deleteShoppingCart(@PathVariable("id") long id){
       shoppingCartService.deleteShoppingCartById(id);
        return "redirect:/shoppingCart/list";
    }

}
