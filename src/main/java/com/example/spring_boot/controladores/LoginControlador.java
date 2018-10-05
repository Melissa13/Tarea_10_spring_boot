package com.example.spring_boot.controladores;

import com.example.spring_boot.servicios.usuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginControlador {

    @Autowired
    private usuarioServicio userService;

    @RequestMapping("/login")
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {

        return new ModelAndView("login", "error", error);
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        if (userService.validateUserAccount(username, password))
            return "redirect:/AlquiService";
        else
            return "redirect:/login?error=INVALID%20USER%20ACCOUNT";
    }
}
