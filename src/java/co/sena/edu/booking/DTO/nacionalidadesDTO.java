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
public class nacionalidadesDTO {
    
    private int idNacionalidad;
    private String nacionalidad;

    /**
     * @return the idNacionalidad
     */
    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    /**
     * @param idNacionalidad the idNacionalidad to set
     */
    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    /**
     * @return the Nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param Nacionalidad the Nacionalidad to set
     */
    public void setNacionalidad(String Nacionalidad) {
        this.nacionalidad = Nacionalidad;
    }

    @Override
    public String toString() {
        return "\nidNacionalidad " + this.idNacionalidad
                + "\nNacionalidad " + this.nacionalidad;
    }
}
