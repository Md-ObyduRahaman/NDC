package com.itb.sms.Controller;

import com.itb.sms.dto.MajorDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.MajorService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "major")
public class MajorController {

    private final UserService userService;
    private final MajorService majorService;

    public MajorController(UserService userService, MajorService majorService) {
        this.userService = userService;
        this.majorService = majorService;

    }

    @GetMapping("/list")
    public ModelAndView getMajorList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("majors", majorService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/major/major");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("majorInfo") MajorDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        majorService.saveOrUpdate(dto);

        modelAndView.addObject("majors", majorService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/major/major");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("major", majorService.getById(id));
        modelAndView.setViewName("/major/major_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        MajorDto dto = majorService.getById(id);
        dto.setDeleted("Y");

        majorService.saveOrUpdate(dto);

        modelAndView.addObject("majors", majorService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/major/major");
        return modelAndView;
    }


}
