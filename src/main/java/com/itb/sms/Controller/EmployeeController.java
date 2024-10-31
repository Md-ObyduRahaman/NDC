package com.itb.sms.Controller;


import com.itb.sms.dto.EmployeeDto;
import com.itb.sms.dto.RoomDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.*;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private final UserService userService;
    private final DesignationService designationService;
    private final ReligionService religionService;
    private final EmployeeTypeService employeeTypeService;
    private final EmployeeService employeeService;

    public EmployeeController(UserService userService,DesignationService designationService,
                              ReligionService religionService,EmployeeTypeService employeeTypeService,
                              EmployeeService employeeService) {
        this.userService = userService;
        this.designationService = designationService;
        this.religionService = religionService ;
        this.employeeTypeService = employeeTypeService;
        this.employeeService = employeeService ;

    }

    @GetMapping("/list")
    public ModelAndView getEmployeeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("designations", designationService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("religions", religionService.findAll( "Y", "N"));
        modelAndView.addObject("types", employeeTypeService.findAll( userInfo,"Y", "N"));
        modelAndView.addObject("employees", employeeService.findAll( userInfo,"Y", "N"));
        modelAndView.setViewName("/employee/employee");
        return modelAndView;
    }

    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("employeeInfo") EmployeeDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        employeeService.saveOrUpdate(dto);

        modelAndView.addObject("designations", designationService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("religions", religionService.findAll( "Y", "N"));
        modelAndView.addObject("types", employeeTypeService.findAll( userInfo,"Y", "N"));
        modelAndView.addObject("employees", employeeService.findAll( userInfo,"Y", "N"));
        modelAndView.setViewName("/employee/employee");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("employee", employeeService.getById(id));
        modelAndView.setViewName("/employee/employee_view");
        return modelAndView;
    }


    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        EmployeeDto dto = employeeService.getById(id);
        dto.setDeleted("Y");

        employeeService.saveOrUpdate(dto);

        modelAndView.addObject("designations", designationService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("religions", religionService.findAll( "Y", "N"));
        modelAndView.addObject("types", employeeTypeService.findAll( userInfo,"Y", "N"));
        modelAndView.addObject("employees", employeeService.findAll( userInfo,"Y", "N"));
        modelAndView.setViewName("/employee/employee");
        return modelAndView;
    }



}
