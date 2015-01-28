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
public class lugararrivosDTO {
    
    private int idLugarArrivo;
    private String nombrePuerto;

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
     * @return the nombrePuerto
     */
    public String getNombrePuerto() {
        return nombrePuerto;
    }

    /**
     * @param nombrePuerto the nombrePuerto to set
     */
    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    @Override
    public String toString() {
    return "\nidLugarArrivo "+this.idLugarArrivo
            +"\nnombrePuerto "+this.nombrePuerto;
    }
}
