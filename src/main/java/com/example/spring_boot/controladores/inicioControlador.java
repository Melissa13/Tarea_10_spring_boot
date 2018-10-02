package com.example.spring_boot.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class inicioControlador {

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(Model model, HttpSession session){
        model.addAttribute("title","Tarea 10- Inicio");
        return "base"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(Model model, HttpSession session){
        model.addAttribute("title","Login");
        return "login"; //TODO: uso de los cambios
    }
}
