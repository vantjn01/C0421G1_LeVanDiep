package com.c02.controller;

import com.c02.dto.QuestionDto;
import com.c02.model.entity.Question;
import com.c02.model.service.QuestionService;
import com.c02.model.service.QuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionTypeService questionTypeService;
    @GetMapping("")
    public String contractList(@PageableDefault(value = 1) Pageable pageable, @RequestParam Optional<String> name, @RequestParam Optional<String>  questionType, Model model) {
        String searchName = "";
        String searchQuestionType = "";
        if (name.isPresent()) {
            searchName=name.get();
        }if (questionType.isPresent()) {
            searchQuestionType=questionType.get();
        }
        model.addAttribute("questionList",questionService.findAll(pageable,searchName,searchQuestionType));
        model.addAttribute("searchName",searchName);
        model.addAttribute("searchQuestionType",searchQuestionType);
        model.addAttribute("questionType",questionTypeService.finAll());

        return "list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("questionDto",new QuestionDto());
        model.addAttribute("questionType",questionTypeService.finAll());

        return "create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute QuestionDto questionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionType",questionTypeService.finAll());
            return "create";
        }else {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto,question);
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
            return "redirect:/";
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes) {
        questionService.delete(id);
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/";
    }

}
