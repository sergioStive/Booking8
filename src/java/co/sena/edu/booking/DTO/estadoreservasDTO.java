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
public class estadoreservasDTO {
   
    private int idEstadoReserva;
    private String estadoReserva;

    /**
     * @return the idestadoReserva
     */
    public int getIdestadoReserva() {
        return idEstadoReserva;
    }

    /**
     * @param idestadoReserva the idestadoReserva to set
     */
    public void setIdestadoReserva(int idestadoReserva) {
        this.idEstadoReserva = idestadoReserva;
    }

    /**
     * @return the estadoReserva
     */
    public String getEstadoReserva() {
        return estadoReserva;
    }

    /**
     * @param estadoReserva the estadoReserva to set
     */
    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    @Override
    public String toString() {
        return "\nidestadoReserva " + this.idEstadoReserva
                + "\nestadoReserva " + this.estadoReserva;
    }
}


