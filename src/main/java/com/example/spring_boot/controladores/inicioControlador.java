package com.example.spring_boot.controladores;

import com.example.spring_boot.entidades.clientes;
import com.example.spring_boot.repositorios.ClientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class inicioControlador {

    @Autowired
    public ClientesRepositorio clientRep;


    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(Model model, HttpSession session){
        Long l=1234L;
        Date today = Calendar.getInstance().getTime();
        clientes c=new clientes();
        c.setNacimiento(today);
        c.setCedula(l);
        c.setGenero(false);
        c.setNombre("Matias");
        c.setBirth_place("Tenares");
        clientRep.save(c);

        model.addAttribute("title","Tarea 10- Inicio");
        return "base"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(Model model, HttpSession session){
        List<clientes> client= clientRep.findAll();
        System.out.println(" ----CLIENTES---");
        for (clientes cc:client){
            System.out.println("NOMBRE:"+cc.getNombre()+" ID:"+cc.getId()+" NACIMIENTO: "+ cc.getNacimiento()+" CEDULA:"+ cc.getCedula()+" LUGAR: "+cc.getBirth_place());
        }
        model.addAttribute("title","Login");
        return "login"; //TODO: uso de los cambios
    }
}
