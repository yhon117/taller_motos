/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jhonb
 */
public class TipoRol {
    private int idTipo;
    private String nombrePerfil;
    
    public TipoRol(){
        
    }

    public TipoRol(int idTipo, String nombrePerfil) {
        this.idTipo = idTipo;
        this.nombrePerfil = nombrePerfil;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    
    public String toString(){
        return this.nombrePerfil;
    }
}
