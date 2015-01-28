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
public class ciudadesDTO {
    
    private String idCiudad;
    private String Ciudad;
    private String idPais;

    /**
     * @return the idCiudad
     */
    public String getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the Ciudad
     */
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * @param Ciudad the Ciudad to set
     */
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    /**
     * @return the Pais_idPais
     */
    public String getidPais() {
        return idPais;
    }

    /**
     * @param idPais the Pais_idPais to set
     */
    public void setidPais(String idPais) {
        this.idPais = idPais;
    }
    @Override
 public String toString (){
     return "idCiudad  "+this.idCiudad
             +"\nCiudad "+this.Ciudad
             +"\nidPais "+ this.idPais;
 }
}
