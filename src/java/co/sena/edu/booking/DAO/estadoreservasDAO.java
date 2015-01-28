/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.empresatransportesDTO;
import co.sena.edu.booking.DTO.estadoreservasDTO;
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
public class estadoreservasDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
     String msgSalida; 
    int estaReser; 
public estadoreservasDAO(){
    cnn = reserConex.getInstance();
    
}

public String actualizarRegistro(estadoreservasDTO estadoReserva) {
try {
pstmt = cnn.prepareStatement("UPDATE estadoreservas SET estadoReserva=?, "
        + "WHERE idestadoReserva =?;");


       pstmt.setString(1,estadoReserva.getEstadoReserva());
       pstmt.setInt(2,estadoReserva.getIdestadoReserva());
       
       
                estaReser = pstmt.executeUpdate();
            if (estaReser > 0) {
                msgSalida = "se modificaron("+estaReser+")registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
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
public String crearEstadoReserva(estadoreservasDTO newEstado)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO estadoreservas VALUES ( ?, ?)");
            pstmt.setInt(1, newEstado.getIdestadoReserva());
            pstmt.setString(2, newEstado.getEstadoReserva());
           
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
                Logger.getLogger(estadoreservasDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<estadoreservasDTO> getAll() throws SQLException {
        LinkedList<estadoreservasDTO> listaEstadosReservas = new LinkedList<estadoreservasDTO>();
        try {


            String query = "SELECT  IdestadoReserva, estadoReserva"
                    + " FROM estadoreservas ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                estadoreservasDTO newEstado = new estadoreservasDTO();
                newEstado.setIdestadoReserva(rs.getInt("id"));
                newEstado.setEstadoReserva(rs.getString("estado"));
                
                listaEstadosReservas.add(newEstado);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaEstadosReservas;
}
    public List <estadoreservasDTO> listarEstadoReservas () throws SQLException{
    ArrayList <estadoreservasDTO> listarEstadoReservas = new ArrayList ();
    
    try {
        String query = " select idEstadoReserva, estadoReserva from estadoreservas";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
          estadoreservasDTO empt = new estadoreservasDTO();
               empt.setIdestadoReserva(rs.getInt("idEstadoReserva"));
                   empt.setEstadoReserva(rs.getString("estadoReserva"));
                   listarEstadoReservas.add(empt);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarEstadoReservas;
}  

public String  ListarUnEstado(estadoreservasDTO empt) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idEstadoReserva, estadoReserva from estadoreservas where idEstadoReserva=?;");
               pstmt.setInt(1, empt.getIdestadoReserva());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   empt.setIdestadoReserva(rs.getInt("idEstadoReserva"));
                   empt.setEstadoReserva(rs.getString("estadoReserva"));
                   
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + empt;
       }
public String eliminar(estadoreservasDTO estadoReserva) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM estadoreservas WHERE idestadoReserva = ?; ");
            //pstmt= cnn.prepareStatement("UPDATE usuarios SET id_perfil=?, nombres=?, apellidos=?, usuario=? clave = MD5(?) WHERE id_usuario = ?; ");           
            pstmt.setInt(1, estadoReserva.getIdestadoReserva() );
           

            estaReser = pstmt.executeUpdate();
            if (estaReser > 0) {
                msgSalida = "se eliminaron (" + estaReser+ ") registros";
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
    
