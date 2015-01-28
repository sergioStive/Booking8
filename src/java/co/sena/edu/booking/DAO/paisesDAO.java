/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import java.sql.Connection;
import co.sena.edu.booking.DTO.paisesDTO;
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
public class paisesDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida; 
    int pais; 
public paisesDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( paisesDTO nacionali) {
try {

    pstmt = cnn.prepareStatement ("UPDATE paises SET Pais=?,Idioma=? WHERE idPais=?; ");
    
    pstmt.setString (1,nacionali.getPais());
    pstmt.setString(2,nacionali.getIdioma());
    pstmt.setString(3,nacionali.getIdPais());
    
    pais = pstmt.executeUpdate();
            if (pais > 0) {
                msgSalida = "se modificaron (" + pais + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;
    }
    public String crearPais(paisesDTO newPais)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO paises VALUES ( ?, ?, ?)");
            pstmt.setString(1, newPais.getIdPais());
            pstmt.setString(2, newPais.getPais());
            pstmt.setString(3, newPais.getIdioma());
           
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario a sido registrado exitosamente. " + resultado + "filas afectadas";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";
                
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(paisesDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<paisesDTO> getAll() throws SQLException {
        LinkedList<paisesDTO> listaPaises = new LinkedList<paisesDTO>();
        try {


            String query = "SELECT  IdPais, pais, idioma"
                    + " FROM paises ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                paisesDTO newPais = new paisesDTO();
                newPais.setIdPais(rs.getString("id"));
                newPais.setPais(rs.getString("pais"));
                newPais.setIdioma(rs.getString("idioma"));
                listaPaises.add(newPais);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaPaises;
}
    public String  ListarUnPais (paisesDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idPais,Pais,idioma from Paises where idPais=?;");
               pstmt.setString(1, Rdao.getIdPais());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdPais(rs.getString("idPais"));
                   Rdao.setPais(rs.getString("Pais"));
                   Rdao.setIdioma(rs.getString("idioma"));
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


       public List <paisesDTO> listarPaises () throws SQLException{
    ArrayList <paisesDTO> listarPaises = new ArrayList ();
    
    try {
        String query = "select idPais, Pais, idioma from paises";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           paisesDTO reser = new paisesDTO();
               reser.setIdPais(rs.getString("idPais"));
                   reser.setPais(rs.getString("Pais"));
                   reser.setIdioma(rs.getString("idioma"));
                   listarPaises.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }
    return listarPaises;
}  
public String eliminar(paisesDTO nacionali) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM paises WHERE idPais= ?; ");           
            pstmt.setString(1, nacionali.getIdPais());
           

            pais = pstmt.executeUpdate();
            if (pais > 0) {
                msgSalida = "se eliminaron (" + pais + ") registros";
            } else {
                msgSalida = "NO se pudo eliminar  el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
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

        return msgSalida;
    }

}



