package com.example.spring_boot.controladores;

import com.example.spring_boot.entidades.*;
import com.example.spring_boot.repositorios.ClientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/client")
public class clientesControlador {

    @Autowired
    public ClientesRepositorio clientRep;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(Model model, HttpSession session){

        model.addAttribute("title","Clientes- Inicio");
        return "clientes"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public String agregar(Model model){

        clientes cliente = new clientes();
        List<String> opciones=new ArrayList<>();
        opciones.add("Masculino");
        opciones.add("Femenino");
        String fecha=new String();

        model.addAttribute("cliente", cliente);
        model.addAttribute("opcion", opciones);
        model.addAttribute("fecha",fecha);

        model.addAttribute("title","Clientes- Inicio");
        return "cliente_agregar"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String agregar2(Model model, @ModelAttribute("cliente") clientes cliente, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }

        Date date=null;
        if(cliente.getExtra() != null && !cliente.getExtra().isEmpty()) {
            try {
                DateFormat formatter;
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = formatter.parse(cliente.getExtra());
                System.out.println(date);
            } catch (java.text.ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        clientes ingresar=new clientes();
        ingresar.setNombre(cliente.getNombre());
        ingresar.setBirth_place(cliente.getBirth_place());
        ingresar.setCedula(cliente.getCedula());
        ingresar.setBirth_date(date);
        ingresar.setGenero(cliente.getGenero());
        clientRep.save(ingresar);

        //System.out.println(" ----CLIENTES---");

        System.out.println("NOMBRE:"+cliente.getNombre()+" CEDULA:"+ cliente.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        model.addAttribute("title","Clientes- Inicio");
        return "redirect:/client/"; //TODO: uso de los cambios
    }

}
