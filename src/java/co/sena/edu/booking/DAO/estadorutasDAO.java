/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.sena.edu.booking.DAO;
import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.estadoreservasDTO;
import co.sena.edu.booking.DTO.estadorutasDTO;
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
public class estadorutasDAO {
   



/**
*
* @author Tomoko
*/
   private Connection cnn = null;
   private PreparedStatement pstmt;
   ResultSet rs = null;
   String msgSalida; 
   int estaReser; 
public estadorutasDAO(){
   cnn = reserConex.getInstance();
   
}
public String actualizarRegistro( estadorutasDTO estadoRutas) {
try {

   pstmt = cnn.prepareStatement("UPDATE estadorutas SET estadoRuta=? WHERE idEstadoRuta=?;");
   pstmt.setString(1,estadoRutas.getEstadoRuta());
   pstmt.setInt(2,estadoRutas.getIdEstadoRuta());
   
   estaReser = pstmt.executeUpdate();
           if (estaReser > 0) {
               msgSalida = "se modificaron("+estaReser+")registros";
           } else {
               msgSalida = "NO se pudo actualizar el registro";
           }
       } catch (SQLException ex) {
           msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

       }
       return msgSalida;
      
 }
      public String crearEstadoRuta(estadorutasDTO newEstado)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO estadorutas VALUES ( ?, ?)");
            pstmt.setInt(1,newEstado.getIdEstadoRuta());
            pstmt.setString(2, newEstado.getEstadoRuta());

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
                Logger.getLogger(estadorutasDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<estadorutasDTO> getAll() throws SQLException {
        LinkedList<estadorutasDTO> listaestados = new LinkedList<estadorutasDTO>();
        try {


            String query = "SELECT   idEstadoRuta, EstadoRuta "
                    + " FROM estadorutas ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                estadorutasDTO newEstado = new estadorutasDTO();
                newEstado.setIdEstadoRuta(rs.getInt("id"));
                newEstado.setEstadoRuta(rs.getString("estado"));
                listaestados.add(newEstado);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaestados;
}
    public String  ListarUnaRuta (estadorutasDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement(" select idEstadoRuta, estadoRuta from estadoRutas where idEstadoRuta=?;");
               pstmt.setInt(1, Rdao.getIdEstadoRuta());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdEstadoRuta(rs.getInt("idEstadoRuta"));
                   Rdao.setEstadoRuta(rs.getString("estadoRuta"));
                   
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


 public List <estadorutasDTO> listarEstadosRutas () throws SQLException{
    ArrayList <estadorutasDTO> listarEstadoRutas = new ArrayList ();
    
    try {
        String query = " select idEstadoRuta, estadoRuta from estadorutas";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
          estadorutasDTO empt = new estadorutasDTO();
               empt.setIdEstadoRuta(rs.getInt("idEstadoRuta"));
                   empt.setEstadoRuta(rs.getString("estadoRuta"));
                   listarEstadoRutas.add(empt);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarEstadoRutas;
}  

public String eliminar(estadorutasDTO estadoRutas) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM estadorutas WHERE idEstadoRuta = ?; ");
            //pstmt= cnn.prepareStatement("UPDATE usuarios SET id_perfil=?, nombres=?, apellidos=?, usuario=? clave = MD5(?) WHERE id_usuario = ?; ");           
            pstmt.setInt(1, estadoRutas.getIdEstadoRuta());
           

            estaReser = pstmt.executeUpdate();
            if (estaReser > 0) {
                msgSalida = "se eliminaron (" + estaReser + ") registros";
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




