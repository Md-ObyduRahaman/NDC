package com.itb.sms.Controller;

import com.itb.sms.dto.RoomDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.BuildingService;
import com.itb.sms.service.RoomService;
import com.itb.sms.service.RoomTypeService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "room")
public class RoomController {

    private final UserService userService;
    private final RoomTypeService roomTypeService;
    private final BuildingService buildingService;
    private final RoomService roomService;

    public RoomController(UserService userService, BuildingService buildingService, RoomTypeService roomTypeService, RoomService roomService) {
        this.roomTypeService = roomTypeService;
        this.roomService = roomService;
        this.userService = userService;
        this.buildingService = buildingService;

    }

    @GetMapping("/list")
    public ModelAndView getRoomList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("buildings", buildingService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("types", roomTypeService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("rooms", roomService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/room/room");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("roomInfo") RoomDto dto) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        roomService.saveOrUpdate(dto);

        modelAndView.addObject("buildings", buildingService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("types", roomTypeService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("rooms", roomService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/room/room");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("room", roomService.getById(id));
        modelAndView.setViewName("/room/room_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        RoomDto dto = roomService.getById(id);
        dto.setDeleted("Y");

        roomService.saveOrUpdate(dto);

        modelAndView.addObject("buildings", buildingService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("types", roomTypeService.findAll(userInfo, "Y", "N"));
        modelAndView.addObject("rooms", roomService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/room/room");
        return modelAndView;
    }


}
