package com.example.spring_boot;

import com.example.spring_boot.repositorios.*;
import com.example.spring_boot.entidades.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        /*String[] lista = applicationContext.getBeanDefinitionNames();
        System.out.println("====== Beans Registrados =====");
        for(String bean : lista){
            System.out.println(""+bean);
        }
        System.out.println("====== FIN Beans Registrados =====");
        */

        ClientesRepositorio clientRep = (ClientesRepositorio) applicationContext.getBean("clientesRepositorio");

        /*Long l=123L;
        Date today = Calendar.getInstance().getTime();
        clientes c=new clientes();
        c.setBirth_date(today);
        c.setCedula(l);
        c.setGenero("Masculino");
        c.setNombre("Pedro");
        c.setBirth_place("Santiago");
        clientRep.save(c);*/




        List<clientes> client= clientRep.findAll();
        System.out.println(" ----CLIENTES---");
        for (clientes cc:client){
            System.out.println("NOMBRE:"+cc.getNombre()+" ID:"+cc.getId()+" NACIMIENTO: "+ cc.getBirth_date()+" CEDULA:"+ cc.getCedula()+" LUGAR: "+cc.getBirth_place());
        }

        //Long id= 1L;
        //clientes ac=clientRep.buscar(id);

        //System.out.println("NOMBRE:"+ac.getNombre()+" ID:"+ac.getId());

        //c.setNombre("Missing");

        //clientRep.save(c);




    }
}
