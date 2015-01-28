/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.ciudadesDTO;
import co.sena.edu.booking.DTO.conductoresDTO;
import co.sena.edu.booking.DTO.reserDTO;
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
public class conductoresDAO {
     private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    String mgSalida; 
    int conduc; 
    
     public conductoresDAO  () {
        cnn = reserConex.getInstance();
      }
public String actualizarRegistro(conductoresDTO conductores) {

        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
          pstm = cnn.prepareStatement("UPDATE conductores SET idpersona=?, telcontacto=?  WHERE idConductor = ?; ");        
           
            pstm.setInt(1,conductores.getIdConductor());
            pstm.setInt(2,conductores.getIdpersona()); 
            pstm.setInt(3,conductores.getTelContacto());
           
            conduc = pstm.executeUpdate();
            if (conduc >0) {
                 mgSalida = "se modificaron (" + conduc + ") registros";
            } else {
               mgSalida = "NO se pudo actualizar el registro";
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

   public String crearConductor(conductoresDTO newConductor)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO conductores VALUES ( ?, ?, ?)");
          
            pstm.setInt(1,newConductor.getIdConductor());
            pstm.setInt(2,newConductor.getIdpersona());
            pstm.setInt(3, newConductor.getTelContacto());
       
           
           
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
                Logger.getLogger(conductoresDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<conductoresDTO> getAll() throws SQLException {
        LinkedList<conductoresDTO> listaconductores = new LinkedList<conductoresDTO>();
        try {


            String query = "SELECT  idconductor as id, idpersona, contacto "
                    + " FROM conductores ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                conductoresDTO newConductor = new conductoresDTO();
                newConductor.setIdConductor(rs.getInt("id"));
                newConductor.setIdpersona(rs.getInt("nombres"));               
                newConductor.setTelContacto(rs.getInt("contacto"));
                listaconductores.add(newConductor);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaconductores;
}
    public String  ListarUno (conductoresDTO Rdao) throws SQLException{
           try  {
               pstm = cnn.prepareStatement(" select idConductor, idPersona,telContacto from conductores where idConductor=?;");
               pstm.setInt(1, Rdao.getIdConductor());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdConductor(rs.getInt("idConductor"));
                   Rdao.setIdpersona(rs.getInt("idPersona"));
                   Rdao.setTelContacto(rs.getInt("telContacto"));
                  
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }

public List <conductoresDTO> listarCoductores () throws SQLException{
    ArrayList <conductoresDTO> listarConductores = new ArrayList ();
    
    try {
        String query = " select idConductor,idPersona,telContacto from Conductores";
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
           conductoresDTO reser = new conductoresDTO();
               reser.setIdConductor(rs.getInt("idConductor"));
                   reser.setIdpersona(rs.getInt("idPersona"));
                   reser.setTelContacto(rs.getInt("telContacto"));
                   
                   listarConductores.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarConductores;
}  
 public String eliminar(conductoresDTO conductores) {
        try {
           
            pstm = cnn.prepareStatement("DELETE FROM conductores WHERE idConductor = ?; ");      
            pstm.setInt(1, conductores.getIdConductor());
           

            conduc = pstm.executeUpdate();
            if (conduc > 0) {
                mgSalida = "se eliminaron (" + conduc + ") registros";
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


