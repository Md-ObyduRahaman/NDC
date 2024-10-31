package com.itb.sms.Controller;

import com.itb.sms.dto.ClassTypeDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.ClassTypeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "class_type")
public class ClassTypeController {
    
    private final UserService userService;
    private final ClassTypeService classTypeService;

    public ClassTypeController(UserService userService,ClassTypeService classTypeService) {
        this.userService = userService;
        this.classTypeService = classTypeService;

    }

    @GetMapping("/list")
    public ModelAndView getClassTypeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("classTypes", classTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/class/class_type");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("classTypeInfo") ClassTypeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        classTypeService.saveOrUpdate(dto);

        modelAndView.addObject("classTypes", classTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/class/class_type");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("classType", classTypeService.getById(id));
        modelAndView.setViewName("/class/class_type_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        ClassTypeDto dto=classTypeService.getById(id);
        dto.setDeleted("Y");

        classTypeService.saveOrUpdate(dto);

        modelAndView.addObject("classTypes", classTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/class/class_type");
        return modelAndView;
    }



}
