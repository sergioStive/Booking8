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
public class empresasDTO {
    private String idEmpresa;
    private String nombreEmpresa;
    private String ubicacion;
    private String direccion;
    private String telefono;
    private String representante;
    private String correoEmpresa;

  

public String toString(){
  return   "\nidEmpresa "+this.getIdEmpresa()
          +"\nnombreEmpresa "+this.getNombreEmpresa()
          +"\nlugarUbicacion " + this.getUbicacion()
          +"\ndireccion "+this.getDireccion()
          +"\ntelefono "+this.getTelefono()
          +"\nrepresentante "+this.getRepresentante()
          +"\ncorreoEmpresa "+this.getCorreoEmpresa();
  }

    /**
     * @return the idEmpresa
     */
    public String getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the representante
     */
    public String getRepresentante() {
        return representante;
    }

    /**
     * @param representante the representante to set
     */
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    /**
     * @return the correoEmpresa
     */
    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    /**
     * @param correoEmpresa the correoEmpresa to set
     */
    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }
}
