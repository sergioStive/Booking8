/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.DAO;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DTO.paisesDTO;
import java.sql.Connection;
import co.sena.edu.booking.DTO.personaxreservasDTO;
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
public class personaxreservasDAO {
    private Connection cnn = null;
    private PreparedStatement pstmt;
     ResultSet rs = null;
    String msgSalida; 
    int perreser; 
public personaxreservasDAO(){
    cnn = reserConex.getInstance();
    
}
public String actualizarRegistro( personaxreservasDTO personas) {
try {
     pstmt = cnn.prepareStatement ("UPDATE personaxreservas SET idReserva=?, nroMaletas=?, idPersona WHERE idPersonaXReservas=?;");

pstmt.setInt(1,personas.getIdReserva());
pstmt.setInt(2,personas.getNroMaletas());
pstmt.setString(3,personas.getIdPersona());
pstmt.setString(4,personas.getIdPersonaXReservas());

        
perreser = pstmt.executeUpdate();
            if (perreser > 0) {
                msgSalida = "se modificaron (" + perreser + ") registros";
            } else {
                msgSalida = "NO se pudo actualizar el registro";
            }
        } catch (SQLException ex) {
            msgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }
        return msgSalida;

 }
public String crearPersonaXReserva(personaxreservasDTO newPersonaxreserva)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO personaxreservas VALUES ( ?, ?, ?, ?)");
            pstmt.setString(1, newPersonaxreserva.getIdPersonaXReservas());
            pstmt.setInt(2, newPersonaxreserva.getIdReserva());
            pstmt.setInt(3, newPersonaxreserva.getNroMaletas());
            pstmt.setString(4, newPersonaxreserva.getIdPersona());
       
           
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
                Logger.getLogger(personaxreservasDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }

    public List<personaxreservasDTO> getAll() throws SQLException {
        LinkedList<personaxreservasDTO> listaPersonaxreservas = new LinkedList<personaxreservasDTO>();
        try {


            String query = "SELECT  IdReserva, idPersona, nroMaletas"
                    + " FROM personaxreservas ";
            pstmt= cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                personaxreservasDTO newPersonaxReserva = new personaxreservasDTO();
                newPersonaxReserva.setIdPersonaXReservas(rs.getString("id"));
                newPersonaxReserva.setIdReserva(rs.getInt("id"));
                newPersonaxReserva.setNroMaletas(rs.getInt("maletas"));
                newPersonaxReserva.setIdPersona(rs.getString("id"));
                
                listaPersonaxreservas .add(newPersonaxReserva);
            }
        } catch (SQLException ex) {
           msgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstmt.close();
        }

        return listaPersonaxreservas;
}
 public String  ListarUnaPersonaReserva (personaxreservasDTO Rdao) throws SQLException{
           try  {
               pstmt = cnn.prepareStatement("select idPersonaXReservas, idReserva, nroMaletas, idPersona from personaxreservas where idPersonaXReservas=?;");
               pstmt.setString(1, Rdao.getIdPersonaXReservas());
               pstmt.executeQuery();
               
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   Rdao.setIdPersonaXReservas(rs.getString("idPersonaXReservas"));
                   Rdao.setIdReserva(rs.getInt("idReserva"));
                   Rdao.setNroMaletas(rs.getInt("nroMaletas"));
                   Rdao.setIdPersona(rs.getString("idPersona"));
               }
           }catch (SQLException ex){
               msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }


       public List <personaxreservasDTO> listarPersonasXReserva () throws SQLException{
    ArrayList <personaxreservasDTO> listarPersonaXReserva = new ArrayList ();
    
    try {
        String query = " select idPersonaXReservas, idReserva, nroMaletas, idPersona from personaxreservas";
       pstmt = cnn.prepareStatement(query);
       rs = pstmt.executeQuery();
       
       while (rs.next()){
           personaxreservasDTO reser = new personaxreservasDTO();
               reser.setIdPersonaXReservas(rs.getString("idPersonaXReservas"));
                   reser.setIdReserva(rs.getInt("idReserva"));
                   reser.setNroMaletas(rs.getInt("nroMaletas"));
                   reser.setIdPersona(rs.getString("idPersona"));
                   listarPersonaXReserva.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    }return listarPersonaXReserva;
}
       public String eliminar(personaxreservasDTO personas) {
        try {
            /*
             * Para el ejemplo ilustativo se ha utilizado unicamente actualizar el nombre
             * Sin embargo, en las lineas comentadas se ilustra el codigo completo para actualizar todos los campos
             *
             */
            pstmt = cnn.prepareStatement("DELETE FROM personasxreservas WHERE idLugarArrivo = ?; ");           
            pstmt.setString(1, personas.getIdPersona());
           

            perreser = pstmt.executeUpdate();
            if (perreser > 0) {
                msgSalida = "se eliminaron (" + perreser + ") registros";
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




