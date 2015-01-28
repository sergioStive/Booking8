/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DTO;

/**
 *
 * @author Tomoko
 */
public class tipovehiculosDTO {
 private  int  idTipoVehiculo;    
 private  String  tipoVehiculo;
 private  int  modelo;
 private  String  marca;


 @Override
 public String toString(){
 
    return "\n idTipoVehiculo"+this.getIdTipoVehiculo()
            +"\n tipoVehiculo"+this.getTipoVehiculo()
            +"\n modelo"+this.getModelo()
            +"\n marca"+this.getMarca();
 }

    /**
     * @return the idTipoVehiculo
     */
    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    /**
     * @param idTipoVehiculo the idTipoVehiculo to set
     */
    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    /**
     * @return the tipoVehiculo
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * @param tipoVehiculo the tipoVehiculo to set
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * @return the modelo
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

}
