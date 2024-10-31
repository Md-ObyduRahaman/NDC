package com.itb.sms.Controller;

import com.itb.sms.dto.RoomTypeDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.RoomTypeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "room_type")
public class RoomTypeController {

    private final UserService userService;
    private final RoomTypeService roomTypeService;

    public RoomTypeController(UserService userService,RoomTypeService roomTypeService) {
        this.userService = userService ;
        this.roomTypeService = roomTypeService;

    }

    @GetMapping("/list")
    public ModelAndView getRoleList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("roomTypes", roomTypeService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/room/room_type");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("roomTypeInfo") RoomTypeDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        roomTypeService.saveOrUpdate(dto);

        modelAndView.addObject("roomTypes", roomTypeService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/room/room_type");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("roomType", roomTypeService.getById(id));
        modelAndView.setViewName("/room/room_type_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        RoomTypeDto dto= roomTypeService.getById(id);
        dto.setDeleted("Y");
        roomTypeService.saveOrUpdate(dto);

        modelAndView.addObject("roomTypes", roomTypeService.findAll(userInfo,null,"N"));
        modelAndView.setViewName("/room/room_type");
        return modelAndView;
    }



}
