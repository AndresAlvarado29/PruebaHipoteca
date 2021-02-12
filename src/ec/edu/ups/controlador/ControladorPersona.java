/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.exception.MiExcepcion;
import ec.edu.ups.modelo.Persona;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
public class ControladorPersona extends AbstractControlador<Persona> {

    public boolean validar(Persona objeto) throws MiExcepcion {
        String cedula = objeto.getCedula();
        int c;
        int suma = 0;
        int contador;
        int resta = 0;
        boolean bandera = false;
        if(cedula.length() != 10){
        
            throw new MiExcepcion("La cedula debe tener 10 digitos ");
        }
        
        for(int i = 0; i < cedula.length(); i++){
            
            if(!(cedula.charAt(i) == '0'||cedula.charAt(i) == '1'||cedula.charAt(i) == '2'||cedula.charAt(i) == '3'||
               cedula.charAt(i) == '4'||cedula.charAt(i) == '5'||cedula.charAt(i) == '6'||cedula.charAt(i) == '7'||cedula.charAt(i) == '8'||
               cedula.charAt(i) == '9')){
                
                throw new MiExcepcion("La cedula solo debe tener numeros");
            } 
            
        }
        

        int h=cedula.length();
        for (int i = 0; i < h - 1; i++) {
            System.out.println(h);
            c = Integer.parseInt(cedula.charAt(i) + "");
            if (i % 2 == 0) {
                c = c * 2;
                if (c > 9) {
                    c = c - 9;
                    
                }

            }
            suma = suma + c;
        }
        if (suma % 10 != 0) {
            contador = ((suma / 10) + 1) * 10;
            resta = contador - suma;
        }
        int ultimo = Integer.parseInt(cedula.charAt(9) + "");
        if (ultimo == resta) {
            System.out.println("la cedula ingresada es correcta");
            
        } else {
            throw new MiExcepcion("la cedula es incorrecta");

        }

        return bandera;     
    }

    public Boolean consultaPersona(String cedula){
        if (cedula!=null) {
         Query consulta = getEm().createNamedQuery("consultaCedula");
    consulta.setParameter("cedula", cedula);
    consulta.getSingleResult();
    return true;    
        }
   return false;
    }
    public Boolean consultaPersonaN(String nombre){
        if (nombre!=null) {
        Query consulta = getEm().createNamedQuery("consultaNombre");
    consulta.setParameter("nombre", nombre);
    consulta.getSingleResult();
    return true;    
        }
       return false;
    }
   
    
}

   
        
    
