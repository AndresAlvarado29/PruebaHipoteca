/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Banco;
import ec.edu.ups.modelo.Casa;

/**
 *
 * @author Andres
 */
public class ControladorBanco extends AbstractControlador<Banco>{
  @Override
    public boolean validar(Banco objeto) {
        return true;
            }
       
}
