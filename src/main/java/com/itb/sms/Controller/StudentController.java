package com.itb.sms.Controller;


import com.itb.sms.dto.EmployeeDto;
import com.itb.sms.dto.StudentDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {

    private final UserService userService;
    private final StudentService studentService;
    private final OccupationService occupationService;
    private final ReligionService religionService;
    private final QuotaService quotaService;
    private final ClassService classService;
    private final SectionService sectionService;
    private final GroupService groupService;
    private final SessionService sessionService;
    private final AreaService areaService;
    private final LocationService locationService;
    private final StateService stateService;
    private final CityService cityService;
    private final PostService postService;
    private final UnionService unionService;

    public StudentController(UserService userService, OccupationService occupationService,
                             ReligionService religionService, QuotaService quotaService,
                             ClassService classService,SectionService sectionService,
                             GroupService groupService,SessionService sessionService,
                             AreaService areaService,LocationService locationService,
                             StateService stateService,CityService cityService,
                             PostService postService,UnionService unionService,
                             StudentService studentService) {
        this.userService = userService;
        this.occupationService = occupationService;
        this.religionService = religionService ;
        this.quotaService = quotaService;
        this.classService = classService;
        this.sectionService = sectionService;
        this.groupService = groupService ;
        this.sessionService = sessionService;
        this.areaService = areaService;
        this.locationService = locationService;
        this.stateService = stateService ;
        this.cityService = cityService;
        this.postService = postService;
        this.unionService = unionService ;
        this.studentService = studentService;

    }

    @GetMapping("/list")
    public ModelAndView getEmployeeList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("occupations", occupationService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("religions", religionService.findAll( "Y", "N"));
        modelAndView.addObject("quotas", quotaService.findAll( userInfo,"Y", "N"));
        modelAndView.addObject("classes", classService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("groups", groupService.findAll( "Y", "N"));
        modelAndView.addObject("sessions", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("states", stateService.findAll( "Y", "N"));
        modelAndView.addObject("cities", cityService.findAll( "Y", "N"));
        modelAndView.addObject("thanas", postService.findAll( "Y", "N"));
        modelAndView.addObject("unions", unionService.findAll( "Y", "N"));
        modelAndView.addObject("areas", areaService.findAll( "Y", "N"));
        modelAndView.addObject("locations", locationService.findAll( "Y", "N"));

        modelAndView.setViewName("/student/student");
        return modelAndView;
    }

    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("studentInfo") StudentDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

       studentService.saveOrUpdate(dto);

        modelAndView.addObject("occupations", occupationService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("religions", religionService.findAll( "Y", "N"));
        modelAndView.addObject("quotas", quotaService.findAll( userInfo,"Y", "N"));
        modelAndView.addObject("classes", classService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("groups", groupService.findAll( "Y", "N"));
        modelAndView.addObject("sessions", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("states", stateService.findAll( "Y", "N"));
        modelAndView.addObject("cities", cityService.findAll( "Y", "N"));
        modelAndView.addObject("thanas", postService.findAll( "Y", "N"));
        modelAndView.addObject("unions", unionService.findAll( "Y", "N"));
        modelAndView.addObject("areas", areaService.findAll( "Y", "N"));
        modelAndView.addObject("locations", locationService.findAll( "Y", "N"));

        modelAndView.setViewName("/student/student");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

       // modelAndView.addObject("employee", employeeService.getById(id));
        modelAndView.setViewName("/employee/employee_view");
        return modelAndView;
    }


    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        /*EmployeeDto dto = employeeService.getById(id);
        dto.setDeleted("Y");

        employeeService.saveOrUpdate(dto);*/

        /*modelAndView.addObject("designations", designationService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("religions", religionService.findAll( "Y", "N"));
        modelAndView.addObject("types", employeeTypeService.findAll( userInfo,"Y", "N"));
        modelAndView.addObject("employees", employeeService.findAll( userInfo,"Y", "N"));*/
        modelAndView.setViewName("/employee/employee");
        return modelAndView;
    }



}
