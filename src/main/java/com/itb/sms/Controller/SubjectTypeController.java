package com.itb.sms.Controller;

import com.itb.sms.dto.SubjectTypeDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.SubjectTypeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "subject_type")
public class SubjectTypeController {

    private final UserService userService;
    private final SubjectTypeService subjectTypeService;

    public SubjectTypeController(UserService userService,SubjectTypeService subjectTypeService) {
        this.userService = userService ;
        this.subjectTypeService = subjectTypeService;

    }

    @GetMapping("/list")
    public ModelAndView getSubjectTypeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("subjectTypes", subjectTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/subject/subject_type");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("subjectTypeInfo") SubjectTypeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        subjectTypeService.saveOrUpdate(dto);


        modelAndView.addObject("subjectTypes", subjectTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/subject/subject_type");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("subjectType", subjectTypeService.getById(id));
        modelAndView.setViewName("/subject/subject_type_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();

        ModelAndView modelAndView = new ModelAndView();
        SubjectTypeDto dto=subjectTypeService.getById(id);
        dto.setDeleted("Y");

        subjectTypeService.saveOrUpdate(dto);

        modelAndView.addObject("subjectTypes", subjectTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/subject/subject_type");
        return modelAndView;
    }



}
