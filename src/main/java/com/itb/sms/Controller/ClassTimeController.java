package com.itb.sms.Controller;

import com.itb.sms.dto.ClassTimeDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.ClassTimeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "class_time")
public class ClassTimeController {
    
    private final UserService userService;
    private final ClassTimeService classTimeService;

    public ClassTimeController(UserService userService, ClassTimeService classTimeService) {
        this.userService = userService;
        this.classTimeService = classTimeService;

    }

    @GetMapping("/list")
    public ModelAndView getClassTimeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("classTimes", classTimeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/class/class_time");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("classTimeInfo") ClassTimeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        classTimeService.saveOrUpdate(dto);

        modelAndView.addObject("classTimes", classTimeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/class/class_time");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("classTime", classTimeService.getById(id));
        modelAndView.setViewName("/class/class_time_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        ClassTimeDto dto=classTimeService.getById(id);
        dto.setDeleted("Y");

        classTimeService.saveOrUpdate(dto);

        modelAndView.addObject("classTimes", classTimeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/class/class_time");
        return modelAndView;
    }



}
