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
public class estadousuariosDTO {
  
    private int idEstadoUsuario;
    private String estado;

    /**
     * @return the idEstadoUsuario
     */
    public int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    /**
     * @param idEstadoUsuario the idEstadoUsuario to set
     */
    public void setIdEstadoUsuario(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
    return "\nidEstadoUsuario "+this.idEstadoUsuario
            +"\nestado "+this.estado;
    }
}
