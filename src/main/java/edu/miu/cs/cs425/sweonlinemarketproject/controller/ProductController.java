package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    private ProductService productService;

    // Displays

    @GetMapping("/all")
    public String displayAllProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }

    @GetMapping("/{id}")
    public String displayProductById(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product/product-view";
    }

    @GetMapping("/my-products/{userId}")
//    @PreAuthorize("hasRole('" + Role.SELLER + "')")
    public String diplaySellerProducts(@PathVariable("userId") long userId, Model model){
        model.addAttribute("products", productService.getAllProductsBySellerId(userId));
        return "product/product-view";
    }

    @GetMapping("/new-product")
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
        if (result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "product/product-form";
        }
        productService.saveProduct(product);
        return "redirect:/product/all";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        productService.deleteById(id);
        return "redirect:/product/all";
    }
    @GetMapping(value = "/search")
    public ModelAndView searchBooks(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products= productService.searchProducts(searchString);
        modelAndView.addObject("products", products);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentCount", products.size());
        modelAndView.setViewName("product/list");
        return modelAndView;
    }


}
