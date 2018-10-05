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

            Date today = Calendar.getInstance().getTime();
            System.out.println(" DEL DIA 1:"+daysBetween(today,lita.getFecha_prestamo()));
            System.out.println(" DEL DIA 3:"+daysBetween(today,lita.getFecha_entrega()));
        }*/


        model.addAttribute("title","Equipos- Inicio");
        return "alquiler"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public String agregar(Model model){

        alquiler equipo = new alquiler();
        List<clientes> opcion1=clientRep.findAll();
        List<equipos> opcion2=equipRep.findAll();
        List<equipos> eq=new ArrayList<>();
        for(equipos e: opcion2){
            if(e.getDisponibles()>0){
                eq.add(e);
            }
        }

        model.addAttribute("equipo", equipo);
        model.addAttribute("opcion", opcion1);
        model.addAttribute("opcion2",eq);

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
        ingresar.setActivo(true);
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

            //disminuyendo existencias
            equipos disminuir=equipRep.buscar(ep.getId());
            Long dato=disminuir.getDisponibles()-1;
            disminuir.setDisponibles(dato);
            equipRep.save(disminuir);
        }


        return "redirect:/alquiler/ver/"+litap.getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public String lista(Model model){

        List<alquiler> equipo= alquilerRep.findAll();
        List<alquiler> aux= new ArrayList<>();
        for(alquiler esto:equipo){
            if(esto.isActivo()){
                aux.add(esto);
            }
        }

        model.addAttribute("lista", aux);
        model.addAttribute("title","Alquiler- Lista");
        return "alquiler_lista"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);
        /*for(equipoSolo esto:cc.getEquipo()){
            equipoSolo eliminar=esto;

            //disminuyendo existencias
            equipos disminuir=eliminar.getAsociado();
            Long dato=disminuir.getDisponibles()+eliminar.getCantidad();
            disminuir.setDisponibles(dato);
            equipRep.save(disminuir);

            equipssRep.delete(eliminar);
        }*/
        //alquilerRep.delete(cc);
        cc.setActivo(false);
        alquilerRep.save(cc);

        model.addAttribute("title","Alquiler- Borrar");
        return "redirect:/alquiler/lista/"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable Long id,Model model){

        alquiler cc=alquilerRep.buscar(id);
        List<clientes> opcion1=clientRep.findAll();

        model.addAttribute("equipo", cc);
        model.addAttribute("opcion", opcion1);

        model.addAttribute("title","Alquiler- Editar");
        return "alquiler_edit"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String editar2(@PathVariable Long id,@RequestParam("opcioncli") Long sclient, Model model, @ModelAttribute("equipo") alquiler equipo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        }
        clientes cli=clientRep.buscar(sclient);

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

        alquiler ingresar=alquilerRep.buscar(id);
        ingresar.setCliente(cli);
        ingresar.setExtra1(equipo.getExtra1());
        ingresar.setExtra2(equipo.getExtra2());
        ingresar.setFecha_prestamo(date1);
        ingresar.setFecha_entrega(date2);
        ingresar.setDias(days);
        ingresar.setPendiente(equipo.isPendiente());
        alquilerRep.save(ingresar);

        return "redirect:/alquiler/ver/"+ingresar.getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/ver/{id}", method=RequestMethod.GET)
    public String vista(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);
        model.addAttribute("alquiler", cc);

        model.addAttribute("title","Alquiler-datos");
        return "alquiler_ver"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/mas/{id}", method=RequestMethod.GET)
    public String sumar(@PathVariable Long id, Model model){


        equipoSolo cc=equipssRep.buscar(id);
        if(cc.getAsociado().getDisponibles()<=0){
            System.out.println("ENTRA AL ERROR antes");
            return "redirect:/alquiler/erroneo/"+cc.getOrden_alquiler().getId();
        }

        cc.setCantidad(cc.getCantidad()+1);
        equipssRep.save(cc);

        equipos ee=equipRep.buscar(cc.getAsociado().getId());
        ee.setDisponibles(ee.getDisponibles()-1);
        equipRep.save(ee);

        model.addAttribute("title","Equipos- Inicio");
        return "redirect:/alquiler/ver/"+cc.getOrden_alquiler().getId();
    }

    @RequestMapping(value = "/menos/{id}", method=RequestMethod.GET)
    public String restar(@PathVariable Long id, Model model){

        equipoSolo cc=equipssRep.buscar(id);
        if((cc.getCantidad()-1)<=0){
            return "redirect:/alquiler/erroneo2/"+cc.getOrden_alquiler().getId();
        }

        cc.setCantidad(cc.getCantidad()-1);
        equipssRep.save(cc);

        equipos ee=equipRep.buscar(cc.getAsociado().getId());
        ee.setDisponibles(ee.getDisponibles()+1);
        equipRep.save(ee);

        model.addAttribute("title","Alquiler- Inicio");
        return "redirect:/alquiler/ver/"+cc.getOrden_alquiler().getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/erroneo/{id}", method=RequestMethod.GET)
    public String errorA(@PathVariable Long id, Model model){

        System.out.println("ENTRA AL ERROR");
        alquiler cc=alquilerRep.buscar(id);
        System.out.println("Esto: "+cc.getCliente().getNombre());

        model.addAttribute("msg1","aumentar");
        model.addAttribute("msg2","Insuficiencia de equipos disponibles para alquilar");
        model.addAttribute("alq",cc);
        model.addAttribute("title","Alquiler- Error");
        return "alquiler_error"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/erroneo2/{id}", method=RequestMethod.GET)
    public String errorB(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);

        model.addAttribute("msg1","disminuir");
        model.addAttribute("msg2","Que la la cantidad seria igual a 0 ");
        model.addAttribute("alq",cc);
        model.addAttribute("title","Alquiler- Error");
        return "alquiler_error"; //TODO: uso de los cambios
    }

    //borrar equipos asociados
    @RequestMapping(value = "/quitar/{id}", method=RequestMethod.GET)
    public String quitar(@PathVariable Long id, Model model){

        equipoSolo cc=equipssRep.buscar(id);
        alquiler also=cc.getOrden_alquiler();

        if((also.getEquipo().size()-1)<=0){
            return "redirect:/alquiler/erroneo3/"+cc.getOrden_alquiler().getId();
        }

        //disminuyendo existencias
        equipos disminuir=cc.getAsociado();
        Long dato=disminuir.getDisponibles()+cc.getCantidad();
        disminuir.setDisponibles(dato);
        equipRep.save(disminuir);

        equipssRep.delete(cc);


        model.addAttribute("title","Equipos- Inicio");
        return "redirect:/alquiler/ver/"+cc.getOrden_alquiler().getId(); //TODO: uso de los cambios
    }

    @RequestMapping(value = "/erroneo3/{id}", method=RequestMethod.GET)
    public String errorC(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);

        model.addAttribute("msg1","borrar");
        model.addAttribute("msg2","Que quedaria un alquier sin equipos ");
        model.addAttribute("alq",cc);
        model.addAttribute("title","Alquiler- Error");
        return "alquiler_error"; //TODO: uso de los cambios
    }

    //agregar equipos asociados
    @RequestMapping(value = "/agregar/{id}", method=RequestMethod.GET)
    public String agregareq(@PathVariable Long id, Model model){

        alquiler cc=alquilerRep.buscar(id);
        Set<equipoSolo> obtenidos=cc.getEquipo(); //equipos obtenidos
        List<equipos> aux=equipRep.findAll();  //total de equipos

        for (equipoSolo es:obtenidos){
            aux.remove(es.getAsociado());
        }

        List<equipos> eq=new ArrayList<>();
        for(equipos e: aux){
            if(e.getDisponibles()>0){
                eq.add(e);
            }
        }

        model.addAttribute("opcion2",eq);
        model.addAttribute("alq",cc);
        model.addAttribute("title","Alquiler- Equipos");
        return "alquiler_equipo"; //TODO: uso de los cambios
    }

    @RequestMapping(value = "/agregar/{id}", method=RequestMethod.POST)
    public String agregareq2(@PathVariable Long id, @RequestParam("opcionequi") List<Long> seleccion, Model model){

        alquiler cc=alquilerRep.buscar(id);

        System.out.println("---LLega aqui----");
        Set<equipos> eq=new HashSet<>();
        if(seleccion!=null){
            for (long e:seleccion){
                equipos ep=equipRep.buscar(e);
                //System.out.println("Nombre seleccion:"+ep.getNombre());
                eq.add(ep);
            }
        }


        Set<equipoSolo> inv=new HashSet<>();
        for(equipos ep: eq){
            equipoSolo ess=new equipoSolo();
            ess.setAsociado(ep);
            ess.setCantidad(1L);
            ess.setOrden_alquiler(cc);
            equipssRep.save(ess);

            //disminuyendo existencias
            equipos disminuir=equipRep.buscar(ep.getId());
            Long dato=disminuir.getDisponibles()-1;
            disminuir.setDisponibles(dato);
            equipRep.save(disminuir);
        }

        model.addAttribute("title","Equipos- Inicio");
        return "redirect:/alquiler/ver/"+cc.getId(); //TODO: uso de los cambios
    }

    public long daysBetween(Date d1, Date d2) {
        return (long) ( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

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
