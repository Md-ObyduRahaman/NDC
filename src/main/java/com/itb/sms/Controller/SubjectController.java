package com.itb.sms.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itb.sms.dto.MenuInfoDto;
import com.itb.sms.dto.SubjectDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.SubjectService;
import com.itb.sms.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "subject")
public class SubjectController {

    private final UserService userService;
    private final SubjectService subjectService;

    public SubjectController(UserService userService, SubjectService subjectService) {
        this.userService = userService;
        this.subjectService = subjectService;

    }

    @GetMapping("/list")
    public ModelAndView getSubjectList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/subject/subject");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("subjectInfo") SubjectDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        subjectService.saveOrUpdate(dto);

        modelAndView.addObject("subjects", subjectService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/subject/subject");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("subject", subjectService.getById(id));
        modelAndView.setViewName("/subject/subject_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        SubjectDto dto = subjectService.getById(id);
        dto.setDeleted("Y");

        subjectService.saveOrUpdate(dto);

        modelAndView.addObject("subjects", subjectService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/subject/subject");
        return modelAndView;
    }




}
