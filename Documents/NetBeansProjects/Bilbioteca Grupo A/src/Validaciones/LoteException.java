/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Lote;

/**
 *
 * @author DAM102
 */
public class LoteException extends Exception{
    
       public LoteException(String msj){
        super(msj);
    }
    
        public static boolean validarLote(Lote lote) {
        return validarLoteId(lote.getId()) && validarLoteIdProveedor(lote.getIdProveedor());
    }
       
       
    public static boolean validarLoteId(long id) {

        return id > 0;
    }
    
    public static boolean validarLoteIdProveedor(long idProveedor) {

        return idProveedor > 0;
    }
    
    
}
