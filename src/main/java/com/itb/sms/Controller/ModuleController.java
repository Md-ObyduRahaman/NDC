package com.itb.sms.Controller;

import com.itb.sms.dto.ModuleInfoDto;
import com.itb.sms.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "module")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @GetMapping("/list")
    public ModelAndView getModuleList(ModelAndView model) {
        model.addObject("modules", moduleService.getModules(null));
        model.setViewName("/module/module");
        return model;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("moduleInfo") ModuleInfoDto dto) {

        ModelAndView modelAndView = new ModelAndView();

        moduleService.saveOrUpdate(dto);

        modelAndView.addObject("modules", moduleService.getModules(null));
        modelAndView.setViewName("/module/module");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("module", moduleService.getModuleById(id));
        modelAndView.setViewName("/module/module_view");
        return modelAndView;
    }

}
