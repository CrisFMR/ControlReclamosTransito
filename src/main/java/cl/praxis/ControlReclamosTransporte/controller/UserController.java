package cl.praxis.ControlReclamosTransporte.controller;

import cl.praxis.ControlReclamosTransporte.model.entities.User;
import cl.praxis.ControlReclamosTransporte.model.service.RoleService;
import cl.praxis.ControlReclamosTransporte.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final RoleService roleService;

    public UserController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        model.addAttribute("users", service.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "userNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute User user){
        boolean result = service.create(user);
        return "index";
    }
}