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
public class conductoresDTO {
    private int idConductor;
    private int idpersona;
    private int telContacto;
  
 
   
    

   
    @Override
 public String toString(){
     return  "\nidConductor "+this.getIdConductor()
              + "\nidpersona "+this.getIdpersona()
              +"\ntelefonoContacto "+this.getTelContacto();
             
              
 }   

    /**
     * @return the telContacto
     */
    public int getTelContacto() {
        return telContacto;
    }

    /**
     * @param telContacto the telContacto to set
     */
    public void setTelContacto(int telContacto) {
        this.telContacto = telContacto;
    }

    /**
     * @return the idpersona
     */
    public int getIdpersona() {
        return idpersona;
    }

    /**
     * @param idpersona the idpersona to set
     */
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    /**
     * @return the idConductor
     */
    public int getIdConductor() {
        return idConductor;
    }

    /**
     * @param idConductor the idConductor to set
     */
    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

}
