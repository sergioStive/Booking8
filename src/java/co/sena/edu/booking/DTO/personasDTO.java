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
public class personasDTO {
   
    private long idPersona;
    private String correoElectronico;
    private String pais;
    private int idNacionalidad;
    private String nombres;
    private String apellidos;
    private String fechaNto;
    private int telefono;
    private int contraseña;

  


    @Override
    public String toString() {
        return "\nidPersona " + this.getIdPersona()
                + "\ncorreo " + this.getCorreoElectronico()
                + "\nresidencia " + this.getPais()
                + "\nidnacionalidad " + this.getIdNacionalidad()
                + "\nnombres " + this.getNombres()
                + "\napellidos " + this.getApellidos()
                + "\nfechaNto " + this.getFechaNto()
                + "\ntelefono " + this.getTelefono()
                + "\ncontraseña " + this.getContraseña();
                }

    /**
     * @return the idPersona
     */
    public long getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
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
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the fechaNto
     */
    public String getFechaNto() {
        return fechaNto;
    }

    /**
     * @param fechaNto the fechaNto to set
     */
    public void setFechaNto(String fechaNto) {
        this.fechaNto = fechaNto;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the contraseña
     */
    public int getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

}