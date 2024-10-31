package com.itb.sms.Controller;

import com.itb.sms.dto.BuildingDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.BuildingService;
import com.itb.sms.service.CityService;
import com.itb.sms.service.PostService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "building")
public class BuildingController {

    private final UserService userService;
    private final BuildingService buildingService;
    private final CityService cityService;
    private final PostService postService;

    public BuildingController(UserService userService, BuildingService buildingService,CityService cityService,PostService postService) {
        this.buildingService = buildingService;
        this.userService = userService ;
        this.cityService = cityService ;
        this.postService = postService ;

    }

    @GetMapping("/list")
    public ModelAndView getBuildingList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("cities", cityService.findAll("Y","N"));
        modelAndView.addObject("posts", postService.findAll("Y","N"));
        modelAndView.addObject("buildings", buildingService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/building/building");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("buildingInfo") BuildingDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        buildingService.saveOrUpdate(dto);

        modelAndView.addObject("cities", cityService.findAll("Y","N"));
        modelAndView.addObject("posts", postService.findAll("Y","N"));
        modelAndView.addObject("buildings", buildingService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/building/building");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("building", buildingService.getById(id));
        modelAndView.setViewName("/building/building_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        BuildingDto dto=buildingService.getById(id);
        dto.setDeleted("Y");

        buildingService.saveOrUpdate(dto);

        modelAndView.addObject("cities", cityService.findAll("Y","N"));
        modelAndView.addObject("posts", postService.findAll("Y","N"));
        modelAndView.addObject("buildings", buildingService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/building/building");
        return modelAndView;
    }



}
