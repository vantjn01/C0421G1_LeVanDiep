package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showShop(@CookieValue(value = "iProduct", defaultValue = "-1") Long idProduct,
                                 Model model) {
        System.err.println(idProduct);
        if (idProduct!= -1){
            model.addAttribute("historyProduct", iProductService.findById(idProduct).get());
        }
        ModelAndView modelAndView = new ModelAndView("product/shop");
        List<Product> productList = iProductService.findAll();
        modelAndView.addObject("productList", productList);
        return modelAndView;

  //      return new ModelAndView("product/shop", "productList", iProductService.findAll());
//        ModelAndView modelAndView = new ModelAndView("/shop");
//        modelAndView.addObject("products", iProductService.findAll());
//        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute CartDto cart) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cart.addProduct(productDto);

        }

        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id,
                                   HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("product/detail", "product", iProductService.findById(id).get());
    }

//    @GetMapping("/remove/{id}")
//    public String removeProduct(@PathVariable Long id, @ModelAttribute CartDto cartDto) {
//        Optional<Product> productOptional = iProductService.findById(id);
//        cartDto.removeProduct(productOptional.get());
//        return "redirect:/shopping-cart";
//    }
}
