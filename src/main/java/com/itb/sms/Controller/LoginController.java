package com.itb.sms.Controller;

import com.itb.sms.model.UserInfo;
import com.itb.sms.service.MenuService;
import com.itb.sms.service.ModuleService;
import com.itb.sms.service.RoleMenuService;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    private final UserService userService;
    private final ModuleService moduleService;
    private final MenuService menuService;
    private final RoleMenuService roleMenuService;

    public LoginController(UserService userService,ModuleService moduleService,MenuService menuService,RoleMenuService roleMenuService) {
        this.userService = userService;
        this.moduleService = moduleService;
        this.menuService = menuService ;
        this.roleMenuService = roleMenuService;
    }

    @GetMapping({"/sms","/login"})
    private String login (){

        return "login";
    }

    @GetMapping("/dashboard")
    private String dashboard (Model model){

        UserInfo userInfo = userService.getCurrentUser();

        model.addAttribute("user",userInfo);

        if(userInfo.getRoleInfo().getSuperAdminStatus().equals("Y")){
            model.addAttribute("moduleList",moduleService.getModules("Y"));
            model.addAttribute("menuList",menuService.findAll("Y"));
        }else{
            model.addAttribute("moduleList",moduleService.getModulesByRoleId(userInfo.getRoleInfo().getId()));
            model.addAttribute("menuList",roleMenuService.getAssignedMenus(userInfo.getRoleInfo().getId()));
        }

        return "dashboard";
    }
}
