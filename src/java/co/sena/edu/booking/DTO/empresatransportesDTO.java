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
public class empresatransportesDTO {

    private String idEmpresaTransporte;
    private String nombreEmpresaTransporte;

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

    /**
     * @return the nombreEmpresaTransporte
     */
    public String getNombreEmpresaTransporte() {
        return nombreEmpresaTransporte;
    }

    /**
     * @param nombreEmpresaTransporte the nombreEmpresaTransporte to set
     */
    public void setNombreEmpresaTransporte(String nombreEmpresaTransporte) {
        this.nombreEmpresaTransporte = nombreEmpresaTransporte;
    }

    @Override
    public String toString() {
        return "\nidEmpresaTransporte " + this.idEmpresaTransporte
                + "\nnombreEmpresaTransporte " + this.nombreEmpresaTransporte;
    }
}


