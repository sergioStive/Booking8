/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.sena.edu.booking.DAO;


import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.lugararrivosDTO;
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
 * @author fabian
 */
public class lugararrivosDAO {
   private Connection cnn = null;
   private PreparedStatement pstmt;
    ResultSet rs = null;
   String msgSalida; 
   int lugar; 
public lugararrivosDAO(){
   cnn = reserConex.getInstance();
   
}
public String actualizarRegistro( lugararrivosDTO lugarArrivo) {
try {
pstmt = cnn.prepareStatement ("UPDATE lugararrivos SET nombrePuerto=? WHERE =IdLugarArrivo?;");

pstmt.setString (1,lugarArrivo.getNombrePuerto());
pstmt.setInt (2,lugarArrivo.getIdLugarArrivo());

lugar = pstmt.executeUpdate();
           if (lugar > 0) {
               msgSalida = "se modificaron (" + lugar + ") registros";
           } else {
               msgSalida = "NO se pudo actualizar el registro";
           }
       } catch (SQLException ex) {
           msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

       }
       return msgSalida;
   }


public String crearLugarArrivo(lugararrivosDTO newLugarArrivo)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO lugararrivos VALUES ( ?, ?)");
            pstmt.setInt(1, newLugarArrivo.getIdLugarArrivo());
            pstmt.setString(2, newLugarArrivo.getNombrePuerto());
          
           
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
                Logger.getLogger(lugararrivosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<lugararrivosDTO> getAll() throws SQLException {
        LinkedList<lugararrivosDTO>listaLugarArrivos = new LinkedList<lugararrivosDTO>();
        try {


            String query = "SELECT  idLugarArrivo as id, nombrepuerto "
                    + " FROM lugararrivos ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
               lugararrivosDTO newlugarArrivo = new lugararrivosDTO();
                newlugarArrivo.setIdLugarArrivo(rs.getInt("id"));
                newlugarArrivo.setNombrePuerto(rs.getString("puerto"));
                
                listaLugarArrivos.add(newlugarArrivo);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaLugarArrivos;
}
    public String  ListarUno (lugararrivosDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idLugarArrivo,nombrePuerto from lugararrivos where idLugarArrivo=?;");
               pstmt.setInt(1, Rdao.getIdLugarArrivo());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdLugarArrivo(rs.getInt("idLugarArrivo"));
                   Rdao.setNombrePuerto(rs.getString("nombrePuerto"));
                   
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


public List <lugararrivosDTO> listarTodos () throws SQLException{
    ArrayList <lugararrivosDTO> listarLugarArrivos = new ArrayList ();
    
    try {
        String query = " select idLugarArrivo, nombrePuerto from lugararrivos";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           lugararrivosDTO reser = new lugararrivosDTO();
               reser.setIdLugarArrivo(rs.getInt("idLugarArrivo"));
                   reser.setNombrePuerto(rs.getString("nombrePuerto"));
                   listarLugarArrivos.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarLugarArrivos;
}  
public String eliminar(lugararrivosDTO lugarArrivo) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM lugararrivos WHERE idLugarArrivo = ?; ");           
            pstmt.setInt(1, lugarArrivo.getIdLugarArrivo());
           

            lugar = pstmt.executeUpdate();
            if (lugar > 0) {
                msgSalida = "se eliminaron (" + lugar + ") registros";
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
