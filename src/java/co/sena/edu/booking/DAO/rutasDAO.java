/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.reserDTO;
import java.sql.Connection;
import co.sena.edu.booking.DTO.rutasDTO;
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
public class rutasDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida; 
    int rut; 
public rutasDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( rutasDTO rutas) {
try {

    pstmt = cnn.prepareStatement("UPDATE rutas SET placaVehiculo=?,"
            + "idtipovewhiculo=?, idestadoruta=?, "
            + "idpersona=?,idconductor=?,idreserva=? WHERE idRuta=? ");
    pstmt.setString(1,rutas.getPlacaVehiculo());
    pstmt.setInt(2,rutas.getIdtipoVehiculo());
    pstmt.setInt(3,rutas.getIdEstadoRuta());
    pstmt.setString(4,rutas.getIdPersona());
    pstmt.setString(5,rutas.getIdConductor());
    pstmt.setInt(6,rutas.getidReserva());
    pstmt.setInt(7,rutas.getIdRuta());
    
    rut = pstmt.executeUpdate();
            if (rut > 0) {
                msgSalida = "se modificaron (" + rut + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;

 }
public String crearRuta(rutasDTO newRuta)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO rutas VALUES ( ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, newRuta.getIdRuta());
            pstmt.setString(2, newRuta.getPlacaVehiculo());
            pstmt.setInt(3, newRuta.getIdtipoVehiculo());
            pstmt.setInt(4, newRuta.getIdEstadoRuta());
            pstmt.setString(5, newRuta.getIdPersona());
            pstmt.setString(6, newRuta.getIdConductor());
            pstmt.setInt(7, newRuta.getidReserva());
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
                Logger.getLogger(rutasDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<rutasDTO> getAll() throws SQLException {
        LinkedList<rutasDTO> listaRutas = new LinkedList<rutasDTO>();
        try {


            String query = "SELECT  IdRuta, placaVehiculo,idtipovehiculo, idestadoruta, idpersona, idpersona, idreserva"
                    + " FROM rutas ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rutasDTO newRuta = new rutasDTO();
                newRuta.setIdRuta(rs.getInt("id"));
                newRuta.setPlacaVehiculo(rs.getString("placa"));
                newRuta.setIdtipoVehiculo(rs.getInt("vehiculo"));
                newRuta.setIdEstadoRuta(rs.getInt("ruta"));
                newRuta.setIdPersona(rs.getString("id persona"));          
                newRuta.setIdConductor(rs.getString("id conductor"));
                newRuta.setidReserva(rs.getInt("id reserva"));
                listaRutas.add(newRuta);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaRutas;
}
    public String  ListarUnaRuta (rutasDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idRuta, placaVehiculo, idtipoVehiculo, idEstadoRuta, idPersona, idConductor,"
                       + " idreserva from rutas where idRuta=?;");
               pstmt.setInt(1, Rdao.getIdRuta());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdRuta(rs.getInt("idRuta"));
                   Rdao.setPlacaVehiculo(rs.getString("placaVehiculo"));
                   Rdao.setIdtipoVehiculo(rs.getInt("idtipoVehiculo"));
                   Rdao.setIdEstadoRuta(rs.getInt("idEstadoRuta"));
                   Rdao.setIdPersona(rs.getString("idPersona"));
                   Rdao.setIdConductor(rs.getString("idConductor"));
                   Rdao.setidReserva(rs.getInt("idreserva"));
                 
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


       public List <rutasDTO> listarRutas () throws SQLException{
    ArrayList <rutasDTO> listarRutas = new ArrayList ();
    
    try {
        String query = "select idRuta, placaVehiculo, idtipoVehiculo, idEstadoRuta, idPersona, idConductor,"
                       + " idreserva from rutas";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           rutasDTO Rdao = new rutasDTO();
                   Rdao.setIdRuta(rs.getInt("idReserva"));
                   Rdao.setIdRuta(rs.getInt("idRuta"));
                   Rdao.setPlacaVehiculo(rs.getString("placaVehiculo"));
                   Rdao.setIdtipoVehiculo(rs.getInt("idtipoVehiculo"));
                   Rdao.setIdEstadoRuta(rs.getInt("idEstadoRuta"));
                   Rdao.setIdPersona(rs.getString("idPersona"));
                   Rdao.setIdConductor(rs.getString("idConductor"));
                   Rdao.setidReserva(rs.getInt("idreserva"));
                   listarRutas.add(Rdao);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarRutas;
} 
       public String eliminar(rutasDTO rutass) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM rutas WHERE idRuta = ?; ");           
            pstmt.setInt(1, rutass.getIdRuta());
           

            rut = pstmt.executeUpdate();
            if (rut> 0) {
                msgSalida = "se eliminaron (" + rut + ") registros";
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

    
    

