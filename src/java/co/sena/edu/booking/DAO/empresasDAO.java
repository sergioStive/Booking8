/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.conductoresDTO;
import co.sena.edu.booking.DTO.empresasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomoko
 */
public class empresasDAO {
    private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    String mgSalida; 
    int empresa;
    
     public empresasDAO  () {
        cnn = reserConex.getInstance();
        
    }
  public String actualizarRegistro( empresasDTO empres) {

        try {
  
      pstm = cnn.prepareStatement("UPDATE empresas SET nombreEmpresa =?, "
              + "ubicacion=?, direccion=? ,telefono=?, "
              + "representante=?, =correoEmpresa=? WHERE idEmpresa=?;");
  
        pstm.setString(1,empres.getNombreEmpresa());
        pstm.setString(2,empres.getUbicacion());
        pstm.setString(3,empres.getDireccion());
        pstm.setString(4,empres.getTelefono());
        pstm.setString(5,empres.getRepresentante());
        pstm.setString(6,empres.getCorreoEmpresa());
        pstm.setString(7,empres.getIdEmpresa());
        
        empresa = pstm.executeUpdate();
            if (empresa >0) {
                 mgSalida = "se modificaron (" + empresa + ") registros";
            } else {
               mgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
//        
        }
        return mgSalida;
      
        }
  public String crearEmpresa(empresasDTO newEmpresa)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO empresas VALUES ( ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, newEmpresa.getIdEmpresa());
            pstm.setString(2, newEmpresa.getNombreEmpresa());
            pstm.setString(3, newEmpresa.getUbicacion());
            pstm.setString(4, newEmpresa.getDireccion());
            pstm.setString(5, newEmpresa.getTelefono());
            pstm.setString(6, newEmpresa.getRepresentante());
            pstm.setString(7, newEmpresa.getCorreoEmpresa());
           
            resultado = pstm.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario a sido registrado exitosamente. " + resultado + "filas afectadas";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";
                
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(empresasDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<empresasDTO> getAll() throws SQLException {
        LinkedList<empresasDTO> listaEmpresas = new LinkedList<empresasDTO>();
        try {


            String query = "SELECT  idEmpresa, nombreEmpresa, ubicacion, direccion, telefono, representante, correoEmpresa "
                    + " FROM empresas ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                empresasDTO newEmpresa = new empresasDTO();
                newEmpresa.setIdEmpresa(rs.getString("id"));
                newEmpresa.setNombreEmpresa(rs.getString("nombre"));
                newEmpresa.setUbicacion(rs.getString("ubicacion"));
                newEmpresa.setDireccion(rs.getString("direccion"));
                newEmpresa.setTelefono(rs.getString("telefono"));
                newEmpresa.setRepresentante(rs.getString("representante"));
                newEmpresa.setCorreoEmpresa(rs.getString("correo"));
                listaEmpresas.add(newEmpresa);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaEmpresas;
}
    public List <empresasDTO> listarEmpresas () throws SQLException{
    ArrayList <empresasDTO> listarEmpresas = new ArrayList ();
    
    try {
        String query = "select idEmpresa,nombreEmpresa,ubicacion,direccion,telefono,representante,correoEmpresa from empresas";  
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
                   empresasDTO em = new empresasDTO();
                   em.setIdEmpresa(rs.getString("idEmpresa"));
                   em.setNombreEmpresa(rs.getString("nombreEmpresa"));
                   em.setUbicacion(rs.getString("ubicacion"));
                   em.setDireccion(rs.getString("direccion"));
                   em.setTelefono(rs.getString("telefono"));
                   em.setRepresentante(rs.getString("representante"));
                   em.setCorreoEmpresa(rs.getString("correoEmpresa"));
                   
           listarEmpresas.add(em);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }
    return listarEmpresas;

}

public String  ListarUno (empresasDTO em) throws SQLException{
           try  {
               pstm = cnn.prepareStatement(" select idEmpresa, nombreEmpresa,ubicacion, direccion, telefono,"
               +"representante, correoEmpresa from empresas where idEmpresa=?;");
               pstm.setString(1, em.getIdEmpresa());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
               
               while(rs.next()){
                   em.setIdEmpresa(rs.getString("idEmpresa"));
                   em.setNombreEmpresa(rs.getString("nombreEmpresa"));
                   em.setUbicacion(rs.getString("ubicacion"));
                   em.setDireccion(rs.getString("direccion"));
                   em.setTelefono(rs.getString("telefono"));
                   em.setRepresentante(rs.getString("representante"));
                   em.setCorreoEmpresa(rs.getString("correoEmpresa"));
                  
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + em;
       }
       public String eliminar(empresasDTO empres) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstm = cnn.prepareStatement("DELETE FROM empresas WHERE idEmpresa = ?; ");
            //pstmt= cnn.prepareStatement("UPDATE usuarios SET id_perfil=?, nombres=?, apellidos=?, usuario=? clave = MD5(?) WHERE id_usuario = ?; ");           
            pstm.setString(1, empres.getIdEmpresa());
           

            empresa = pstm.executeUpdate();
            if (empresa > 0) {
                mgSalida = "se eliminaron (" + empresa + ") registros";
            } else {
                mgSalida = "NO se pudo eliminar  el registro";
            }
        } catch (SQLException ex) {
            mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
//        } finally {
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//                if (cnn != null) {
//                    cnn.close();
//                }
//            } catch (SQLException ex) {
//                msgSalida = "error al cerrar la conexion " + ex.getMessage();
//            }
        }

        return mgSalida;
    }

   


}
  


  

