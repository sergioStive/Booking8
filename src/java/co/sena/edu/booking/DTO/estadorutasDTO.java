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
public class estadorutasDTO {
    
    private int idEstadoRuta;
    private String estadoRuta;

    /**
     * @return the idEstadoRuta
     */
    public int getIdEstadoRuta() {
        return idEstadoRuta;
    }

    /**
     * @param idEstadoRuta the idEstadoRuta to set
     */
    public void setIdEstadoRuta(int idEstadoRuta) {
        this.idEstadoRuta = idEstadoRuta;
    }

    /**
     * @return the EstadoRuta
     */
    public String getEstadoRuta() {
        return estadoRuta;
    }

    /**
     * @param EstadoRuta the EstadoRuta to set
     */
    public void setEstadoRuta(String EstadoRuta) {
        this.estadoRuta = EstadoRuta;
    }

    @Override
    public String toString() {
     return "\nidEstadoRuta "+this.idEstadoRuta
             + "\nEstadoRuta "+this.estadoRuta;
    }
}
