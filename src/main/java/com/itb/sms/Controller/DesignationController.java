package com.itb.sms.Controller;

import com.itb.sms.dto.DesignationDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.DesignationService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "designation")
public class DesignationController {

    private final UserService userService;
    private final DesignationService designationService;

    public DesignationController(UserService userService, DesignationService designationService) {
        this.userService = userService;
        this.designationService = designationService;

    }

    @GetMapping("/list")
    public ModelAndView getDesignationList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("designations", designationService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/designation/designation");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("designationInfo") DesignationDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        designationService.saveOrUpdate(dto);

        modelAndView.addObject("designations", designationService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/designation/designation");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("designation", designationService.getById(id));
        modelAndView.setViewName("/designation/designation_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        DesignationDto dto = designationService.getById(id);
        dto.setDeleted("Y");

        designationService.saveOrUpdate(dto);

        modelAndView.addObject("designations", designationService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/designation/designation");
        return modelAndView;
    }


}
