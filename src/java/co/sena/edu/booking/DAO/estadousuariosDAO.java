/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.empresatransportesDTO;
import co.sena.edu.booking.DTO.estadousuariosDTO;
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
public class estadousuariosDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida; 
    int estadoUso; 
public estadousuariosDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( estadousuariosDTO estadoUsuario) {
try {
pstmt = cnn.prepareStatement ("UPDATE estadousuarios SET estado=? WHERE idEstadoUsuario=?;");

pstmt.setString (1,estadoUsuario.getEstado());
pstmt.setInt (2,estadoUsuario.getIdEstadoUsuario());

estadoUso = pstmt.executeUpdate();
            if (estadoUso > 0) {
                msgSalida = "se modificaron (" + estadoUso + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;
    }
public String crearEstadoUsuario(estadousuariosDTO newEstadoUsu)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO estadousuarios VALUES ( ?, ?)");
            pstmt.setInt(1, newEstadoUsu.getIdEstadoUsuario());
            pstmt.setString(2, newEstadoUsu.getEstado());
           
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
                Logger.getLogger(estadousuariosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<estadousuariosDTO> getAll() throws SQLException {
        LinkedList<estadousuariosDTO> listaEstadosUsuarios = new LinkedList<estadousuariosDTO>();
        try {


            String query = "SELECT  IdEstadoUsuario, estado"
                    + " FROM estadousuarios ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                estadousuariosDTO newEstadoUsu = new estadousuariosDTO();
                newEstadoUsu.setIdEstadoUsuario(rs.getInt("id"));
                newEstadoUsu.setEstado(rs.getString("estado"));
                
                listaEstadosUsuarios.add(newEstadoUsu);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaEstadosUsuarios;
}
    public String  ListarUnUsuario (estadousuariosDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idEstadoUsuario,estado from estadousuarios where idEstadoUsuario=?;");
               pstmt.setInt(1, Rdao.getIdEstadoUsuario());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdEstadoUsuario(rs.getInt("idEstadoUsuario"));
                   Rdao.setEstado(rs.getString("estado"));
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }

public List <estadousuariosDTO> listarUsuarios () throws SQLException{
    ArrayList <estadousuariosDTO> listarUsuarios = new ArrayList ();
    
    try {
        String query = " select  idEstadoUsuario,estado from estadousuarios";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           estadousuariosDTO empt = new estadousuariosDTO();
                   empt.setIdEstadoUsuario(rs.getInt("idEstadoUsuario"));
                   empt.setEstado(rs.getString("estado"));
                   listarUsuarios.add(empt);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarUsuarios;

}
 public String eliminar(estadousuariosDTO estadoUsuario) {
        try {
           
            pstmt = cnn.prepareStatement("DELETE FROM estadousuarios WHERE idEstadoUsuario= ?; ");
            //pstmt= cnn.prepareStatement("UPDATE usuarios SET id_perfil=?, nombres=?, apellidos=?, usuario=? clave = MD5(?) WHERE id_usuario = ?; ");           
            pstmt.setInt(1, estadoUsuario.getIdEstadoUsuario());
           

            estadoUso = pstmt.executeUpdate();
            if (estadoUso > 0) {
                msgSalida = "se eliminaron (" + estadoUso + ") registros";
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
