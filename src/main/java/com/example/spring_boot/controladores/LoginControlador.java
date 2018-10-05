package com.example.spring_boot.controladores;

import com.example.spring_boot.entidades.seguridad.usuario;
import com.example.spring_boot.repositorios.UserRepositorio;
import com.example.spring_boot.servicios.usuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginControlador {

    @Autowired
    private usuarioServicio userService;

    @Autowired
    public UserRepositorio userRepositorio;

    @RequestMapping("/login")
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {

        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public String login(Model model)
    {
        String username = new String();
        String password = new String();

        model.addAttribute("username",username);
        model.addAttribute("password",password);

        model.addAttribute("title","login");

        return "login_log";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String pass, Model model)
    {

        if(userService.validateUserAccount(username,pass))
        {
            return "redirect:/";
        }
        else
        {
            //userService.deleteUserAccount("jojo");
            //userService.createNewUserAccount("jojo","Joseph","Joestar", new String("lel"));
            List<usuario> u = userRepositorio.findAll();
            for (usuario uu:u) {
                System.out.println(uu.getFirstName()+" "+uu.getLastName()+" "+uu.getUsername()+" "+uu.getPassword());
            }
            return "redirect:/login?error=INVALID%20USER%20ACCOUNT";
        }


    }




    /*public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        //userService.createNewUserAccount("jojo","Joseph","Joestar", "1234");
        if (userService.validateUserAccount(username, password))
            return "redirect:/equipo";
        else
            return "redirect:/login?error=INVALID%20USER%20ACCOUNT";
    }*/
}
