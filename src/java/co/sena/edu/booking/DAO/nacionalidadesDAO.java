/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import java.sql.Connection;
import co.sena.edu.booking.DTO.nacionalidadesDTO;
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
public class nacionalidadesDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida; 
    int nacio; 
public nacionalidadesDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( nacionalidadesDTO nacionali) {
try {

pstmt = cnn.prepareStatement ("UPDATE nacionalidades SET Nacionalidad=? WHERE idNacionalidad=?;");

pstmt.setString (1, nacionali.getNacionalidad());
pstmt.setInt (2,nacionali.getIdNacionalidad());


nacio = pstmt.executeUpdate();
            if (nacio > 0) {
                msgSalida = "se modificaron (" + nacio + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;
    }

public String crearNacionalidad(nacionalidadesDTO newNacionalidad)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO nacionalidades VALUES ( ?, ?)");
            pstmt.setInt(1, newNacionalidad.getIdNacionalidad());
            pstmt.setString(2, newNacionalidad.getNacionalidad());
           
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
                Logger.getLogger(nacionalidadesDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<nacionalidadesDTO> getAll() throws SQLException {
        LinkedList<nacionalidadesDTO> listaNacionalidades = new LinkedList<nacionalidadesDTO>();
        try {


            String query = "SELECT  idNacionalidad, nacionalidad"
                    + " FROM nacionalidades ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                nacionalidadesDTO newNacionalidad = new nacionalidadesDTO();
                newNacionalidad.setIdNacionalidad(rs.getInt("id"));
                newNacionalidad.setNacionalidad(rs.getString("nacionalidad"));
                
                listaNacionalidades.add(newNacionalidad);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaNacionalidades;
}
    public String  ListarUnaNacionalidad (nacionalidadesDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idNacionalidad, nacionalidad from nacionalidades where idNacionalidad=?;");
               pstmt.setInt(1, Rdao.getIdNacionalidad());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdNacionalidad(rs.getInt("idNacionalidad"));
                   Rdao.setNacionalidad(rs.getString("nacionalidad"));
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }

public List <nacionalidadesDTO> listarNacionalidades () throws SQLException{
    ArrayList <nacionalidadesDTO> listarNacionalidades = new ArrayList ();
    
    try {
        String query = "select idNacionalidad, nacionalidad from nacionalidades";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           nacionalidadesDTO reser = new nacionalidadesDTO();
           reser.setIdNacionalidad(rs.getInt("idNacionalidad"));
           reser.setNacionalidad(rs.getString("nacionalidad"));
           listarNacionalidades.add(reser);
                   
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarNacionalidades;
}  
public String eliminar(nacionalidadesDTO nacionali) {
        try {
            
            pstmt = cnn.prepareStatement("DELETE FROM nacionalidades WHERE idNacionalidad = ?; ");           
            pstmt.setInt(1, nacionali.getIdNacionalidad());
           

            nacio = pstmt.executeUpdate();
            if (nacio > 0) {
                msgSalida = "se eliminaron (" + nacio + ") registros";
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






