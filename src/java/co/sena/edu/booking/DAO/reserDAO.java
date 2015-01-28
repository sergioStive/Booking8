/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.personasDTO;
import co.sena.edu.booking.DTO.personaxreservasDTO;
import co.sena.edu.booking.DTO.reserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aprendiz
 */
public class reserDAO {

    //definimos variables globales
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    /* inicializo el contructor para garantizar la conexion al crear el objeto
     30 *
     31 */
    String msgSalida; // almacena el msg de salida al usuario
    int rtdo; // almacena el resultado de la ejecución en la BD

    public reserDAO() {
        cnn = reserConex.getInstance();
    }

    public String actualizarRegistro(reserDTO resert) {

        try {
         
            pstmt = cnn.prepareStatement("UPDATE reservas SET idEstadoReserva= ?"
                    + ", idServicio=?, idTransporteLlegada=?, Responsable=?"
                    + ", horaReserva=?, fechaReserva=?"
                    + ",direccionDestino=?  WHERE IdReserva = ?; ");
         
            pstmt.setInt(1, resert.getIdEstadoReserva());
            pstmt.setInt(2, resert.getIdServicio());
            pstmt.setString(3, resert.getIdTransporteLlegada());
            pstmt.setString(4, resert.getResponsable());           
            pstmt.setString(5, resert.getHoraReserva());
            pstmt.setString(6, resert.getFechaReserva());
            pstmt.setString(7, resert.getDireccionDestino());
            pstmt.setInt(8, resert.getIdReserva());
            //

            rtdo = pstmt.executeUpdate();
            if (rtdo > 0) {
                msgSalida = "se modificaron (" + rtdo + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
        }
        return msgSalida;
    }

    public String eliminar(reserDTO rdto) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM reservas WHERE idReserva = ?; ");
            //pstmt= cnn.prepareStatement("UPDATE usuarios SET id_perfil=?, nombres=?, apellidos=?, usuario=? clave = MD5(?) WHERE id_usuario = ?; ");           
            pstmt.setInt(1, rdto.getIdReserva());
           

            rtdo = pstmt.executeUpdate();
            if (rtdo > 0) {
                msgSalida = "se eliminaron (" + rtdo + ") registros";
            } else {
                msgSalida = "NO se pudo eliminar  el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }

        return msgSalida;
    }

    public String insertar(reserDTO rdto) throws SQLException {
        String salida = "";
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?);");            
            pstmt.setInt(1, rdto.getIdReserva());
            pstmt.setInt(2, rdto.getIdEstadoReserva());
            pstmt.setInt(3, rdto.getIdServicio());
            pstmt.setString(4, rdto.getIdTransporteLlegada());
            pstmt.setString(5, rdto.getResponsable());            
            pstmt.setString(6, rdto.getFechaReserva());
            pstmt.setString(7, rdto.getHoraReserva());
            pstmt.setString(8, rdto.getDireccionDestino());

            
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
                Logger.getLogger(reserDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }


    public List <reserDTO> listarReservas () throws SQLException{
    ArrayList <reserDTO> listarReservas = new ArrayList ();
    
    try {
        String query = " select idReserva, idEstadoReserva, idServicio, idTransporteLlegada, responsable,"
                       + " fechaReserva, horaReserva, direccionDestino from reservas";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           reserDTO Rdao = new reserDTO();
             Rdao.setIdReserva(rs.getInt("idReserva"));
                   Rdao.setIdEstadoReserva(rs.getInt("idEstadoReserva"));
                   Rdao.setIdServicio(rs.getInt("idServicio"));
                   Rdao.setIdTransporteLlegada(rs.getString("idTransporteLlegada"));
                   Rdao.setResponsable(rs.getString("responsable"));                
                   Rdao.setFechaReserva(rs.getString("fechaReserva"));
                   Rdao.setHoraReserva(rs.getString("horaReserva"));
                   Rdao.setDireccionDestino(rs.getString("direccionDestino"));
                   listarReservas.add(Rdao);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarReservas;
} 
   public  reserDTO  ListarUnaReserva (int idReserva) throws SQLException{
       reserDTO Rdao = new reserDTO();
           try  {
               pstmt = cnn.prepareStatement("select idReserva, idEstadoReserva, idServicio, idTransporteLlegada, responsable, fechaReserva, horaReserva, direccionDestino from reservas where idReserva=?;");
               pstmt.setInt(1, idReserva);
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                 
                   Rdao.setIdReserva(rs.getInt("idReserva"));
                   Rdao.setIdEstadoReserva(rs.getInt("idEstadoReserva"));
                   Rdao.setIdServicio(rs.getInt("idServicio"));
                   Rdao.setIdTransporteLlegada(rs.getString("idTransporteLlegada"));
                   Rdao.setResponsable(rs.getString("responsable"));                
                   Rdao.setFechaReserva(rs.getString("fechaReserva"));
                   Rdao.setHoraReserva(rs.getString("horaReserva"));
                   Rdao.setDireccionDestino(rs.getString("direccionDestino"));
                   
                   
               }
           }catch (SQLException ex){
             msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return Rdao;
       }
}
