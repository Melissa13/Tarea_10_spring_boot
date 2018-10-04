package com.example.spring_boot.controladores;

import com.example.spring_boot.entidades.*;
import com.example.spring_boot.repositorios.ClientesRepositorio;
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

        model.addAttribute("title","Clientes- Agregar");
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
        ingresar.setExtra(cliente.getExtra());
        clientRep.save(ingresar);

        //System.out.println(" ----CLIENTES---");

        System.out.println("NOMBRE:"+cliente.getNombre()+" CEDULA:"+ cliente.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        return "redirect:/client/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public String lista(Model model){

        List<clientes> client= clientRep.findAll();


        model.addAttribute("lista", client);
        model.addAttribute("title","Clientes- Lista");
        return "cliente_lista"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable Long id, Model model){

        clientes cc=clientRep.buscar(id);
        clientRep.delete(cc);

        model.addAttribute("title","Clientes- Borrar");
        return "redirect:/client/lista/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable Long id,Model model){

        clientes cc=clientRep.buscar(id);
        List<String> opciones=new ArrayList<>();
        opciones.add("Masculino");
        opciones.add("Femenino");

        model.addAttribute("cliente", cc);
        model.addAttribute("opcion", opciones);

        model.addAttribute("title","Clientes- Editar");
        return "cliente_edit"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String editar2(@PathVariable Long id,Model model, @ModelAttribute("cliente") clientes cliente, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }
        clientes ingresar=clientRep.buscar(id);

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
        ingresar.setNombre(cliente.getNombre());
        ingresar.setBirth_place(cliente.getBirth_place());
        ingresar.setCedula(cliente.getCedula());
        ingresar.setBirth_date(date);
        ingresar.setGenero(cliente.getGenero());
        ingresar.setExtra(cliente.getExtra());
        clientRep.save(ingresar);

        //System.out.println(" ----CLIENTES---");
        System.out.println("NOMBRE:"+cliente.getNombre()+" CEDULA:"+ cliente.getCedula()+" fecha:"+ingresar.getBirth_date());

        System.out.println("LLEGO AQUI");
        return "redirect:/client/ver/"+ingresar.getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/ver/{id}", method=RequestMethod.GET)
    public String vista(@PathVariable Long id, Model model){

        clientes cc=clientRep.buscar(id);
        model.addAttribute("cliente", cc);

        model.addAttribute("title","Clientes-datos");
        return "cliente_ver"; //TODO: uso de los cambios
    }

}
