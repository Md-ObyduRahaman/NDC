package com.itb.sms.Controller;

import com.itb.sms.dto.MenuInfoDto;
import com.itb.sms.service.MenuService;
import com.itb.sms.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("menu")
public class MenuController {


    private final MenuService menuService;
    private final ModuleService moduleService;

    public MenuController(MenuService menuService,ModuleService moduleService) {
        this.menuService = menuService;
        this.moduleService = moduleService ;
    }

    @GetMapping("/list")
    public ModelAndView getMenuList(ModelAndView model) {

        model.addObject("modules",moduleService.getModules("Y"));
        model.addObject("menus", menuService.findAll(null));
        model.setViewName("/menu/menu");
        return model;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("menuInfo") MenuInfoDto dto) {

        ModelAndView modelAndView = new ModelAndView();

        menuService.saveOrUpdate(dto);

        modelAndView.addObject("modules",moduleService.getModules("Y"));
        modelAndView.addObject("menus", menuService.findAll(null));
        modelAndView.setViewName("/menu/menu");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("menu", menuService.getMenuById(id));
        modelAndView.setViewName("/menu/menu_view");
        return modelAndView;
    }

}
