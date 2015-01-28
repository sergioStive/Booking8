/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.tipovehiculosDTO;
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
public class tipovehiculosDAO {
    
   private Connection cnn = null;
   private PreparedStatement pstmt;
   ResultSet rs = null;
   String msgSalida; 
   int tiposervi; 
public tipovehiculosDAO(){
   cnn = reserConex.getInstance();
   
}
public String actualizarRegistro( tipovehiculosDTO vehi) {
try {

   pstmt = cnn.prepareStatement("UPDATE tipovehiculos SET TipoVehiculo=?, modelo=?, "
       + "marca=? WHERE idtipoVehiculo=?;");

pstmt.setString(1,vehi.getTipoVehiculo());
pstmt.setInt(2,vehi.getModelo());
pstmt.setString(3,vehi.getMarca());
pstmt.setInt(4,vehi.getIdTipoVehiculo());

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
        public String crearTipoVehiculo(tipovehiculosDTO newTipoVehiculo)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO tipovehiculos VALUES ( ?, ?, ?, ?)");
            pstmt.setInt(1, newTipoVehiculo.getIdTipoVehiculo());
            pstmt.setString(2, newTipoVehiculo.getTipoVehiculo());
            pstmt.setInt(3, newTipoVehiculo.getModelo());
            pstmt.setString(4, newTipoVehiculo.getMarca());
          
           
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
                Logger.getLogger(tipovehiculosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<tipovehiculosDTO> getAll() throws SQLException {
        LinkedList<tipovehiculosDTO>listaTipovehiculos = new LinkedList<tipovehiculosDTO>();
        try {


            String query = "SELECT  idtipovehiculo, tipovehiculo,modelo,marca "
                    + " FROM tipovehiculos ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
               tipovehiculosDTO newTipoVehiculo = new tipovehiculosDTO();
                newTipoVehiculo.setIdTipoVehiculo(rs.getInt("id"));
                newTipoVehiculo.setTipoVehiculo(rs.getString("tipo"));
                newTipoVehiculo.setModelo(rs.getInt("modelo"));
                newTipoVehiculo.setModelo(rs.getInt("marca"));
                listaTipovehiculos.add(newTipoVehiculo);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return   listaTipovehiculos;
}

 public String eliminar(tipovehiculosDTO vehi) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM tipovehiculos WHERE idTipoVehiculo = ?; ");           
            pstmt.setInt(1, vehi.getIdTipoVehiculo());
           

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



