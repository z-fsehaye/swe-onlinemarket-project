package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    private ProductService productService;

    // Displays

    @GetMapping("/all")
    public String displayAllProducts(Model model){
        model.addAttribute("products", productService.getAllProductWhichAreNotOutOfStock());
        return "product/list";
    }

    @GetMapping("/{id}")
    public String displayProductById(Model model, @PathVariable("id") long id){
        model.addAttribute("product", productService.getProductById(id));
        return "product/product-view";
    }

    @GetMapping("/my-products/{userId}")
    public String displaySellerProducts(Model model, @PathVariable("userId") long userId){
        model.addAttribute("products", productService.getAllProductsBySellerId(userId));
        return "product/list";
    }

    @GetMapping("/new-prodcut")
    public String displayNewProductForm(Model model){
        model.addAttribute("product", new Product());
        return "product/product-form";
    }

    @GetMapping("/update-product/{id}")
    public String displayUpdateProductForm(Model model, @PathVariable("id") long id){
        model.addAttribute("product", productService.getProductById(id));
        return "product/product-form";
    }

    // Save and Update

    @PostMapping("/save-product")
    public String saveProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result){
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "product/product-form";
        }
        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        productService.deleteById(id);
        return "redirect:/product/list";
    }


}
