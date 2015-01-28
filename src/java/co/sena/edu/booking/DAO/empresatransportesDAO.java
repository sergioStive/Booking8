/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.sena.edu.booking.DAO;
import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.empresatransportesDTO;
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
public class empresatransportesDAO {
   private Connection cnn = null;
   private PreparedStatement pstmt;
   ResultSet rs = null;
   String mgSalida; 
   int empresaTrans;
   
    public empresatransportesDAO() {
       cnn = reserConex.getInstance();
       
   }
 public String actualizarRegistro( empresatransportesDTO empresTranpor) {

       try {
           pstmt = cnn.prepareStatement("UPDATE empresatransportes SET nombreEmpresaTransporte=?,"
                   + " WHERE idEmpresaTransporte=?; ");
           
           pstmt.setString(1,empresTranpor.getNombreEmpresaTransporte());
           pstmt.setString(2,empresTranpor.getIdEmpresaTransporte());
           
             empresaTrans = pstmt.executeUpdate();
           if (empresaTrans > 0) {
               mgSalida = "se modificaron (" + empresaTrans + ") registros";
           } else {
               mgSalida = "NO se pudo actualizar el registro";
           }
       } catch (SQLException ex) {
           mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

       }
       return mgSalida;
             
       }
     public String crearEmpresaTransportes(empresatransportesDTO newEmpresaTransportes)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO empresatransportes VALUES ( ?, ?)");
            pstmt.setString(1,newEmpresaTransportes.getIdEmpresaTransporte());
            pstmt.setString(2,newEmpresaTransportes.getNombreEmpresaTransporte());

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
                Logger.getLogger(empresatransportesDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<empresatransportesDTO> getAll() throws SQLException {
        LinkedList<empresatransportesDTO> listaempresatransportes = new LinkedList<empresatransportesDTO>();
        try {


            String query = "SELECT   idEmpresaTransporte, NombreEmpresaTransporte "
                    + " FROM empresatransportes ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                empresatransportesDTO newEmpresaTrans = new empresatransportesDTO();
                newEmpresaTrans.setIdEmpresaTransporte(rs.getString("idEmpresaTransporte"));
                newEmpresaTrans.setNombreEmpresaTransporte(rs.getString("nombreEmpresaTransporte"));
                listaempresatransportes.add(newEmpresaTrans);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaempresatransportes;
}   
    public List <empresatransportesDTO> listarEmpresaTransportes () throws SQLException{
    ArrayList <empresatransportesDTO> listarEmpresaTransportes = new ArrayList ();
    
    try {
        String query = " select idEmpresaTransporte, nombreEmpresaTransporte from empresatransportes";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           empresatransportesDTO empt = new empresatransportesDTO();
               empt.setIdEmpresaTransporte(rs.getString("idEmpresaTransporte"));
                   empt.setNombreEmpresaTransporte(rs.getString("nombreEmpresaTransporte"));
                   listarEmpresaTransportes.add(empt);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarEmpresaTransportes;
}  

public String  ListarEmpresa (empresatransportesDTO empt) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idEmpresaTransporte, nombreEmpresaTransporte from empresatransportes where idEmpresaTransporte=?;");
               pstmt.setString(1, empt.getIdEmpresaTransporte());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   empt.setIdEmpresaTransporte(rs.getString("idEmpresaTransporte"));
                   empt.setNombreEmpresaTransporte(rs.getString("nombreEmpresaTransporte"));
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + empt;
       }
      public String eliminar(empresatransportesDTO empresTranpor) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM empresatransportes WHERE idEmpresaTransporte= ?; ");
            //pstmt= cnn.prepareStatement("UPDATE usuarios SET id_perfil=?, nombres=?, apellidos=?, usuario=? clave = MD5(?) WHERE id_usuario = ?; ");           
            pstmt.setString(1, empresTranpor.getIdEmpresaTransporte());
           

            empresaTrans = pstmt.executeUpdate();
            if (empresaTrans > 0) {
                mgSalida = "se eliminaron (" +empresaTrans+ ") registros";
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
    
   
    

