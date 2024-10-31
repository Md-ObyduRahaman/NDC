package com.itb.sms.Controller;

import com.itb.sms.dto.BranchDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.BranchService;
import com.itb.sms.service.CityService;
import com.itb.sms.service.PostService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "branch")
public class BranchController {

    private final UserService userService;
    private final BranchService branchService;
    private final CityService cityService;
    private final PostService postService;

    public BranchController(UserService userService, BranchService branchService, CityService cityService, PostService postService) {
        this.branchService = branchService;
        this.userService = userService;
        this.cityService = cityService;
        this.postService = postService;

    }

    @GetMapping("/list")
    public ModelAndView getBranchList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("cities", cityService.findAll("Y", "N"));
        modelAndView.addObject("posts", postService.findAll("Y", "N"));
        modelAndView.addObject("branches", branchService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/branch/branch");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("branchInfo") BranchDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        branchService.saveOrUpdate(dto);

        modelAndView.addObject("cities", cityService.findAll("Y", "N"));
        modelAndView.addObject("posts", postService.findAll("Y", "N"));
        modelAndView.addObject("branches", branchService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/branch/branch");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("branch", branchService.getById(id));
        modelAndView.setViewName("/branch/branch_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        BranchDto dto = branchService.getById(id);
        dto.setDeleted("Y");

        branchService.saveOrUpdate(dto);

        modelAndView.addObject("cities", cityService.findAll("Y", "N"));
        modelAndView.addObject("posts", postService.findAll("Y", "N"));
        modelAndView.addObject("branches", branchService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/branch/branch");
        return modelAndView;
    }


}
