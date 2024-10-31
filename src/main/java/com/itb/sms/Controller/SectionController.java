package com.itb.sms.Controller;

import com.itb.sms.dto.SectionDto;
import com.itb.sms.dto.YearDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.ClassService;
import com.itb.sms.service.SectionService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "section")
public class SectionController {

    private final UserService userService;
    private final SectionService sectionService;
    private final ClassService classService;

    public SectionController(UserService userService,ClassService classService,SectionService sectionService) {
        this.userService = userService;
        this.sectionService = sectionService;
        this.classService = classService ;

    }

    @GetMapping("/list")
    public ModelAndView getRoleList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("classes", classService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/section/section");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("sectionInfo") SectionDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        sectionService.saveOrUpdate(dto);
        modelAndView.addObject("classes", classService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/section/section");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("section", sectionService.getById(id));
        modelAndView.setViewName("/section/section_view");
        return modelAndView;
    }


    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        SectionDto dto = sectionService.getById(id);
        dto.setDeleted("Y");

        sectionService.saveOrUpdate(dto);
        modelAndView.addObject("classes", classService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/section/section");
        return modelAndView;
    }



}
