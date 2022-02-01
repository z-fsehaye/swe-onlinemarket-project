package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    private ProductService productService;

    // Displays

    @GetMapping("/all")
    public List<Product> displayAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    @GetMapping("/my-products/{userId}")
//    @PreAuthorize("hasRole('" + Role.SELLER + "')")
    public List<Product> getSellerProducts(@PathVariable("userId") long userId){
        return productService.getAllProductsBySellerId(userId);
    }

//    @GetMapping("/new-prodcut")
//    public String getNewProductForm(Model model){
//        model.addAttribute("product", new Product());
//        return "product/product-form";
//    }

//    @GetMapping("/update-product/{id}")
//    public String displayUpdateProductForm(Model model, @PathVariable("id") long id){
//        model.addAttribute("product", productService.getProductById(id));
//        return "product/product-form";
//    }

    // Save and Update

    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.deleteById(id);
    }


}
