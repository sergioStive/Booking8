/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.ciudadesDTO;
import co.sena.edu.booking.DTO.serviciosDTO;
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
public class serviciosDAO {
    
   private Connection cnn = null;
   private PreparedStatement pstmt;
   ResultSet rs = null; 
   String msgSalida; 
   int servici; 
public serviciosDAO(){
   cnn = reserConex.getInstance();
   
}
public String actualizarRegistro( serviciosDTO servi) {
try {

pstmt = cnn.prepareStatement("UPDATE servicios SET idTipoServicio=?, "
       + "servicio=? WHERE idServicio=?;");

pstmt.setInt(1,servi.getIdTipoServicio());
pstmt.setString(2,servi.getServicio());
pstmt.setInt(3,servi.getIdServicio());

servici = pstmt.executeUpdate();
           if (servici > 0) {
               msgSalida = "se modificaron (" + servici + ") registros";
           } else {
               msgSalida = "NO se pudo actualizar el registro";
           }
       } catch (SQLException ex) {
           msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

       }
       return msgSalida;
  }

public String crearServicio(serviciosDTO newServicio)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO servicios VALUES ( ?, ?, ?)");
            pstmt.setInt(1, newServicio.getIdServicio());
            pstmt.setInt(2, newServicio.getIdTipoServicio());
            pstmt.setString(3, newServicio.getServicio());
          
           
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
                Logger.getLogger(serviciosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<serviciosDTO> getAll() throws SQLException {
        LinkedList<serviciosDTO>listaServicios = new LinkedList<serviciosDTO>();
        try {


            String query = "SELECT  idservicio, idtiposervicio, servicio "
                    + " FROM servicios ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                serviciosDTO newServicio = new serviciosDTO();
                newServicio.setIdServicio(rs.getInt("id"));
                newServicio.setIdTipoServicio(rs.getInt("tipo"));
                newServicio.setServicio(rs.getString("servicio"));
                
                listaServicios.add( newServicio);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaServicios;
}
     public ArrayList <serviciosDTO> listarServicios () throws SQLException{
    ArrayList <serviciosDTO> listarServicios = new ArrayList ();
    
    try {
        String query = "select idServicio, idTipoServicio, servicio from servicios";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           serviciosDTO Rdao = new serviciosDTO();
           Rdao.setIdServicio(rs.getInt("idServicio"));
           Rdao.setIdTipoServicio(rs.getInt("idTipoServicio"));
           Rdao.setServicio(rs.getString("servicio"));
           listarServicios.add(Rdao);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    } return listarServicios;

}  

public String  ListarUnServicio (serviciosDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idServicio, idTipoServicio, servicio from servicios where idServicio=?;");
               pstmt.setInt(1, Rdao.getIdServicio());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
             
                 while(rs.next()){
                   Rdao.setIdServicio(rs.getInt("idServicio"));
                   Rdao.setIdTipoServicio(rs.getInt("idTipoServicio"));
                   Rdao.setServicio(rs.getString("servicio"));
                   
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }
     public String eliminar(serviciosDTO servi) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM servicios WHERE idServicio = ?; ");           
            pstmt.setInt(1, servi.getIdServicio());
           

            servici = pstmt.executeUpdate();
            if (servici> 0) {
                msgSalida = "se eliminaron (" + servici + ") registros";
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
