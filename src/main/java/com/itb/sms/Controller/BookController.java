package com.itb.sms.Controller;

import com.itb.sms.dto.BookDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.BookService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "book")
public class BookController {

    private final UserService userService;
    private final BookService bookService;

    public BookController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;

    }

    @GetMapping("/list")
    public ModelAndView getBookList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("books", bookService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/book/book");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("bookInfo") BookDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        bookService.saveOrUpdate(dto);

        modelAndView.addObject("books", bookService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/book/book");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("book", bookService.getById(id));
        modelAndView.setViewName("/book/book_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        BookDto dto = bookService.getById(id);
        dto.setDeleted("Y");

        bookService.saveOrUpdate(dto);

        modelAndView.addObject("books", bookService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/book/book");
        return modelAndView;
    }


}
