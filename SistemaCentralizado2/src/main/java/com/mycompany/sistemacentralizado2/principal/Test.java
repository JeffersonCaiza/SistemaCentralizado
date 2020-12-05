/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemacentralizado2.principal;

import com.mycompany.sistemacentralizado2.controladores.ProductoJpaController;
import com.mycompany.sistemacentralizado2.entidades.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xtratech
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        // LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXIÓN
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        
         //CREAMOS UN NUEVO PRODUCTO
        Producto p = new Producto(1);

        p.setNombre("VINO");
        p.setPrecio(50);
        
         try {
            pjc.create(p);  
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
                
    }
    
}
