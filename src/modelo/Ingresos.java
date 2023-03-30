/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class Ingresos {
    private int idIngreso;
    private String fechaIngreso;
    private ArrayList<Moto> motos; //RELACION N - 1
    private ArrayList<Cliente> clientes; //RELACION N - 1

    public Ingresos(){
        this.motos = new ArrayList<Moto>();
        this.clientes = new ArrayList<Cliente>();
    }
    
    public Ingresos(int idIngreso, String fechaIngreso) {
        this.idIngreso = idIngreso;
        this.fechaIngreso = fechaIngreso;
        this.motos = new ArrayList<Moto>();
        this.clientes = new ArrayList<Cliente>();
    }
    
    public Ingresos(int idIngreso, String fechaIngreso, ArrayList<Moto> motos, ArrayList<Cliente> clientes) {
        this.idIngreso = idIngreso;
        this.fechaIngreso = fechaIngreso;
        this.motos = motos;
        this.clientes = clientes;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(ArrayList<Moto> motos) {
        this.motos = motos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void ingresarCliente(Cliente cliente){
        if(cliente != null){
            this.clientes.add(cliente);
        }
    }
    
    public void ingresarMoto(Moto moto){
        if(moto != null){
            this.motos.add(moto);
        }
    }
    
}
