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
public class paisesDTO {
    
    private String idPais;
    private String Pais;
    private String idioma;

    /**
     * @return the idPais
     */
    public String getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    /**
     * @return the Pais
     */
    public String getPais() {
        return Pais;
    }

    /**
     * @param Pais the Pais to set
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    /**
     * @return the Idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param Idioma the Idioma to set
     */
    public void setIdioma(String Idioma) {
        this.idioma = Idioma;
    }

    @Override
    public String toString() {
        return "\nidPais " + this.idPais
                + "\npais " + this.Pais
                + "\nIdioma " + this.idioma;
    }
}
