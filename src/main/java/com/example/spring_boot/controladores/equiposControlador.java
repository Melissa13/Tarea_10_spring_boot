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
@RequestMapping("/equipo")
public class equiposControlador {
    @Autowired
    public EquiposRepositorio equipRep;
    @Autowired
    public EquiopoSoloRepositorio equipssRep;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(Model model, HttpSession session){

        model.addAttribute("title","Equipos- Inicio");
        return "equipos"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public String agregar(Model model){

        equipos equipo = new equipos();

        model.addAttribute("equipo", equipo);

        model.addAttribute("title","Equipos- Agregar");
        return "equipos_agregar"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String agregar2(Model model, @ModelAttribute("equipo") equipos equipo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }

        equipos ingresar=new equipos();
        ingresar.setNombre(equipo.getNombre());
        ingresar.setFamilia(equipo.getFamilia());
        ingresar.setSub_familia(equipo.getSub_familia());
        ingresar.setCantidad(equipo.getCantidad());
        ingresar.setCosto(equipo.getCosto());
        ingresar.setDisponibles(equipo.getCantidad());
        equipRep.save(ingresar);

        //System.out.println(" ----CLIENTES---");

        //System.out.println("NOMBRE:"+equipo.getNombre()+" F:"+ equipo.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        return "redirect:/equipo/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public String lista(Model model){

        List<equipos> equipo= equipRep.findAll();


        model.addAttribute("lista", equipo);
        model.addAttribute("title","Equipos- Lista");
        return "equipos_lista"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable Long id, Model model){

        equipos cc=equipRep.buscar(id);
        equipRep.delete(cc);

        model.addAttribute("title","Equipos- Borrar");
        return "redirect:/equipo/lista/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable Long id,Model model){

        equipos cc=equipRep.buscar(id);

        model.addAttribute("equipo", cc);

        model.addAttribute("title","Equipos- Editar");
        return "equipos_edit"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String editar2(@PathVariable Long id,Model model, @ModelAttribute("equipo") equipos equipo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }
        equipos ingresar=equipRep.buscar(id);

        ingresar.setNombre(equipo.getNombre());
        ingresar.setNombre(equipo.getNombre());
        ingresar.setFamilia(equipo.getFamilia());
        ingresar.setSub_familia(equipo.getSub_familia());
        ingresar.setCosto(equipo.getCosto());

        boolean noaceptado=false;
        Long dato=prestamos(ingresar);
        if(equipo.getCantidad()>dato){
            ingresar.setCantidad(equipo.getCantidad());
            long actual=equipo.getCantidad()-dato;
            ingresar.setDisponibles(actual);

        }
        else {
            noaceptado=true;
        }

        equipRep.save(ingresar);

        if(noaceptado){
            //redireccion pagina de error
            return "redirect:/equipo/erroneo/"+ingresar.getId();
        }

        //System.out.println(" ----CLIENTES---");
        //System.out.println("NOMBRE:"+equipo.getNombre()+" CEDULA:"+ equipo.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        return "redirect:/equipo/ver/"+ingresar.getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/ver/{id}", method=RequestMethod.GET)
    public String vista(@PathVariable Long id, Model model){

        equipos cc=equipRep.buscar(id);
        model.addAttribute("equipo", cc);

        model.addAttribute("title","Equipos-datos");
        return "equipos_ver"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/erroneo/{id}", method=RequestMethod.GET)
    public String errorcant(@PathVariable Long id, Model model){

        equipos cc=equipRep.buscar(id);
        model.addAttribute("equipo", cc);
        //equipo/lista/

        model.addAttribute("title","Equipos-error");
        return "erroneo"; //TODO: uso de los cambios
    }

    //calcular cantidad de equipos alquilados
    public long prestamos(equipos e){
        long n=0;
        List<equipoSolo> cant=equipssRep.findAll();
        for (equipoSolo esto:cant){
            if(esto.getAsociado().getNombre().equals(e.getNombre())){
                n+=esto.getCantidad();
            }
        }
        return  n;
    }
}
