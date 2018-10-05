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
import java.util.*;

@Controller
@RequestMapping("/historial")
public class historialControlador {

    @Autowired
    public AlquilerRepositorio alquilerRep;
    @Autowired
    public ClientesRepositorio clientRep;
    @Autowired
    public EquiposRepositorio equipRep;
    @Autowired
    public EquiopoSoloRepositorio equipssRep;

    @RequestMapping(value = "/lista/{id}", method=RequestMethod.GET)
    public String lista(@PathVariable Long id, Model model){

        clientes client=clientRep.buscar(id);
        List<alquiler> equipo= alquilerRep.findAll();
        List<alquiler> equipo2= new ArrayList<>();
        for (alquiler a:equipo){
            if(a.getCliente().getNombre().equals(client.getNombre())){
                equipo2.add(a);
            }
        }

        model.addAttribute("cli", client);
        model.addAttribute("lista", equipo2);
        model.addAttribute("title","Historial- Lista");
        return "historial_lista"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String agregar(Model model){

        List<clientes> opcion1=clientRep.findAll();

        model.addAttribute("opcion", opcion1);

        model.addAttribute("title","Historial- inicio");
        return "historial"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String agregar2(@RequestParam("opcioncli") Long sclient, Model model){

        clientes cli=clientRep.buscar(sclient);



        return "redirect:/historial/lista/"+cli.getId(); //TODO: uso de los cambios
    }

}
