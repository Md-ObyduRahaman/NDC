package com.itb.sms.Controller;

import com.itb.sms.dto.SalaryGradeDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.SalaryGradeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "salary_grade")
public class SalaryGradeController {

    private final UserService userService;
    private final SalaryGradeService salaryGradeService;

    public SalaryGradeController(UserService userService, SalaryGradeService salaryGradeService) {
        this.userService = userService;
        this.salaryGradeService = salaryGradeService;

    }

    @GetMapping("/list")
    public ModelAndView getSalaryGradeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("salaryGrades", salaryGradeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/payroll/salary_grade");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("salaryGradeInfo") SalaryGradeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        salaryGradeService.saveOrUpdate(dto);

        modelAndView.addObject("salaryGrades", salaryGradeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/payroll/salary_grade");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("salaryGrade", salaryGradeService.getById(id));
        modelAndView.setViewName("/payroll/salary_grade_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        SalaryGradeDto dto=salaryGradeService.getById(id);
        dto.setDeleted("Y");

        salaryGradeService.saveOrUpdate(dto);

        modelAndView.addObject("salaryGrades", salaryGradeService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/payroll/salary_grade");
        return modelAndView;
    }



}
