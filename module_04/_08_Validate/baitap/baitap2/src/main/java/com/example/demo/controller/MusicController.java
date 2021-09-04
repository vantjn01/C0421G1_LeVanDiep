package com.example.demo.controller;

import com.example.demo.dto.MusicDto;
import com.example.demo.model.entity.Music;
import com.example.demo.model.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songObject",new MusicDto());
        return modelAndView;
    }
//    public String showCreatePage(Model model) {
//    MusicDto musicDto = new MusicDto();
//    model.addAttribute("musicDto", musicDto);
//    return "create";
//
//    }

    @PostMapping("create")
    public String createMusic(@Valid @ModelAttribute(name = "songObject") MusicDto musicDto,
                              BindingResult bindingResult, Model model){
//        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<Music> music = this.musicService.findAll();
        model.addAttribute("musicList", music);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable(name = "id") int id, Model model){
        Music music = this.musicService.findById(id);
        if (music == null){
            return "redirect:/list";
        }
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicObject", music);
        return "edit";
    }

    @PostMapping("/update")
    public String updateMusic(@Valid @ModelAttribute(name = "musicObject") MusicDto musicObject,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicObject, music);
        this.musicService.save(music);
        redirectAttributes.addFlashAttribute("msg","Update done");
        return "redirect:/list";
    }

}
