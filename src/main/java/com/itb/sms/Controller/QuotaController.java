package com.itb.sms.Controller;

import com.itb.sms.dto.QuotaDto;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.QuotaService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "quota")
public class QuotaController {

    private final UserService userService;
    private final QuotaService quotaService;

    public QuotaController(UserService userService, QuotaService quotaService) {
        this.userService = userService;
        this.quotaService = quotaService;

    }

    @GetMapping("/list")
    public ModelAndView getQuotaList(ModelAndView modelAndView) {
        UserInfo userInfo = userService.getCurrentUser();
        modelAndView.addObject("quotas", quotaService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/quota/quota");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("quotaInfo") QuotaDto dto) {

        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        quotaService.saveOrUpdate(dto);

        modelAndView.addObject("quotas", quotaService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/quota/quota");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("quota", quotaService.getById(id));
        modelAndView.setViewName("/quota/quota_view");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id) {
        UserInfo userInfo = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        QuotaDto dto = quotaService.getById(id);
        dto.setDeleted("Y");

        quotaService.saveOrUpdate(dto);

        modelAndView.addObject("quotas", quotaService.findAll(userInfo, null, "N"));
        modelAndView.setViewName("/quota/quota");
        return modelAndView;
    }


}
