package com.itb.sms.Controller;

import com.itb.sms.dto.SubjectBookDto;
import com.itb.sms.dto.TeacherSubjectDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "teacher_subject")
public class TeacherSubjectController {

    private final UserService userService;
    private final TeacherSubjectService teacherSubjectService;
    private final SubjectService subjectService;
    private final EmployeeService employeeService;


    public TeacherSubjectController(UserService userService, TeacherSubjectService teacherSubjectService,
                                    EmployeeService employeeService,SubjectService subjectService) {
        this.userService = userService;
        this.employeeService = employeeService ;
        this.subjectService = subjectService;
        this.teacherSubjectService = teacherSubjectService ;


    }

    @GetMapping("/list")
    public ModelAndView getTeacherSubjectList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("list", teacherSubjectService.findAll(userInfo, null, "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("employees", employeeService.findTeachingStaff(userInfo, "Y", "N"));
        modelAndView.setViewName("/subject/teacher_subject");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("teacherSubjectInfo") TeacherSubjectDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        teacherSubjectService.saveOrUpdate(dto);

        modelAndView.addObject("list", teacherSubjectService.findAll(userInfo, null, "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("employees", employeeService.findTeachingStaff(userInfo, "Y", "N"));
        modelAndView.setViewName("/subject/teacher_subject");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("teacherSubject", teacherSubjectService.getById(id));
        modelAndView.setViewName("/subject/teacher_subject_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        TeacherSubjectDto dto = teacherSubjectService.getById(id);
        dto.setDeleted("Y");

        teacherSubjectService.saveOrUpdate(dto);

        modelAndView.addObject("list", teacherSubjectService.findAll(userInfo, null, "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("employees", employeeService.findTeachingStaff(userInfo, "Y", "N"));
        modelAndView.setViewName("/subject/teacher_subject");
        return modelAndView;
    }


}
