package com.itb.sms.Controller;

import com.itb.sms.dto.FacultyDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.FacultyService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "faculty")
public class FacultyController {

    private final UserService userService;
    private final FacultyService facultyService;

    public FacultyController(UserService userService,FacultyService facultyService) {
        this.facultyService = facultyService;
        this.userService = userService ;

    }

    @GetMapping("/list")
    public ModelAndView getFacultyList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("faculties", facultyService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("faculty/faculty");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("facultyInfo") FacultyDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        facultyService.saveOrUpdate(dto);

        modelAndView.addObject("faculties", facultyService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("faculty/faculty");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("faculty", facultyService.getById(id));
        modelAndView.setViewName("faculty/faculty_view");
        return modelAndView;
    }



}
