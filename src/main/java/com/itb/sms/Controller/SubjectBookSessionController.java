package com.itb.sms.Controller;

import com.itb.sms.dto.SubjectBookDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "subject_book_session")
public class SubjectBookSessionController {

    private final UserService userService;
    private final SubjectTypeService subjectTypeService;
    private final SubjectService subjectService;
    private final BookService bookService;
    private final SessionService sessionService;
    private final SubjectBookService subjectBookService;

    public SubjectBookSessionController(UserService userService,SubjectTypeService subjectTypeService,
                                        SubjectService subjectService,BookService bookService,
                                        SessionService sessionService,SubjectBookService subjectBookService) {
        this.userService = userService;
        this.subjectService = subjectService;
        this.subjectTypeService = subjectTypeService ;
        this.bookService = bookService;
        this.sessionService = sessionService ;
        this.subjectBookService = subjectBookService ;

    }

    @GetMapping("/list")
    public ModelAndView getSubjectBookSessionList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("list", subjectBookService.findAll(userInfo, null, "N"));
        modelAndView.addObject("subjectTypes", subjectTypeService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("books", bookService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sessionsList", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.setViewName("/subject/subject_book");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("subjectBookInfo") SubjectBookDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        subjectBookService.saveOrUpdate(dto);

        modelAndView.addObject("list", subjectBookService.findAll(userInfo, null, "N"));
        modelAndView.addObject("subjectTypes", subjectTypeService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("books", bookService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sessionsList", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.setViewName("/subject/subject_book");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("subjectBook", subjectBookService.getById(id));
        modelAndView.setViewName("/subject/subject_book_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        SubjectBookDto dto = subjectBookService.getById(id);
        dto.setDeleted("Y");

        subjectBookService.saveOrUpdate(dto);

        modelAndView.addObject("list", subjectBookService.findAll(userInfo, null, "N"));
        modelAndView.addObject("subjectTypes", subjectTypeService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("subjects", subjectService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("books", bookService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("sessionsList", sessionService.findAll(userInfo, "Y", "N"));
        modelAndView.setViewName("/subject/subject_book");
        return modelAndView;
    }


}
