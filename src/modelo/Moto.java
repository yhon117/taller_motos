/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mauricio
 */
public class Moto{
    private int idMoto;
    private String placa;
    private String marca;
    private String modelo;
    private String kilometraje;
    private String numeroChasis;
    private int idCliente;    

    public Moto(){
        
    }
    public Moto(int idMoto, String placa, String marca, String modelo, String kilometraje, String numeroChasis,int idCliente) {
        this.idMoto = idMoto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.numeroChasis = numeroChasis;
        this.idCliente=idCliente;
    }

    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    

    
    
    
    public String toString(){
        return this.placa;
    }
}
