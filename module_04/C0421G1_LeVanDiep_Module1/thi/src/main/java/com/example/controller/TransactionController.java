package com.example.controller;

import com.example.dto.TransactionDto;
import com.example.model.entity.transaction.Customer;
import com.example.model.entity.transaction.Transaction;
import com.example.model.service.ITransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/transactions"})
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @ModelAttribute("customerNames")
    public List<Customer> customerList() {
        return transactionService.findAllCustomer();
    }


    @GetMapping(value = "/create")
    public String createCustomer(Model model) {
        model.addAttribute("transactionDto", new TransactionDto());
        return "/transaction/create";
    }

    @PostMapping(value = "/save")
    public String saveTransaction(
//            @RequestParam("img") Optional<String> imgFile,
                                  @Valid @ModelAttribute TransactionDto transactionDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {

        Optional<Transaction> transactions = transactionService.findByTransactionCode(transactionDto.getTransactionCode());
        if(transactions.isPresent()){
            model.addAttribute("lost", "Mã khách hàng đã tồn tại");
            return "/transaction/create";
        }

        new TransactionDto().validate(transactionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/transaction/create";
        }

//        String img = "https://www.f-cdn.com/assets/main/en/assets/unknown.png";
//        if(imgFile.isPresent()){
//            img = imgFile.get();
//        }
//
//        transactionDto.setImg(img);

        Transaction transaction = new Transaction();
//      copy dữ liệu từ dto sang đối tượng entity tương ứng
        BeanUtils.copyProperties(transactionDto, transaction);
        this.transactionService.save(transaction);
        redirectAttributes.addFlashAttribute("success", "Create transaction success  fully");
        return "redirect:/transactions";
    }

    @GetMapping(value = "")
    public String showListTransaction(Model model,
                                      @PageableDefault(size = 4) Pageable pageable,
                                      @RequestParam Optional<String> rentTrading,
                                      @RequestParam Optional<String> customerName
                                     ) {
        String keywordRent = "";
        String keywordCustomerName = "";

        if (rentTrading.isPresent()) {
            //nếu có giá trị copy vào  biến
            keywordRent = rentTrading.get();
        }
        if (customerName.isPresent()) {
            keywordCustomerName = customerName.get();
        }

        Page<Transaction> transactions = transactionService.search(pageable, keywordCustomerName, keywordRent);
        model.addAttribute("transactions", transactions);
        model.addAttribute("keywordRent", keywordRent);
        model.addAttribute("keywordCustomerName", keywordCustomerName);
        return "/transaction/list";
    }

    @GetMapping(value = "delete")
    public String deletesTransaction(@RequestParam Optional<List<Long>> listId, RedirectAttributes redirectAttributes) {
        if (listId.isPresent()) {
            for (Long id : listId.get()) {
                Optional<Transaction> transaction = transactionService.findById(id);
                if (!transaction.isPresent()) {
                redirectAttributes.addFlashAttribute("lost", "Can not remove!");
                return "redirect:/transactions";
                }
                transactionService.remove(id);
            }
        }
        redirectAttributes.addFlashAttribute("success", "Removed successfully!");
        return "redirect:/transactions";
    }

    @PostMapping(value = "remove")
    public String deleteTransaction(@RequestParam Long id, RedirectAttributes redirectAttributes) {

        Optional<Transaction> transaction = transactionService.findById(id);
        if (!transaction.isPresent()) {
            redirectAttributes.addFlashAttribute("lost", "Can not remove!");
            return "redirect:/transactions";
        }
        transactionService.remove(id);

        redirectAttributes.addFlashAttribute("success", "Removed transaction successfully!");
        return "redirect:/transactions";
    }

    @GetMapping("/detail")
    public String showDetailForm(@RequestParam Long id, Model model) {
        Optional<Transaction> transaction = transactionService.findById(id);
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction.get(), transactionDto);
        model.addAttribute("transactionDto", transactionDto);
        return "/transaction/detail";
    }

    @GetMapping(value = "/edit")
    public String showEditCustomer(@RequestParam Long id, Model model) {
        Optional<Transaction> transaction = transactionService.findById(id);
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction.get(), transactionDto);
        model.addAttribute("transactionDto", transactionDto);
        return "/transaction/edit";
    }

    @PostMapping(value = "/edit")
    public String editTransaction(@Valid @ModelAttribute TransactionDto transactionDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        new TransactionDto().validate(transactionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/transaction/edit";
        }

        Transaction transaction = new Transaction();
//     copy dữ liệu từ dto sang đối tượng entity tương ứng
        BeanUtils.copyProperties(transactionDto, transaction);
        this.transactionService.save(transaction);
        redirectAttributes.addFlashAttribute("success", "Create transaction success  fully");
        return "redirect:/transactions";
    }
}