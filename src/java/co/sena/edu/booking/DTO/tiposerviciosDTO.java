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
public class tiposerviciosDTO {
    private  int idTipoServicio;
    private String TipoServicio;

    /**
     * @return the idTipoServicio
     */
    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    /**
     * @param idTipoServicio the idTipoServicio to set
     */
    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    /**
     * @return the TipoServicio
     */
    public String getTipoServicio() {
        return TipoServicio;
    }

    /**
     * @param TipoServicio the TipoServicio to set
     */
    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
    }
    @Override
    public String toString (){
    return "\nidTipoServicio"+this.idTipoServicio
            +"\nTipoServicio"+this.TipoServicio;
}


}
