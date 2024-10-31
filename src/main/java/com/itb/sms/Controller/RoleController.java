package com.itb.sms.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itb.sms.dto.MenuInfoDto;
import com.itb.sms.dto.RoleDto;
import com.itb.sms.dto.RoleMenuInfoDto;
import com.itb.sms.service.MenuService;
import com.itb.sms.service.RoleMenuService;
import com.itb.sms.service.RoleService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "role")
public class RoleController {

    private final RoleService roleService;
    private final MenuService menuService;
    private final RoleMenuService roleMenuService;

    public RoleController(RoleService roleService,MenuService menuService,RoleMenuService roleMenuService) {
        this.roleService = roleService;
        this.menuService = menuService;
        this.roleMenuService = roleMenuService;
    }

    @GetMapping("/list")
    public ModelAndView getRoleList(ModelAndView modelAndView) {
        modelAndView.addObject("roles", roleService.findAll(null));
        modelAndView.setViewName("/role/role");
        return modelAndView;
    }



    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView add(@ModelAttribute("roleInfo") RoleDto dto) {

        ModelAndView modelAndView = new ModelAndView();

        roleService.saveOrUpdate(dto);

        modelAndView.addObject("roles", roleService.findAll(null));
        modelAndView.setViewName("/role/role");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("role", roleService.getById(id));
        modelAndView.setViewName("/role/role_view");
        return modelAndView;
    }

    @GetMapping("/menu")
    public ModelAndView getMenuAccessInfo(ModelAndView modelAndView) {
        modelAndView.addObject("roles", roleService.findAll("N"));
        modelAndView.setViewName("role/menu_access");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/unassigned-menu-list/{roleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUnassignedMenuList(@PathVariable(value = "roleId") Long roleId) {
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        List<MenuInfoDto> list = menuService.getUnAssignedMenus(roleId);
        System.out.println("UnassignedMenu Size: "+list.size());
        return g.toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/assigned-menu-list/{roleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAssignedMenuList(@PathVariable(value = "roleId") Long roleId) {
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        List<RoleMenuInfoDto> list = roleMenuService.getAssignedMenus(roleId);
        return g.toJson(list);
    }

    @ResponseBody
    @PostMapping(value = "/save-menu/{menuId}/{roleId}")
    public void addUserMenu(@PathVariable(value = "menuId") Long menuId,
                               @PathVariable(value = "roleId") Long roleId) {

        RoleMenuInfoDto dto = new RoleMenuInfoDto();
        dto.setMenuId(menuId);
        dto.setRoleId(roleId);

         roleMenuService.saveRoleMenu(dto);
    }

    @ResponseBody
    @PostMapping(value = "/remove-menu/{menuId}/{roleId}")
    public void removeRoleMenu(@PathVariable(value = "menuId") Long menuId,
                               @PathVariable(value = "roleId") Long roleId) {


        roleMenuService.removeRoleMenu(menuId, roleId);
    }

}
