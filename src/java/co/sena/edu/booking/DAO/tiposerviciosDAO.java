/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.sena.edu.booking.DAO;
import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.tiposerviciosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fabian
 */
public class tiposerviciosDAO {
   
   private Connection cnn = null;
   private PreparedStatement pstmt;
   ResultSet rs = null;
   String msgSalida; 
   int tiposervi; 
public tiposerviciosDAO(){
   cnn = reserConex.getInstance();
   
}
public String actualizarRegistro( tiposerviciosDTO servi) {
try {
pstmt = cnn.prepareStatement ("UPDATE tiposervicios SET TipoServicio=? WHERE idTipoServicio=?;");

pstmt.setString(1,servi.getTipoServicio());
pstmt.setInt(2,servi.getIdTipoServicio());

tiposervi = pstmt.executeUpdate();
           if (tiposervi > 0) {
               msgSalida = "se modificaron (" + tiposervi + ") registros";
           } else {
               msgSalida = "NO se pudo actualizar el registro";
           }
       } catch (SQLException ex) {
           msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

       }
       return msgSalida; 

  }

public String crearTipoServicio(tiposerviciosDTO newTipoServicio)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO tiposervicios VALUES ( ?, ?)");
            pstmt.setInt(1, newTipoServicio.getIdTipoServicio());
            pstmt.setString(2, newTipoServicio.getTipoServicio());
          
           
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
                Logger.getLogger(tiposerviciosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<tiposerviciosDTO> getAll() throws SQLException {
        LinkedList<tiposerviciosDTO>listaTipoServicios = new LinkedList<tiposerviciosDTO>();
        try {


            String query = "SELECT  idtiposervicio, tiposervicio "
                    + " FROM tiposervicios ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
               tiposerviciosDTO newTipoServicio = new tiposerviciosDTO();
                newTipoServicio.setIdTipoServicio(rs.getInt("id"));
                newTipoServicio.setTipoServicio(rs.getString("servicio"));
                
                listaTipoServicios.add(newTipoServicio);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaTipoServicios;
}
public String eliminar(tiposerviciosDTO servi) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM tiposervicios WHERE idTipoServicio = ?; ");           
            pstmt.setInt(1, servi.getIdTipoServicio());
           

            tiposervi = pstmt.executeUpdate();
            if (tiposervi> 0) {
                msgSalida = "se eliminaron (" + tiposervi + ") registros";
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

