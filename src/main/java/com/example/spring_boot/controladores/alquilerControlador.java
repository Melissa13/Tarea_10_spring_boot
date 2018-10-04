package com.example.spring_boot.controladores;

import com.example.spring_boot.entidades.*;
import com.example.spring_boot.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/alquiler")
public class alquilerControlador {
    @Autowired
    public AlquilerRepositorio alquilerRep;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(Model model, HttpSession session){

        model.addAttribute("title","Equipos- Inicio");
        return "alquiler"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public String agregar(Model model){

        alquiler equipo = new alquiler();
        List<String> opciones=new ArrayList<>();
        opciones.add("Masculino");
        opciones.add("Femenino");
        String fecha=new String();

        model.addAttribute("equipo", equipo);
        model.addAttribute("opcion", opciones);
        model.addAttribute("fecha",fecha);

        model.addAttribute("title","Alquiler- Agregar");
        return "alquiler_agregar"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String agregar2(Model model, @ModelAttribute("equipo") alquiler equipo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }

        alquiler ingresar=new alquiler();
        //ingresar.setNombre(equipo.getNombre());
        //ingresar.setFamilia(equipo.getFamilia());
        //ingresar.setSub_familia(equipo.getSub_familia());
        //ingresar.setCantidad(equipo.getCantidad());
        //ingresar.setCosto(equipo.getCosto());
        alquilerRep.save(ingresar);

        //System.out.println(" ----CLIENTES---");

        //System.out.println("NOMBRE:"+equipo.getNombre()+" F:"+ equipo.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        return "redirect:/equipo/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public String lista(Model model){

        List<alquiler> equipo= alquilerRep.findAll();


        model.addAttribute("lista", equipo);
        model.addAttribute("title","Alquiler- Lista");
        return "alquiler_lista"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);
        alquilerRep.delete(cc);

        model.addAttribute("title","Alquiler- Borrar");
        return "redirect:/equipo/lista/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable Long id,Model model){

        alquiler cc=alquilerRep.buscar(id);

        model.addAttribute("equipo", cc);

        model.addAttribute("title","Alquiler- Editar");
        return "alquiler_edit"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String editar2(@PathVariable Long id,Model model, @ModelAttribute("equipo") alquiler equipo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }
        alquiler ingresar=alquilerRep.buscar(id);

        //ingresar.setNombre(equipo.getNombre());
        //ingresar.setNombre(equipo.getNombre());
        //ingresar.setFamilia(equipo.getFamilia());
        //ingresar.setSub_familia(equipo.getSub_familia());
        //ingresar.setCantidad(equipo.getCantidad());
        //ingresar.setCosto(equipo.getCosto());
        alquilerRep.save(ingresar);

        //System.out.println(" ----CLIENTES---");
        //System.out.println("NOMBRE:"+equipo.getNombre()+" CEDULA:"+ equipo.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        return "redirect:/equipo/ver/"+ingresar.getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/ver/{id}", method=RequestMethod.GET)
    public String vista(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);
        model.addAttribute("equipo", cc);

        model.addAttribute("title","Alquiler-datos");
        return "alquiler_ver"; //TODO: uso de los cambios
    }
}
