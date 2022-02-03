package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.model.ShoppingCart;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ProductService;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ShoppingCartService;
import edu.miu.cs.cs425.sweonlinemarketproject.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@Controller
@RequestMapping(value = "/onlinemarket/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("/{cartId}/addproduct/{productId}")
    public String addProductToCart(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId){
        Product product= productService.getProductById(productId);
        shoppingCartService.addProductToShoppingCart(cartId, product);
        return "redirect:/onlinemarket/secured/services/products/list";

    }


    @GetMapping("/{buyerId}")
    public String loadShoppingCartById(@PathVariable("buyerId") long buyerId, Model model){
        model.addAttribute("shoppingCart", shoppingCartService.getShoppingCartByBuyer(buyerId));
        model.addAttribute("currentUser", userDetailsServiceImpl.getCurrentUser());
        return "secured/services/buyer/cart/cartPage";
    }

    @GetMapping("/{cartId}/delete/{productId}")
    public String removeProductFromCart(@PathVariable("productId") Long productId, @PathVariable("cartId") Long cartId){
        shoppingCartService.deleteProductFromCart(productId, cartId);
        ShoppingCart cart= shoppingCartService.getShoppingCartById(cartId);
        String buyerId=cart.getBuyer().getUserId().toString();
        return "redirect:/onlinemarket/cart/"+buyerId;
    }


//    @DeleteMapping("/shoppingcart/{id}")
//    public String deleteShoppingCart(@PathVariable("id") long id){
//       shoppingCartService.deleteShoppingCartById(id);
//        return "redirect:/shoppingCart/list";
//    }


}
