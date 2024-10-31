package com.itb.sms.Controller;

import com.itb.sms.dto.OtherInstituteDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.OtherInstituteService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "other_institute")
public class OtherInstituteController {

    private final UserService userService;
    private final OtherInstituteService otherInstituteService;

    public OtherInstituteController(UserService userService, OtherInstituteService otherInstituteService) {
        this.userService = userService;
        this.otherInstituteService = otherInstituteService;

    }

    @GetMapping("/list")
    public ModelAndView getOtherInstituteList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("otherInstitutes", otherInstituteService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/institute/other_institute");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("otherInstituteInfo") OtherInstituteDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        otherInstituteService.saveOrUpdate(dto);

        modelAndView.addObject("otherInstitutes", otherInstituteService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/institute/other_institute");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("otherInstitute", otherInstituteService.getById(id));
        modelAndView.setViewName("/institute/other_institute_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        OtherInstituteDto dto = otherInstituteService.getById(id);
        dto.setDeleted("Y");

        otherInstituteService.saveOrUpdate(dto);

        modelAndView.addObject("otherInstitutes", otherInstituteService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/institute/other_institute");
        return modelAndView;
    }


}
