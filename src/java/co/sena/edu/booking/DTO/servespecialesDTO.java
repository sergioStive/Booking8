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
public class servespecialesDTO {
    private int idServEspecial=0;
    private String servespecial="";

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
     * @return the servespecial
     */
    public String getServespecial() {
        return servespecial;
    }

    /**
     * @param servespecial the servespecial to set
     */
    public void setServespecial(String servespecial) {
        this.servespecial = servespecial;
    }
    @Override
    public String toString (){
    return "\nidServEspecial "+this.idServEspecial
            +"\nservespecial "+this.servespecial;
 }
}
