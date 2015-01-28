/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.paisesDTO;
import co.sena.edu.booking.DTO.servespecialesDTO;
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
public class servespecialesDAO {
     private Connection cnn = null;
    private PreparedStatement pstmt;
     ResultSet rs = null;
     String msgSalida; 
    int servi; 
public servespecialesDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( servespecialesDTO ser) {
try {
pstmt = cnn.prepareStatement("UPDATE servespeciales SET servespecial=? WHERE idServEspecial=?;");

pstmt.setString(1,ser.getServespecial());
pstmt.setInt(2,ser.getIdServEspecial());

servi = pstmt.executeUpdate();
            if (servi > 0) {
                msgSalida = "se modificaron (" + servi + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;

 }
 public String crearServEspecial(servespecialesDTO newSevcioEs)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO servespeciales VALUES ( ?, ?)");
            pstmt.setInt(1, newSevcioEs.getIdServEspecial());
            pstmt.setString(2, newSevcioEs.getServespecial());
           
           
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
                Logger.getLogger(servespecialesDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<servespecialesDTO> getAll() throws SQLException {
        LinkedList<servespecialesDTO> listaServiciosEs = new LinkedList<servespecialesDTO>();
        try {


            String query = "SELECT  IdServEspecial, servespecial"
                    + " FROM servespeciales ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                servespecialesDTO newSevcioEs = new servespecialesDTO();
                newSevcioEs.setIdServEspecial(rs.getInt("id"));
                newSevcioEs.setServespecial(rs.getString("servicio"));
               
               listaServiciosEs.add(newSevcioEs);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return  listaServiciosEs;
}
        public String  ListarUnServicio (servespecialesDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idServEspecial, servEspecial from servespeciales where idServEspecial=?;");
               pstmt.setInt(1, Rdao.getIdServEspecial());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdServEspecial(rs.getInt("idServEspecial"));
                   Rdao.setServespecial(rs.getString("servEspecial"));
             
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


       public List <servespecialesDTO> listarServicios () throws SQLException{
    ArrayList <servespecialesDTO> listarServicios = new ArrayList ();
    
    try {
        String query = "select idServEspecial, servEspecial  from servespeciales";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           servespecialesDTO reser = new servespecialesDTO();
           reser.setIdServEspecial(rs.getInt("idServEspecial"));
           reser.setServespecial(rs.getString("servEspecial"));
           listarServicios.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }
    return listarServicios;
}
       public String eliminar(servespecialesDTO serv) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM servespeciales WHERE idServEspecial = ?; ");           
            pstmt.setInt(1, serv.getIdServEspecial());
           

            servi = pstmt.executeUpdate();
            if (servi > 0) {
                msgSalida = "se eliminaron (" + servi + ") registros";
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


