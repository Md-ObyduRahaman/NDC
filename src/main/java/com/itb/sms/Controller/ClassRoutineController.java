package com.itb.sms.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itb.sms.dto.ClassRoutineDto;
import com.itb.sms.dto.InstituteDto;
import com.itb.sms.dto.SectionDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "class_routine")
public class ClassRoutineController {

    private final UserService userService;
    private final ClassService classService;
    private final SectionService sectionService;
    private final SessionService sessionService;
    private final SubjectService subjectService;
    private final EmployeeService employeeService;
    private final RoomService roomService;
    private final ClassRoutineService classRoutineService;
    private final InstituteService instituteService;

    public ClassRoutineController(UserService userService, ClassService classService, SectionService sectionService,
                                  SessionService sessionService, SubjectService subjectService, EmployeeService employeeService,
                                  RoomService roomService, ClassRoutineService classRoutineService,InstituteService instituteService
                                  ) {
        this.classService = classService;
        this.userService = userService;
        this.sectionService = sectionService;
        this.sessionService = sessionService;
        this.subjectService = subjectService;
        this.employeeService = employeeService;
        this.roomService = roomService;
        this.classRoutineService = classRoutineService;
        this.instituteService = instituteService ;

    }

    @GetMapping("/info")
    public ModelAndView getClassList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("classes", classService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sessions", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("teachers", employeeService.findTeachingStaff(userInfo, "Y", "N"));
        modelAndView.addObject("rooms", roomService.findAll(userInfo, "Y", "N"));
        modelAndView.setViewName("/routine/routine");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("routineInfo") ClassRoutineDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();
        if(dto.getId()!=null){
            ClassRoutineDto entity = classRoutineService.getById(dto.getId());
            entity.setTeacherId(dto.getTeacherId());
            entity.setSubjectId(dto.getSubjectId());
            entity.setRoomId(dto.getRoomId());
            classRoutineService.saveOrUpdate(entity);

        }else{

            classRoutineService.saveOrUpdate(dto);
        }


        modelAndView.addObject("classes", classService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sessions", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("teachers", employeeService.findTeachingStaff(userInfo, "Y", "N"));
        modelAndView.addObject("rooms", roomService.findAll(userInfo, "Y", "N"));
        modelAndView.setViewName("/routine/routine");
        return modelAndView;
    }


    @ResponseBody
    @GetMapping(value = "/{id}")
    public String getById(@PathVariable(value = "id") Long id) {
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        return g.toJson(classRoutineService.getById(id));
    }

    @ResponseBody
    @GetMapping(value = "/{classId}/{sectionId}/{sessionId}")
    public ModelAndView getClassRoutine(@PathVariable(value = "classId") Long classId,
                                        @PathVariable(value = "sectionId") Long sectionId,
                                        @PathVariable(value = "sessionId") Long sessionId) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.getCurrentUser();

        InstituteDto instituteInfo = instituteService.getById(userInfo.getInstituteId());

        SectionDto sectionInfo = sectionService.getById(sectionId);


        List<ClassRoutineDto> routineList = classRoutineService.findRoutineList(userInfo, classId, sectionId, sessionId,"N");
        Set<String> days = new HashSet<>();
        for (ClassRoutineDto routines : routineList) {
            days.add(routines.getDay());
        }

        modelAndView.addObject("instituteName", instituteInfo.getInstituteName());
        modelAndView.addObject("logo", instituteInfo.getLogo());
        modelAndView.addObject("className", sectionInfo.getClassName());
        modelAndView.addObject("sectionName", sectionInfo.getSectionName());
        modelAndView.addObject("dayList", days);
        modelAndView.addObject("routineList", routineList);
        modelAndView.setViewName("/routine/routine_list");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        ClassRoutineDto dto = classRoutineService.getById(id);
        dto.setDeleted("Y");
        classRoutineService.saveOrUpdate(dto);

        modelAndView.addObject("classes", classService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sections", sectionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sessions", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("teachers", employeeService.findTeachingStaff(userInfo, "Y", "N"));
        modelAndView.addObject("rooms", roomService.findAll(userInfo, "Y", "N"));
        modelAndView.setViewName("/routine/routine");
        return modelAndView;
    }


}
