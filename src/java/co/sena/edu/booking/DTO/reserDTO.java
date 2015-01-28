/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DTO;



/**
 *
 * @author Aprendiz
 */
public class reserDTO {

    private int idReserva;
    private int idEstadoReserva;
    private int idServicio;
    private String idTransporteLlegada;
    private String responsable;    
    private String fechaReserva;
    private String horaReserva;
    private String direccionDestino;

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
     * @return the idEstadoReserva
     */
    public int getIdEstadoReserva() {
        return idEstadoReserva;
    }

    /**
     * @param idEstadoReserva the idEstadoReserva to set
     */
    public void setIdEstadoReserva(int idEstadoReserva) {
        this.idEstadoReserva = idEstadoReserva;
    }

    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @return the idTransporteLlegada
     */
    public String getIdTransporteLlegada() {
        return idTransporteLlegada;
    }

    /**
     * @param idTransporteLlegada the idTransporteLlegada to set
     */
    public void setIdTransporteLlegada(String idTransporteLlegada) {
        this.idTransporteLlegada = idTransporteLlegada;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    } 

    /**
     * @return the fechaReserva
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @return the horaReserva
     */
    public String getHoraReserva() {
        return horaReserva;
    }

    /**
     * @param horaReserva the horaReserva to set
     */
    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    /**
     * @return the direccionDestino
     */
    public String getDireccionDestino() {
        return direccionDestino;
    }

    /**
     * @param direccionDestino the direccionDestino to set
     */
    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    @Override
    public String toString() {
        return "idReserva " + idReserva 
                + "\nidEstadoReserva " + idEstadoReserva
                + "\nServicio " + idServicio
                + "\nTransporteLlegada " + idTransporteLlegada 
                + "\nreponsa\"ble " + responsable               
                + "\nFechareserva " + fechaReserva
                + "\nhoraReserva " + horaReserva
                + "\ndireccionDestino " + direccionDestino;
    }

}
