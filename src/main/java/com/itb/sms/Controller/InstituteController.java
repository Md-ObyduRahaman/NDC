package com.itb.sms.Controller;

import com.itb.sms.dto.InstituteDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.CountryService;
import com.itb.sms.service.InstituteService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequestMapping("institute")
public class InstituteController {

    private final InstituteService instituteService;
    private final CountryService  countryService;
    private final UserService userService;

    public InstituteController(UserService userService,InstituteService instituteService,CountryService  countryService) {
        this.userService = userService ;
        this.instituteService = instituteService;
        this.countryService = countryService ;
    }

    @GetMapping("/list")
    public ModelAndView getInstituteList(ModelAndView model) {
        model.addObject("countries", countryService.findAll());
        UserInfo userInfo = userService.getCurrentUser();
        if(userInfo.getRoleInfo().getSuperAdminStatus().equals("")){
            model.addObject("institutes", instituteService.findAll());
            model.setViewName("/institute/institute");
        }else{
            model.addObject("institutes", instituteService.findAll()
                    .stream().filter(info ->info.getId().equals(userInfo.getInstituteId()))
                    .collect(Collectors.toList()));
            model.setViewName("/institute/institute_own");
        }


        return model;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView addOrUpdate(@ModelAttribute("instituteInfo") InstituteDto dto) {

        ModelAndView modelAndView = new ModelAndView();

        instituteService.saveOrUpdate(dto);
        modelAndView.addObject("countries", countryService.findAll());
        modelAndView.addObject("institutes", instituteService.findAll());
        modelAndView.setViewName("/institute/institute");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("institute", instituteService.getById(id));
        modelAndView.setViewName("/institute/institute_view");
        return modelAndView;
    }



}
