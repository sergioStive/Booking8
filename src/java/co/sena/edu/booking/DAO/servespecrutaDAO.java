/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.rutasDTO;
import java.sql.Connection;
import co.sena.edu.booking.DTO.servespecrutaDTO;
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
public class servespecrutaDAO {
     private Connection cnn = null;
    private PreparedStatement pstmt;
   ResultSet rs = null;
    String msgSalida; 
    int serves; 
public servespecrutaDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( servespecrutaDTO peta) {
try {

    pstmt = cnn.prepareStatement("UPDATE servespxerutas SET idreserva=?, servespecruta=?, "
            + "despcripcion=?, cantidad=?"
            + " WHERE idservespxruta=?;");
pstmt.setInt(1,peta.getIdReserva());
pstmt.setInt(2,peta.getIdServEspecial());
pstmt.setString(3,peta.getDespcripcion());
pstmt.setInt(4,peta.getCantidad());
pstmt.setString(5,peta.getIdservespxrutas());

serves = pstmt.executeUpdate();
            if (serves > 0) {
                msgSalida = "se modificaron (" + serves + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;

   }
public String crearServEspecialRuta(servespecrutaDTO newSevicioRuta)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO servespxrutas VALUES ( ?, ?, ?, ?, ?)");
            pstmt.setString(1, newSevicioRuta.getIdservespxrutas());
            pstmt.setInt(2, newSevicioRuta.getIdReserva());
            pstmt.setInt(3, newSevicioRuta.getIdServEspecial());
            pstmt.setString(4, newSevicioRuta.getDespcripcion());
            pstmt.setInt(5, newSevicioRuta.getCantidad());
           
           
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
                Logger.getLogger(servespecrutaDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<servespecrutaDTO> getAll() throws SQLException {
        LinkedList<servespecrutaDTO> listaServiciosRuta = new LinkedList<servespecrutaDTO>();
        try {


            String query = "SELECT  Idservespxrutas, IdReserva, idServespecial, descripcion, cantidad"
                    + " FROM servespxrutas ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                servespecrutaDTO newSevicioRuta = new servespecrutaDTO();
                newSevicioRuta.setIdservespxrutas(rs.getString("id"));
                newSevicioRuta.setIdReserva(rs.getInt("id"));
                newSevicioRuta.setIdServEspecial(rs.getInt("servicio"));
                newSevicioRuta.setDespcripcion(rs.getString("descripcion"));
                newSevicioRuta.setCantidad(rs.getInt("cantidad"));
               listaServiciosRuta.add(newSevicioRuta);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaServiciosRuta;
}
public String  ListarUnSerRuta (servespecrutaDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idservespxrutas, idReserva, idServEspecial, despcripcion, cantidad "
                       + " from servespxrutas where idservespxrutas=?;");
               pstmt.setString(1, Rdao.getIdservespxrutas());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdservespxrutas(rs.getString("idservespxrutas"));
                   Rdao.setIdReserva(rs.getInt("idReserva"));
                   Rdao.setIdServEspecial(rs.getInt("idServEspecial"));
                   Rdao.setDespcripcion(rs.getString("despcripcion"));
                   Rdao.setCantidad(rs.getInt("cantidad"));
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


       public List <servespecrutaDTO> listarServcioESpecialRuta () throws SQLException{
    ArrayList <servespecrutaDTO> listarServicios = new ArrayList ();
    
    try {
        String query = "select idservespxrutas, idReserva, idServEspecial, despcripcion, cantidad "
                       + " from servespxrutas";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           servespecrutaDTO Rdao = new servespecrutaDTO();
           
                   Rdao.setIdservespxrutas(rs.getString("idservespxrutas"));
                   Rdao.setIdReserva(rs.getInt("idReserva"));
                   Rdao.setIdServEspecial(rs.getInt("idServEspecial"));
                   Rdao.setDespcripcion(rs.getString("despcripcion"));
                   Rdao.setCantidad(rs.getInt("cantidad"));
                   listarServicios.add(Rdao);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarServicios;
}  
       public String eliminar(servespecrutaDTO peta) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM servespecruta WHERE idServEspecial = ?; ");           
            pstmt.setInt(1, peta.getIdServEspecial());
           

            serves = pstmt.executeUpdate();
            if (serves > 0) {
                msgSalida = "se eliminaron (" + serves + ") registros";
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



