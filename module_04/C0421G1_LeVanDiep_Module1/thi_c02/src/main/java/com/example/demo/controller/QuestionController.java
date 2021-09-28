package com.example.demo.controller;

import com.example.demo.dto.QuestionDto;
import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.QuestionType;
import com.example.demo.model.repository.IQuestionType;
import com.example.demo.model.service.IQuestionService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService iQuestionService;

    @Autowired
    private IQuestionType iQuestionType;

    @ModelAttribute("questionTypeList")
    public List<QuestionType> questionTypeList() {
        return iQuestionType.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "question/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute QuestionDto questionDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("questionDto", questionDto);
            return "question/create";
        } else {


            Question question = new Question();
            BeanUtils.copyProperties(questionDto,question);
            iQuestionService.save(question);
            redirectAttributes.addFlashAttribute("message", "New question created successfully");
            return "redirect:/question";
        }
    }

    /// làm tiếp đoạn này


    @GetMapping()
    public String list(@PageableDefault(value = 2) Pageable pageable,
                       @RequestParam Optional<String> questionType,
                       @RequestParam Optional<String> title, Model model) {

//        String type = "";
//        if (questionType.isPresent()) {
//            type = questionType.get();
//        }
//        String titleSearch = "";
//        if (title.isPresent()) {
//            titleSearch = title.get();
//        }
        Page<Question> questions = this.iQuestionService.findAllByTitleContainingAndQuestionType_QuestionTypeName(
        pageable, title.orElse(""), questionType.orElse(""));
        model.addAttribute("questions", questions);
        model.addAttribute("title", title.orElse(""));
       model.addAttribute("questionType", questionType.orElse(""));
        if(questions.isEmpty()){
            model.addAttribute("message", "No content");
        }
        return "question/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("question",iQuestionService.findById(id).get());
        return "question/view";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Question question = iQuestionService.findById(id).get();
       QuestionDto questionDto = new QuestionDto();

        BeanUtils.copyProperties(question,questionDto);
        model.addAttribute("questionDto", questionDto);
        return "question/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute QuestionDto questionDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            return "question/edit";
        }
        Question question = new Question();

        BeanUtils.copyProperties(questionDto,question);
        iQuestionService.save(question);
        redirectAttributes.addFlashAttribute("message", "question updated successfully");
        return "redirect:/question";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
//        Optional<Question> question = iQuestionService.findById(id);
        iQuestionService.delete(id);

        redirectAttributes.addFlashAttribute("message", "question deleted successfully");
        return "redirect:/question";
    }

}
