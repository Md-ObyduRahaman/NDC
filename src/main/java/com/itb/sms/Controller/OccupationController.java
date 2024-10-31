package com.itb.sms.Controller;

import com.itb.sms.dto.OccupationDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.OccupationService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "occupation")
public class OccupationController {

    private final UserService userService;
    private final OccupationService occupationService;

    public OccupationController(UserService userService, OccupationService occupationService) {
        this.userService = userService;
        this.occupationService = occupationService;

    }

    @GetMapping("/list")
    public ModelAndView getOccupationList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("occupations", occupationService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/occupation/occupation");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("occupationInfo") OccupationDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        occupationService.saveOrUpdate(dto);

        modelAndView.addObject("occupations", occupationService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/occupation/occupation");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("occupation", occupationService.getById(id));
        modelAndView.setViewName("/occupation/occupation_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        OccupationDto dto = occupationService.getById(id);
        dto.setDeleted("Y");

        occupationService.saveOrUpdate(dto);

        modelAndView.addObject("occupations", occupationService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/occupation/occupation");
        return modelAndView;
    }


}
