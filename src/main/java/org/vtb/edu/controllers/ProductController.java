package org.vtb.edu.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vtb.edu.database.dto.Product;
import org.vtb.edu.database.dto.User;
import org.vtb.edu.service.ProductService;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/all")
    public String getAllProduct(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping({"/product/{id}", "/product"})
    public String showProduct(@PathVariable(required = false) Long id, Model model) {
        if (id == null) id = 0L;
        Product product = productService.getProductById(id);
        model.addAttribute("frontProduct", product);
        return "product";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("frontProduct", productService.getProductById(id));
        return "/product_edit_page";
    }

    @PostMapping("product/edit")
    public String editUser(@ModelAttribute Product product) {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/product/remove/{id}")
    public String removeUserById(@PathVariable Long id) {
        productService.removeProductById(id);
        return "redirect:/products/all";
    }
}
