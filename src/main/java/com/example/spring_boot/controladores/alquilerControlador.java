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
@RequestMapping("/alquiler")
public class alquilerControlador {

    @Autowired
    public AlquilerRepositorio alquilerRep;
    @Autowired
    public ClientesRepositorio clientRep;
    @Autowired
    public EquiposRepositorio equipRep;
    @Autowired
    public EquiopoSoloRepositorio equipssRep;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(Model model, HttpSession session){

        /*List<alquiler> litapp2=alquilerRep.buscarUltimo();
        //alquiler lita=litapp2.get(0);
        for (alquiler lita:litapp2){
            System.out.println("ID: "+lita.getId()+" cliente:"+lita.getCliente().getNombre()+" fecha1:" +lita.getExtra1()+" fecha2:"+lita.getExtra2()+" equipos"+ lita.getEquipo().size());

        }*/


        model.addAttribute("title","Equipos- Inicio");
        return "alquiler"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public String agregar(Model model){

        alquiler equipo = new alquiler();
        List<clientes> opcion1=clientRep.findAll();
        List<equipos> opcion2=equipRep.findAll();

        model.addAttribute("equipo", equipo);
        model.addAttribute("opcion", opcion1);
        model.addAttribute("opcion2",opcion2);

        model.addAttribute("title","Alquiler- Agregar");
        return "alquiler_agregar"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String agregar2(@RequestParam("opcionequi") List<Long> seleccion, @RequestParam("opcioncli") Long sclient, Model model, @ModelAttribute("equipo") alquiler equipo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }
        clientes cli=clientRep.buscar(sclient);

        Set<equipos> eq=new HashSet<>();
        if(seleccion!=null){
            for (long e:seleccion){
                equipos ep=equipRep.buscar(e);
                //System.out.println("Nombre seleccion:"+ep.getNombre());
                eq.add(ep);
            }
        }

        for (equipos ep:eq){
            System.out.println("Nombre seleccion:"+ep.getNombre());
        }

        Date date1=null;
        Date date2=null;
        if((equipo.getExtra1() != null && !equipo.getExtra1().isEmpty()) || (equipo.getExtra2() != null && !equipo.getExtra2().isEmpty())) {
            try {
                DateFormat formatter;
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                date1 = formatter.parse(equipo.getExtra1());
                date2 = formatter.parse(equipo.getExtra2());
            } catch (java.text.ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(date1);
        cal2.setTime(date2);
        long days=daysBetween(cal1.getTime(),cal2.getTime());

        alquiler ingresar=new alquiler();
        ingresar.setCliente(cli);
        //ingresar.setEquipo(equipo.getFamilia());
        ingresar.setExtra1(equipo.getExtra1());
        ingresar.setExtra2(equipo.getExtra2());
        ingresar.setFecha_prestamo(date1);
        ingresar.setFecha_entrega(date2);
        ingresar.setDias(days);
        ingresar.setPendiente(true);
        alquilerRep.save(ingresar);

        List<alquiler> litapp=alquilerRep.buscarUltimo();
        alquiler litap=litapp.get(0);
        System.out.println("ID: "+litap.getId()+" cliente:"+litap.getCliente().getNombre()+" fecha1:" +litap.getExtra1()+" fecha2:"+litap.getExtra2());

        Set<equipoSolo> inv=new HashSet<>();
        for(equipos ep: eq){
            equipoSolo ess=new equipoSolo();
            ess.setAsociado(ep);
            ess.setCantidad(1L);
            ess.setOrden_alquiler(litap);
            equipssRep.save(ess);
        }

        List<alquiler> litapp2=alquilerRep.buscarUltimo();
        alquiler lita=litapp2.get(0);
        System.out.println("ID: "+lita.getId()+" cliente:"+lita.getCliente().getNombre()+" fecha1:" +lita.getExtra1()+" fecha2:"+lita.getExtra2()+" equipos"+ lita.getEquipo().size());


        return "redirect:/alquiler/"; //TODO: uso de los cambios
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

    public long daysBetween(Date d1, Date d2) {
        return (long) ( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
