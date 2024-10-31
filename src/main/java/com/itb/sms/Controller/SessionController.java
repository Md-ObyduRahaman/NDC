package com.itb.sms.Controller;

import com.itb.sms.dto.SessionDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "session")
public class SessionController {

    private final UserService userService;
    private final ClassService classService;
    private final YearService yearService;
    private final FacultyService  facultyService;
    private final SessionService sessionService;


    public SessionController(UserService userService,ClassService classService,YearService yearService,FacultyService  facultyService,SessionService sessionService) {
        this.userService = userService;
        this.classService = classService ;
        this.yearService = yearService ;
        this.facultyService = facultyService;
        this.sessionService = sessionService ;

    }

    @GetMapping("/list")
    public ModelAndView getRoleList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("classes", classService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("years", yearService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("faculties", facultyService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("sessionList", sessionService.findAll(userInfo,"Y","N"));
        modelAndView.setViewName("/session/session");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("sessionInfo") SessionDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        sessionService.saveOrUpdate(dto);
        modelAndView.addObject("classes", classService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("years", yearService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("faculties", facultyService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("sessionList", sessionService.findAll(userInfo,"Y","N"));
        modelAndView.setViewName("/session/session");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("sessionInfo", sessionService.getById(id));
        modelAndView.setViewName("/session/session_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        SessionDto dto= sessionService.getById(id);
        dto.setDeleted("Y");

        sessionService.saveOrUpdate(dto);

        modelAndView.addObject("classes", classService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("years", yearService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("faculties", facultyService.findAll(userInfo,"Y","N"));
        modelAndView.addObject("sessionList", sessionService.findAll(userInfo,"Y","N"));
        modelAndView.setViewName("/session/session");
        return modelAndView;
    }



}
