package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Map<Product, Integer> createProduct(){
        return new HashMap<>();
    }

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault (size = 5) Pageable pageable){
        return new ModelAndView("/product/list","productList", productService.findAllProduct(pageable));
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView view(@PathVariable Integer id){
        return new ModelAndView("/product/view", "product", productService.findById(id));
    }

    @GetMapping("/product/{id}/add")
    public String add(@ModelAttribute("cart") Map<Product, Integer> cart, @PathVariable Integer id, Model model){
        Product product = productService.findById(id);
        if (cart.containsKey(product)){
            cart.replace(product, cart.get(product), cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
        model.addAttribute("message","Product added to cart !!");
        model.addAttribute("product", product);
        return "/product/view";
    }

    @GetMapping("/cart")
    public String showList(){
        return "/cart/list";
    }

    @GetMapping("/oder/{id}/reduction")
    public String reduction(@ModelAttribute("cart") Map<Product, Integer> cart,@PathVariable Integer id, Model model){
        Product product = productService.findById(id);
//        cart.put(product, cart.get(product) - 1);
        if (cart.get(product) <= 0){
            model.addAttribute("message","Your shopping cart is empty !!");
        } else {
            // xét value củ của key thành value mới.
            cart.replace(product,cart.get(product),cart.get(product) - 1);
            product.setPrice(product.getPrice() * cart.get(product));
        }
        model.addAttribute("cart", cart);
        return "/cart/list";
    }

    @GetMapping("/oder/{id}/increase")
    public String increase(@ModelAttribute("cart") Map<Product, Integer> cart,@PathVariable Integer id, Model model){
        Product product = productService.findById(id);
        cart.replace(product, cart.get(product), cart.get(product) + 1);
        return "redirect:/cart";
    }

    @GetMapping("/oder/{id}/delete")
    public String delete(@ModelAttribute("cart") Map<Product, Integer> cart, @PathVariable Integer id, Model model){
        cart.remove(productService.findById(id));
        model.addAttribute("message", "Has deleted the product from the cart !!");
        return "/cart/list";
    }

    @GetMapping("/delete-all")
    public String deleteAll(@ModelAttribute("cart") Map<Product, Integer> cart){
        cart.clear();
        return "redirect:/cart";
    }

}
