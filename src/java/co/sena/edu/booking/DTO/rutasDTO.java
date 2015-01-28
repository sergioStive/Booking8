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
public class rutasDTO {
    private int idRuta=0;
    private String placaVehiculo="";
    private int idtipoVehiculo=0;
    private int idEstadoRuta=0;
    private String idConductor="";
    private String idPersona="";
    private int idreserva=0;   
  
    @Override
    public String toString(){
    return "\nidRuta "+this.idRuta
            +"\nplacaVehiculo "+this.placaVehiculo
            +"\nidtipoVehiculo "+this.idtipoVehiculo
            +"\nidEstadoRuta "+this.idEstadoRuta
            +"\nidConductor "+this.idConductor
            +"\nidpersona "+this.idPersona                
            +"\nidConductor "+this.idreserva;
        
         
          
}
    /**
     * @return the idRuta
     */
    public int getIdRuta() {
        return idRuta;
    }

    /**
     * @param idRuta the idRuta to set
     */
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    /**
     * @return the placaVehiculo
     */
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    /**
     * @param placaVehiculo the placaVehiculo to set
     */
    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    /**
     * @return the Reserva_idReserva
     */
    public int getidReserva() {
        return idreserva;
    }

    /**
     * @param idReserva the Reserva_idReserva to set
     */
    public void setidReserva(int idReserva) {
        this.idreserva = idReserva;
    }

    /**
     * @return the idConductor
     */
    public String getIdConductor() {
        return idConductor;
    }

    /**
     * @param idConductor the idConductor to set
     */
    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    /**
     * @return the idtipoVehiculo
     */
    public int getIdtipoVehiculo() {
        return idtipoVehiculo;
    }

    /**
     * @param idtipoVehiculo the idtipoVehiculo to set
     */
    public void setIdtipoVehiculo(int idtipoVehiculo) {
        this.idtipoVehiculo = idtipoVehiculo;
    }

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
   

}
