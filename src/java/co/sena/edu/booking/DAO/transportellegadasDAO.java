/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.transportellegadasDTO;
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
 * @author Tomoko
 */
public class transportellegadasDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida; 
    int tiposervi; 
public transportellegadasDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( transportellegadasDTO trans) {
try {

pstmt = cnn.prepareStatement("UPDATE transportellegadas  SET horaArrivo=?,"
        + "horaSalida=?, idEmpresaTransporte=?  WHERE idtipoVehiculo=?;");
        
        pstmt.setString(1,trans.getHoraArrivo());
        pstmt.setString(2,trans.getHoraSalida());
        pstmt.setInt(3,trans.getIdLugarArrivo());
        pstmt.setString(4,trans.getIdEmpresaTransporte());
        pstmt.setString(5,trans.getIdTransporteLlegada());
        
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
public String crearTransporteLlegada(transportellegadasDTO newTransporteLlegada)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO  transportellegadas VALUES ( ?, ?, ?, ?, ?)");
            pstmt.setString(1, newTransporteLlegada.getIdTransporteLlegada());
            pstmt.setString(2, newTransporteLlegada.getHoraArrivo());
            pstmt.setString(3, newTransporteLlegada.getHoraSalida());
            pstmt.setInt(4, newTransporteLlegada.getIdLugarArrivo());
            pstmt.setString(5, newTransporteLlegada.getIdEmpresaTransporte());
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
                Logger.getLogger(transportellegadasDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<transportellegadasDTO> getAll() throws SQLException {
        LinkedList<transportellegadasDTO> listaTransporteLlegada = new LinkedList<transportellegadasDTO>();
        try {


            String query = "SELECT  IdTransporteLlegada, horaArrivo, horaSalida, idLugarArrivo, idEmpresaTransporte"
                    + " FROM transportellegadas ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                 transportellegadasDTO newTransporteLlegada= new transportellegadasDTO();
                newTransporteLlegada.setIdTransporteLlegada(rs.getString("id"));
                newTransporteLlegada.setHoraArrivo(rs.getString("pais"));
                newTransporteLlegada.setHoraSalida(rs.getString("idioma"));
                newTransporteLlegada.setIdLugarArrivo(rs.getInt("idioma"));
                newTransporteLlegada.setIdEmpresaTransporte(rs.getString("idioma"));
                listaTransporteLlegada .add(newTransporteLlegada);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaTransporteLlegada ;
}
public String eliminar(transportellegadasDTO trans) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM transportellegadas WHERE idTransporteLlegadas = ?; ");           
            pstmt.setString(1, trans.getIdTransporteLlegada());
           

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
