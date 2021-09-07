package com.example.demo.controller;

import com.example.demo.model.bean.Book;
import com.example.demo.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping(value = "/books")
    public String listBook(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "list";
    }
    @GetMapping("/detail/{id}")
    public String detailBook(@PathVariable Integer id, Model model) throws BookException {
        Book book = bookService.findById(id);
        if (book.getAmount() == 0) {
            throw new BookException();
        } else {
            model.addAttribute("book", book);
            return "/detail";
        }
    }

    @PostMapping("/detail")
    public String updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setAmount(book.getAmount() - 1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "muon sach thanh cong!");
        return "redirect:/books";
    }
    @GetMapping("/pay")
    public String showForm() {
        return "/pay";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        book.setAmount(book.getAmount() + 1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "tra sach thanh cong!");
        return "redirect:/books";
    }
    @ExceptionHandler(BookException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/error-end-book");
    }
}
