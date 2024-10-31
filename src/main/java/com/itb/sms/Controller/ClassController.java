package com.itb.sms.Controller;

import com.itb.sms.dto.BranchDto;
import com.itb.sms.dto.ClassDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.ClassService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "class")
public class ClassController {

    private final UserService userService;
    private final ClassService classService;

    public ClassController(UserService userService,ClassService classService) {
        this.classService = classService;
        this.userService = userService ;

    }

    @GetMapping("/list")
    public ModelAndView getClassList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("classes", classService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/class/class");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("classInfo") ClassDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        classService.saveOrUpdate(dto);

        modelAndView.addObject("classes", classService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/class/class");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("class", classService.getById(id));
        modelAndView.setViewName("/class/class_view");
        return modelAndView;
    }


    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        ClassDto dto = classService.getById(id);
        dto.setDeleted("Y");

        classService.saveOrUpdate(dto);

        modelAndView.addObject("classes", classService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/class/class");
        return modelAndView;
    }



}
