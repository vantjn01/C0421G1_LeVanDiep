package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.ProductRepository;
import com.example.demo.model.repository.ProductTypeRepository;
import com.example.demo.model.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @ModelAttribute("productList")
    public List<Product> productList() {
        return productRepository.findAll();
    }



    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("order/list");
        modelAndView.addObject("orderList", orderService.findAll(pageable));
        modelAndView.addObject("orderTypeList", orderService.findAll(pageable));
        return modelAndView;
    }


    @PostMapping("/save")
    public String saveOrder(@ModelAttribute @Validated OrderDto orderDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {

//        if (bindingResult.hasFieldErrors()) {
//            reloadData(model);
//            return "customer/create";
//        } else {

            Order newOrder = new Order();
            BeanUtils.copyProperties(orderDto, newOrder);

            orderService.save(newOrder);
            attributes.addFlashAttribute("message", "New order created successfully");
            return "redirect:/order/list";

    }
//    @GetMapping("/view/{id}")
//    public String view(@PathVariable Long id, Model model) {
//        model.addAttribute("question",iQuestionService.findById(id).get());
//        return "question/view";
//    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Order order = orderService.findById(id).get();
        OrderDto orderDto = new OrderDto();

        BeanUtils.copyProperties(order,orderDto);
        model.addAttribute("orderDto", orderDto);
        return "order/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute OrderDto orderDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            return "order/edit";
        }

        Order order = new Order();

        BeanUtils.copyProperties(orderDto,order);
        orderService.save(order);
        redirectAttributes.addFlashAttribute("message", "order updated successfully");
        return "redirect:/order";
    }


}
