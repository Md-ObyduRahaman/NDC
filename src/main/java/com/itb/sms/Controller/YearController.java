package com.itb.sms.Controller;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.dto.YearDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import com.itb.sms.service.YearService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "year")
public class YearController {

    private final UserService userService;
    private final YearService yearService;

    public YearController(YearService yearService,UserService userService) {
        this.yearService = yearService;
        this.userService = userService ;

    }

    @GetMapping("/list")
    public ModelAndView getRoleList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("years", yearService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/year/year");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("yearInfo") YearDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        yearService.saveOrUpdate(dto);

        modelAndView.addObject("years", yearService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/year/year");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("year", yearService.getById(id));
        modelAndView.setViewName("/year/year_view");
        return modelAndView;
    }


    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        YearDto dto = yearService.getById(id);
        dto.setDeleted("Y");

        yearService.saveOrUpdate(dto);

        modelAndView.addObject("years", yearService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/year/year");
        return modelAndView;
    }



}
