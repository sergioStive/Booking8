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
public class personaxreservasDTO {
    private String idPersonaXReservas="";
    private int idReserva=0;
    private  int nroMaletas=0;
    private String idPersona="";

    
    @Override
    public String toString (){
    return "\nidpersonaxReserva "+this.getIdPersonaXReservas()
            +"\nidReserva "+this.getIdReserva()
            +"\nnroMaletas "+this.getNroMaletas()
            +"\nidPersona "+this.getIdPersona();
}

    
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
     * @return the nroMaletas
     */
    public int getNroMaletas() {
        return nroMaletas;
    }

    /**
     * @param nroMaletas the nroMaletas to set
     */
    public void setNroMaletas(int nroMaletas) {
        this.nroMaletas = nroMaletas;
    }

    /**
     * @return the idPersona
     */
    public String getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the idPersonaXReservas
     */
    public String getIdPersonaXReservas() {
        return idPersonaXReservas;
    }

    /**
     * @param idPersonaXReservas the idPersonaXReservas to set
     */
    public void setIdPersonaXReservas(String idPersonaXReservas) {
        this.idPersonaXReservas = idPersonaXReservas;
    }

}
