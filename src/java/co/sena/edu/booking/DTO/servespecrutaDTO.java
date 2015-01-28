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
public class servespecrutaDTO {
 private String idservespxrutas="";
 private int idReserva=0;
 private int idServEspecial=0;
 private String despcripcion="";
 private int cantidad=0;

    /**
     * @return the idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * @return the idServEspecial
     */
    public int getIdServEspecial() {
        return idServEspecial;
    }

    /**
     * @param idServEspecial the idServEspecial to set
     */
    public void setIdServEspecial(int idServEspecial) {
        this.idServEspecial = idServEspecial;
    }

    /**
     * @return the despcripcion
     */
    public String getDespcripcion() {
        return despcripcion;
    }

    /**
     * @param despcripcion the despcripcion to set
     */
    public void setDespcripcion(String despcripcion) {
        this.despcripcion = despcripcion;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 @Override
 public String toString(){
    return "\nidservespxrutas "+this.idservespxrutas
            +"\nidReserva "+this.idReserva
            +"\nidServEspecial "+this.idServEspecial
            +"\ndespcripcion "+this.despcripcion
            +"\ncantidad "+this.cantidad;
}

    /**
     * @return the idservespxrutas
     */
    public String getIdservespxrutas() {
        return idservespxrutas;
    }

    /**
     * @param idservespxrutas the idservespxrutas to set
     */
    public void setIdservespxrutas(String idservespxrutas) {
        this.idservespxrutas = idservespxrutas;
    }

}
