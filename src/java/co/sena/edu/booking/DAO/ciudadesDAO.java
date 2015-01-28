    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.ciudadesDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomoko
 */
public class ciudadesDAO {
    private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    
    String mgSalida; // almacena el msg de salida al usuario
    int ciu; // almacena el resultado de la ejecución en la BD
    
    public ciudadesDAO() {
        cnn = reserConex.getInstance();
        
    }
     public String actualizarRegistro(ciudadesDTO ciudad) {

        try {
    pstm = cnn.prepareStatement("UPDATE ciudades SET  ciudad =?, idPais=?  where idciudad=?;");
          
            pstm.setString(1, ciudad.getCiudad());
            pstm.setString(2, ciudad.getidPais());
            pstm.setString(3, ciudad.getIdCiudad());
            
            ciu= pstm.executeUpdate();
            if (ciu > 0) {
                mgSalida = "se modificaron (" + ciu + ") registros";
            } else {
                mgSalida = "NO se pudo actualizar el registro";
            }
            
        } catch (SQLException ex) {
        mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
//          } finally {
//            try {
//                if (pstm != null) {
//                    pstm.close();
//                }
//                if (cnn != null) {
//                    cnn.close();
//                }
//            } catch (SQLException ex) {
//                mgSalida = "error al cerrar la conexion " + ex.getMessage();
//            }
        
        }
        return mgSalida;
 
  } 
     public String crearCiudad(ciudadesDTO newCiudad)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO ciudades VALUES ( ?, ?, ?)");
            pstm.setString(1, newCiudad.getIdCiudad());
            pstm.setString(2, newCiudad.getCiudad());
            pstm.setString(3, newCiudad.getidPais());
           
            resultado = pstm.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario a sido registrado exitosamente. " + resultado + "filas afectadas";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";
                
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ciudadesDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<ciudadesDTO> getAll() throws SQLException {
        LinkedList<ciudadesDTO> listaciudades = new LinkedList<ciudadesDTO>();
        try {


            String query = "SELECT  idCiudad, ciudad, idpais "
                    + " FROM ciudades ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ciudadesDTO newCiudad = new ciudadesDTO();
                newCiudad.setIdCiudad(rs.getString("id"));
                newCiudad.setCiudad(rs.getString("ciudad"));
                newCiudad.setidPais(rs.getString("pais"));
                listaciudades.add(newCiudad);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaciudades;
}
    public ArrayList <ciudadesDTO> listarTodo () throws SQLException{
    ArrayList <ciudadesDTO> listarCiudades = new ArrayList ();
    
    try {
        String query = "select idCiudad, Ciudad, idPais from Ciudades";
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
           ciudadesDTO reser = new ciudadesDTO();
               reser.setIdCiudad(rs.getString("idCiudad"));
                   reser.setCiudad(rs.getString("ciudad"));
                   reser.setidPais(rs.getString("idPais"));
                   listarCiudades.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    } return listarCiudades;

}  

public String  ListarUno (ciudadesDTO Rdao) throws SQLException{
           try  {
               pstm = cnn.prepareStatement("select idCiudad, Ciudad, idPais from ciudades where idCiudad=?;");
               pstm.setString(1, Rdao.getIdCiudad());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
             
                 while(rs.next()){
                   Rdao.setIdCiudad(rs.getString("idCiudad"));
                   Rdao.setCiudad(rs.getString("Ciudad"));
                   Rdao.setidPais(rs.getString("idPais"));
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }
public String eliminar(ciudadesDTO ciudad) {
      
        try {
          
            pstm = cnn.prepareStatement("DELETE FROM ciudades  WHERE idCiudad = ?; ");      
            pstm.setString(1, ciudad.getIdCiudad());
           

            ciu = pstm.executeUpdate();
            if (ciu > 0) {
                mgSalida = "se eliminaron (" + ciu + ") registros";
            } else {
                mgSalida = "NO se pudo eliminar  el registro";
            }
        } catch (SQLException ex) {
            mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
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

        return mgSalida;
    }
}
