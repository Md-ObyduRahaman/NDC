package com.itb.sms.Controller;

import com.itb.sms.dto.ExamDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.ExamService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "exam")
public class ExamController {

    private final UserService userService;
    private final ExamService examService;

    public ExamController(UserService userService, ExamService examService) {
        this.userService = userService;
        this.examService = examService;

    }

    @GetMapping("/list")
    public ModelAndView getExamList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("exams", examService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/exam/exam");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("examInfo") ExamDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        examService.saveOrUpdate(dto);

        modelAndView.addObject("exams", examService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/exam/exam");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exam", examService.getById(id));
        modelAndView.setViewName("/exam/exam_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        ExamDto dto = examService.getById(id);
        dto.setDeleted("Y");

        examService.saveOrUpdate(dto);

        modelAndView.addObject("exams", examService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/exam/exam");
        return modelAndView;
    }


}
