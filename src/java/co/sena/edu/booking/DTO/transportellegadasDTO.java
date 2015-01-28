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
public class transportellegadasDTO {
private String idTransporteLlegada;
private String horaArrivo;
private String horaSalida;
private int idLugarArrivo;
private String idEmpresaTransporte;

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
     * @return the horaArrivo
     */
    public String getHoraArrivo() {
        return horaArrivo;
    }

    /**
     * @param horaArrivo the horaArrivo to set
     */
    public void setHoraArrivo(String horaArrivo) {
        this.horaArrivo = horaArrivo;
    }

    /**
     * @return the horaSalida
     */
    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * @return the idLugarArrivo
     */
    public int getIdLugarArrivo() {
        return idLugarArrivo;
    }

    /**
     * @param idLugarArrivo the idLugarArrivo to set
     */
    public void setIdLugarArrivo(int idLugarArrivo) {
        this.idLugarArrivo = idLugarArrivo;
    }

    /**
     * @return the idEmpresaTransporte
     */
    public String getIdEmpresaTransporte() {
        return idEmpresaTransporte;
    }

    /**
     * @param idEmpresaTransporte the idEmpresaTransporte to set
     */
    public void setIdEmpresaTransporte(String idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }
@Override
public String toString(){
     return"\nidTransporteLlegada"+this.idTransporteLlegada
             +"\nhoraArrivo"+this.horaArrivo
             + "\nhoraSalida"+this.horaSalida
             +"\nidLugarArrivo"+this.idLugarArrivo
             +"\nidTransporteLlegada"+this.idTransporteLlegada;
 }


}
