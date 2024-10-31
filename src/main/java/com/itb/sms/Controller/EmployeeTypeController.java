package com.itb.sms.Controller;

import com.itb.sms.dto.EmployeeTypeDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.EmployeeTypeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "employee_type")
public class EmployeeTypeController {

    private final UserService userService;
    private final EmployeeTypeService employeeTypeService;

    public EmployeeTypeController(UserService userService, EmployeeTypeService employeeTypeService) {
        this.userService = userService;
        this.employeeTypeService = employeeTypeService;

    }

    @GetMapping("/list")
    public ModelAndView getTypeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("employeeTypes", employeeTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/employee/employee_type");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("employeeTypeInfo") EmployeeTypeDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        employeeTypeService.saveOrUpdate(dto);


        modelAndView.addObject("employeeTypes", employeeTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/employee/employee_type");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empType", employeeTypeService.getById(id));
        modelAndView.setViewName("/employee/employee_type_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        EmployeeTypeDto dto = employeeTypeService.getById(id);
        dto.setDeleted("Y");

        employeeTypeService.saveOrUpdate(dto);


        modelAndView.addObject("employeeTypes", employeeTypeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/employee/employee_type");
        return modelAndView;
    }


}
