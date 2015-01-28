/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.booking.vista;

import cao.sena.edu.booking.util.reserConex;
import co.sena.edu.booking.DAO.ciudadesDAO;
import co.sena.edu.booking.DAO.conductoresDAO;
import co.sena.edu.booking.DAO.empresasDAO;
import co.sena.edu.booking.DAO.empresatransportesDAO;
import co.sena.edu.booking.DAO.estadoreservasDAO;
import co.sena.edu.booking.DAO.estadorutasDAO;
import co.sena.edu.booking.DAO.estadousuariosDAO;
import co.sena.edu.booking.DAO.lugararrivosDAO;
import co.sena.edu.booking.DAO.nacionalidadesDAO;
import co.sena.edu.booking.DAO.paisesDAO;
import co.sena.edu.booking.DAO.personasDAO;
import co.sena.edu.booking.DAO.personaxreservasDAO;
import co.sena.edu.booking.DAO.reserDAO;
import co.sena.edu.booking.DAO.rutasDAO;
import co.sena.edu.booking.DAO.servespecialesDAO;
import co.sena.edu.booking.DAO.servespecrutaDAO;
import co.sena.edu.booking.DAO.serviciosDAO;
import co.sena.edu.booking.DAO.tiposerviciosDAO;
import co.sena.edu.booking.DAO.tipovehiculosDAO;
import co.sena.edu.booking.DAO.transportellegadasDAO;
import co.sena.edu.booking.DTO.ciudadesDTO;
import co.sena.edu.booking.DTO.conductoresDTO;
import co.sena.edu.booking.DTO.empresasDTO;
import co.sena.edu.booking.DTO.empresatransportesDTO;
import co.sena.edu.booking.DTO.estadoreservasDTO;
import co.sena.edu.booking.DTO.estadorutasDTO;
import co.sena.edu.booking.DTO.estadousuariosDTO;
import co.sena.edu.booking.DTO.lugararrivosDTO;
import co.sena.edu.booking.DTO.nacionalidadesDTO;
import co.sena.edu.booking.DTO.paisesDTO;
import co.sena.edu.booking.DTO.personasDTO;
import co.sena.edu.booking.DTO.personaxreservasDTO;
import co.sena.edu.booking.DTO.reserDTO;
import co.sena.edu.booking.DTO.rutasDTO;
import co.sena.edu.booking.DTO.servespecialesDTO;
import co.sena.edu.booking.DTO.servespecrutaDTO;
import co.sena.edu.booking.DTO.serviciosDTO;
import co.sena.edu.booking.DTO.tiposerviciosDTO;
import co.sena.edu.booking.DTO.tipovehiculosDTO;
import co.sena.edu.booking.DTO.transportellegadasDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aprendiz
 */
public class booking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        reserDTO rdto = new reserDTO();
        reserDAO rdao = new reserDAO();
        conductoresDAO con = new conductoresDAO();
        conductoresDTO cond = new conductoresDTO();
        personasDAO per = new personasDAO();
        personasDTO pers = new personasDTO();
        ciudadesDAO ciu = new ciudadesDAO();
        ciudadesDTO ciud = new ciudadesDTO();
        empresatransportesDAO tra = new empresatransportesDAO();
        empresatransportesDTO tran = new empresatransportesDTO();
        estadorutasDAO es = new estadorutasDAO();
        estadorutasDTO est = new estadorutasDTO();
        lugararrivosDAO lu = new lugararrivosDAO();
        lugararrivosDTO lug = new lugararrivosDTO();
        tiposerviciosDTO ser = new tiposerviciosDTO();
        tiposerviciosDAO se = new tiposerviciosDAO();
        serviciosDTO serv = new serviciosDTO();
        serviciosDAO servi = new serviciosDAO();
        tipovehiculosDTO ve = new tipovehiculosDTO();
        tipovehiculosDAO veh = new tipovehiculosDAO();
        empresasDTO em = new empresasDTO();
        empresasDAO emp = new empresasDAO();
        estadoreservasDTO esr = new estadoreservasDTO();
        estadoreservasDAO estad = new estadoreservasDAO();
        estadousuariosDTO estd = new estadousuariosDTO();
        estadousuariosDAO estado = new estadousuariosDAO();
        nacionalidadesDTO nac = new nacionalidadesDTO();
        nacionalidadesDAO naci = new nacionalidadesDAO();
        paisesDTO pa = new paisesDTO();
        paisesDAO pas = new paisesDAO();
        personaxreservasDTO pxr = new personaxreservasDTO();
        personaxreservasDAO pexr = new personaxreservasDAO();
        rutasDTO ru = new rutasDTO();
        rutasDAO rut = new rutasDAO();
        servespecialesDTO sees = new servespecialesDTO();
        servespecialesDAO seres = new servespecialesDAO();
        servespecrutaDTO sert = new servespecrutaDTO();
        servespecrutaDAO srt = new servespecrutaDAO();
        transportellegadasDTO trans = new transportellegadasDTO();
        transportellegadasDAO transp = new transportellegadasDAO();

        Scanner entrada = new Scanner(System.in);
        int respuesta;
        Scanner in = new Scanner(System.in);
        Connection conexion = reserConex.getInstance();
        if (conexion != null) {
            System.out.println("Conectado");
        }
        System.out.println("..bienvenidos..");
        System.out.println("(1) Modificar");
        System.out.println("(2) Eliminar");
        System.out.println("(3) Insertar");

        respuesta = entrada.nextInt();

        switch (respuesta) {
            case 1:
                System.out.println("idReserva");
                rdto.setIdReserva(in.nextInt());
                System.out.println("EstadoReserva");
                rdto.setIdEstadoReserva(in.nextInt());
                System.out.println("idServicio");
                rdto.setIdServicio(in.nextInt());
                System.out.println("idTransporteLlegada");
                rdto.setIdTransporteLlegada(in.next());
                System.out.println("responsable");
                rdto.setResponsable(in.next());              
                System.out.println("horaReserva");
                rdto.setHoraReserva(in.next());
                System.out.println("fechaReserva");
                rdto.setFechaReserva(in.next());
                System.out.println("direccionDestino");
                rdto.setDireccionDestino(in.next());
                System.out.println(rdao.actualizarRegistro(rdto));

                break;
            case 2:

                System.out.println("idReserva");
                rdto.setIdReserva(in.nextInt());
                System.out.println(rdao.eliminar(rdto));
                break;
            case 3:
                System.out.println("idReserva");
                rdto.setIdReserva(in.nextInt());
                System.out.println("EstadoReserva");
                rdto.setIdEstadoReserva(in.nextInt());
                System.out.println("idservicio");
                rdto.setIdServicio(in.nextInt());
                System.out.println("idTransporteLlegada");
                rdto.setIdTransporteLlegada(in.next());
                System.out.println("Responsable");
                rdto.setResponsable(in.next());               
                System.out.println("fechaReserva");
                rdto.setFechaReserva(in.next());
                System.out.println("horaReserva");
                rdto.setHoraReserva(in.next());
                System.out.println("direccionDestino");
                rdto.setDireccionDestino(in.next());
                System.out.println(rdao.insertar(rdto));
                break;
            case 4:
                System.out.println("digite id");
                cond.setIdConductor(in.nextInt());
                System.out.println("digite id");
                cond.setIdpersona(in.nextInt());
                System.out.println("digite telefono");
                cond.setTelContacto(in.nextInt());
                System.out.println(con.crearConductor(cond));
                break;
            case 5:
                System.out.println("digite id");
                pers.setIdPersona(in.nextLong());
                System.out.println("digite correo");
                pers.setCorreoElectronico(in.next());
                System.out.println("digite residencia");
                pers.setPais(in.next());
                System.out.println("nacionalidad");
                pers.setIdNacionalidad(in.nextInt());
                System.out.println("nombres");
                pers.setNombres(in.next());
                System.out.println("apellidos");
                pers.setApellidos(in.next());
                System.out.println("fechaNto");
                pers.setFechaNto(in.next());
                System.out.println("telefono");
                pers.setTelefono(in.nextInt());
                System.out.println("contraseña");
                pers.setContraseña(in.nextInt());
                System.out.println(per.crearPersona(pers));
                break;
            case 6:
                System.out.println("id ciudad");
                ciud.setIdCiudad(in.next());
                System.out.println("ciudad");
                ciud.setCiudad(in.next());
                System.out.println("id");
                ciud.setidPais(in.next());
                System.out.println(ciu.crearCiudad(ciud));
                break;
            case 7:
                System.out.println("digite id");
                tran.setIdEmpresaTransporte(in.next());
                System.out.println("nombre");
                tran.setNombreEmpresaTransporte(in.next());
                System.out.println(tra.crearEmpresaTransportes(tran));
                break;
            case 8:
                System.out.println("id");
                est.setIdEstadoRuta(in.nextInt());
                System.out.println("estado");
                est.setEstadoRuta(in.next());
                System.out.println(es.crearEstadoRuta(est));
                break;
            case 9:
                System.out.println("id");
                lug.setIdLugarArrivo(in.nextInt());
                System.out.println("nombre");
                lug.setNombrePuerto(in.next());
                System.out.println(lu.crearLugarArrivo(lug));
                break;
            case 10:
                System.out.println("id");
                ser.setIdTipoServicio(in.nextInt());
                System.out.println("servicio");
                ser.setTipoServicio(in.next());
                System.out.println(se.crearTipoServicio(ser));
                break;
            case 11:

                System.out.println("id");
                serv.setIdServicio(in.nextInt());
                System.out.println("tipo");
                serv.setIdTipoServicio(in.nextInt());
                System.out.println("servicio");
                serv.setServicio(in.next());
                System.out.println(servi.crearServicio(serv));
                break;
            case 12:
                System.out.println("id");
                ve.setIdTipoVehiculo(in.nextInt());
                System.out.println("tipo");
                ve.setTipoVehiculo(in.next());
                System.out.println("modelo");
                ve.setModelo(in.nextInt());
                System.out.println("marca");
                ve.setMarca(in.next());
                System.out.println(veh.crearTipoVehiculo(ve));
                break;
            case 13:
                System.out.println("id");
                ve.setIdTipoVehiculo(in.nextInt());
                System.out.println("tipo");
                ve.setTipoVehiculo(in.next());
                System.out.println("modelo");
                ve.setModelo(in.nextInt());
                System.out.println("marca");
                ve.setMarca(in.next());
                System.out.println(veh.crearTipoVehiculo(ve));
                break;
            case 14:
                System.out.println("id");
                em.setIdEmpresa(in.next());
                System.out.println("nombre");
                em.setNombreEmpresa(in.next());
                System.out.println("ubicacion");
                em.setUbicacion(in.next());
                System.out.println("direccion");
                em.setDireccion(in.next());
                System.out.println("telefono");
                em.setTelefono(in.next());
                System.out.println("representante");
                em.setRepresentante(in.next());
                System.out.println("correo");
                em.setCorreoEmpresa(in.next());
                System.out.println(emp.crearEmpresa(em));
                break;
            case 15:
                System.out.println("id");
                esr.setIdestadoReserva(in.nextInt());
                System.out.println("estado");
                esr.setEstadoReserva(in.next());
                System.out.println(estad.crearEstadoReserva(esr));
                break;
            case 16:
                System.out.println("id");
                estd.setIdEstadoUsuario(in.nextInt());
                System.out.println("estado");
                estd.setEstado(in.next());
                System.out.println(estado.crearEstadoUsuario(estd));
                break;
            case 17:
                System.out.println("id");
                nac.setIdNacionalidad(in.nextInt());
                System.out.println("nacionalidad");
                nac.setNacionalidad(in.next());
                System.out.println(naci.crearNacionalidad(nac));
                break;
            case 18:
                System.out.println("id");
                pa.setIdPais(in.next());
                System.out.println("pais");
                pa.setPais(in.next());
                System.out.println("idioma");
                pa.setIdioma(in.next());
                System.out.println(pas.crearPais(pa));
                break;
            case 19:
                System.out.println("id");
                pxr.setIdPersonaXReservas(in.next());
                System.out.println("id");
                pxr.setIdReserva(in.nextInt());
                System.out.println("nroMaletas");
                pxr.setNroMaletas(in.nextInt());
                System.out.println("idpersona");
                pxr.setIdPersona(in.next());
                System.out.println(pexr.crearPersonaXReserva(pxr));
                break;
            case 20:
                System.out.println("id");
                ru.setIdRuta(in.nextInt());
                System.out.println("placavehi");
                ru.setPlacaVehiculo(in.next());
                System.out.println("idtipovehiculo");
                ru.setIdtipoVehiculo(in.nextInt());
                System.out.println("estado ruta");
                ru.setIdEstadoRuta(in.nextInt());
                System.out.println("idpersona");
                ru.setIdPersona(in.next());
                System.out.println("idconductor");
                ru.setIdConductor(in.next());
                System.out.println("idreserva");
                ru.setidReserva(in.nextInt());
                System.out.println(rut.crearRuta(ru));
                break;
            case 21:
                System.out.println("id");
                sees.setIdServEspecial(in.nextInt());
                System.out.println("servicio");
                sees.setServespecial(in.next());
                System.out.println(seres.crearServEspecial(sees));
                break;
            case 22:
                System.out.println("id servicio especial");
                sert.setIdservespxrutas(in.next());
                System.out.println("id");
                sert.setIdReserva(in.nextInt());
                System.out.println("id servicio");
                sert.setIdServEspecial(in.nextInt());
                System.out.println("descripcion");
                sert.setDespcripcion(in.next());
                System.out.println("cantidad");
                sert.setCantidad(in.nextInt());
                System.out.println(srt.crearServEspecialRuta(sert));
                break;
            case 23:
                System.out.println("id");
                trans.setIdTransporteLlegada(in.next());
                System.out.println("hora arrivo");
                trans.setHoraArrivo(in.next());
                System.out.println("hora salidad");
                trans.setHoraSalida(in.next());
                System.out.println("id lugar arrivo");
                trans.setIdLugarArrivo(in.nextInt());
                System.out.println("id empresa transporte");
                trans.setIdEmpresaTransporte(in.next());
                System.out.println(transp.crearTransporteLlegada(trans));
                break;
            case 24:

                System.out.println("digite id ciudad");
                ciud.setIdCiudad(in.next());
                System.out.println(ciu.ListarUno(ciud));
                break;
            case 25:
                ArrayList<ciudadesDTO> res = new ArrayList();
                res = ciu.listarTodo();

                for (ciudadesDTO c : res) {
                    System.out.println("\n" + c);
                }
                break;
            case 26:
                System.out.println("id conductor");
                cond.setIdConductor(in.nextInt());
                System.out.println(con.ListarUno(cond));
                break;
            case 27:
                ArrayList<conductoresDTO> cod = new ArrayList();
                cod = (ArrayList<conductoresDTO>) con.listarCoductores();

                for (conductoresDTO t : cod) {
                    System.out.println("\n" + t);
                }
                break;
            case 28:
                System.out.println("id empresa");
                em.setIdEmpresa(in.next());
                System.out.println(emp.ListarUno(em));
                break;
            case 29:
                ArrayList<empresasDTO> empre = new ArrayList();
                empre = (ArrayList<empresasDTO>) emp.listarEmpresas();
                for (empresasDTO e : empre) {
                    System.out.println("\n" + e);
                }
                break;
            case 30:
                System.out.println(" id empresa transporte");
                tran.setIdEmpresaTransporte(in.next());
                System.out.println(tra.ListarEmpresa(tran));
                break;
            case 31:
                ArrayList<empresatransportesDTO> empret = new ArrayList();
                empret = (ArrayList<empresatransportesDTO>) tra.listarEmpresaTransportes();
                for (empresatransportesDTO t : empret) {
                    System.out.println("\n" + t);
                }
                break;
            case 32:
                System.out.println("id empresa estado reserva");
                esr.setIdestadoReserva(in.nextInt());
                System.out.println(estad.ListarUnEstado(esr));
                break;
            case 33:
                ArrayList<estadoreservasDTO> str = new ArrayList();
                str = (ArrayList<estadoreservasDTO>) estad.listarEstadoReservas();
                for (estadoreservasDTO sr : str) {
                    System.out.println("\n" + sr);
                }
                break;
            case 34:
                System.out.println("id estado ruta");
                est.setIdEstadoRuta(in.nextInt());
                System.out.println(es.ListarUnaRuta(est));
                break;
            case 35:
                ArrayList<estadorutasDTO> stru = new ArrayList();
                stru = (ArrayList<estadorutasDTO>) es.listarEstadosRutas();
                for (estadorutasDTO srtas : stru) {
                    System.out.println("\n" + srtas);
                }
                break;
            case 36:
                System.out.println("id estado usuario");
                estd.setIdEstadoUsuario(in.nextInt());
                System.out.println(estado.ListarUnUsuario(estd));
                break;
            case 37:
                ArrayList<estadousuariosDTO> stu = new ArrayList();
                stu = (ArrayList<estadousuariosDTO>) estado.listarUsuarios();
                for (estadousuariosDTO su : stu) {
                    System.out.println("\n" + su);
                }
                break;
            case 38:
                System.out.println("id lugar arrivo");
                lug.setIdLugarArrivo(in.nextInt());
                System.out.println(lu.ListarUno(lug));
                break;
            case 39:
                ArrayList<lugararrivosDTO> lua = new ArrayList();
                lua = (ArrayList<lugararrivosDTO>) lu.listarTodos();
                for (lugararrivosDTO luar : lua) {
                    System.out.println("\n" + luar);
                }
                break;
            case 40:
                System.out.println("id nacionalidad");
                nac.setIdNacionalidad(in.nextInt());
                System.out.println(naci.ListarUnaNacionalidad(nac));
                break;
            case 41:
                ArrayList<nacionalidadesDTO> nai = new ArrayList();
                nai = (ArrayList<nacionalidadesDTO>) naci.listarNacionalidades();
                for (nacionalidadesDTO nas : nai) {
                    System.out.println("\n" + nas);
                }
                break;
            case 42:
                System.out.println("id pais");
                pa.setIdPais(in.next());
                System.out.println(pas.ListarUnPais(pa));
                break;
            case 43:
                ArrayList<paisesDTO> pai = new ArrayList();
                pai = (ArrayList<paisesDTO>) pas.listarPaises();
                for (paisesDTO ps : pai) {
                    System.out.println("\n" + ps);
                }
                break;
            case 44:
                System.out.println("id persona");
                pers.setIdPersona(in.nextLong());
                long cedula=0;
                System.out.println(per.ListarUnaPersona(cedula));
                break;
            case 45:
                ArrayList<personasDTO> perso = new ArrayList();
                perso = (ArrayList<personasDTO>) per.listarPersonas();
                for (personasDTO pe : perso) {
                    System.out.println("\n" + pe);
                }
                break;
            case 46:
                System.out.println("id persoan x reserva");
                pxr.setIdPersonaXReservas(in.next());
                System.out.println(pexr.ListarUnaPersonaReserva(pxr));
                break;
            case 47:
                ArrayList<personaxreservasDTO> perxr = new ArrayList();
                perxr = (ArrayList<personaxreservasDTO>) pexr.listarPersonasXReserva();
                for (personaxreservasDTO px : perxr) {
                    System.out.println("\n" + px);
                }
                break;
//            case 48:
//                System.out.println("id reserva");
//                rdto.setIdReserva(in.nextInt());
//                System.out.println(rdao.);
//                break;
            case 49:
                ArrayList<reserDTO> re = new ArrayList();
                re = (ArrayList<reserDTO>) rdao.listarReservas();
                for (reserDTO sre : re) {
                    System.out.println("\n" + sre);
                }
                break;
            case 50:
                System.out.println("id rutas");
                ru.setIdRuta(in.nextInt());
                System.out.println(rut.ListarUnaRuta(ru));
                break;
            case 51:
                ArrayList<rutasDTO> rua = new ArrayList();
                rua = (ArrayList<rutasDTO>) rut.listarRutas();
                for (rutasDTO tas : rua) {
                    System.out.println("\n" + tas);
                }
                break;
            case 52:
                System.out.println("id servicio");
                sees.setIdServEspecial(in.nextInt());
                System.out.println(seres.ListarUnServicio(sees));
                break;
            case 53:
                ArrayList<servespecialesDTO> sel = new ArrayList();
                sel = (ArrayList<servespecialesDTO>) seres.listarServicios();
                for (servespecialesDTO fac : sel) {
                    System.out.println("\n" + fac);
                }
                break;
            case 54:
                System.out.println("id servicio por ruta");
                sert.setIdservespxrutas(in.next());
                System.out.println(srt.ListarUnSerRuta(sert));
                break;
            case 55:
                ArrayList<servespecrutaDTO> sepx = new ArrayList();
                sepx = (ArrayList<servespecrutaDTO>) srt.listarServcioESpecialRuta();
                for (servespecrutaDTO spx : sepx) {
                    System.out.println("\n" + spx);
                }
                break;
            case 56:
                System.out.println("id servicio");
                serv.setIdServicio(in.nextInt());
                System.out.println(servi.ListarUnServicio(serv));
                break;
            case 57:
                ArrayList<serviciosDTO> cio = new ArrayList();
                cio = servi.listarServicios();
                for (serviciosDTO vi : cio) {
                    System.out.println("\n" + vi);
                }
            case 61:
                System.out.println("id Ciudad");
                ciud.setIdCiudad(in.next());
                System.out.println(ciu.eliminar(ciud));
                break;
            case 62:
                System.out.println("idConductores");
                cond.setIdConductor(in.nextInt());
                System.out.println(con.eliminar(cond));

                break;
            case 63:
                System.out.println("idEmpresas");
                em.setIdEmpresa(in.next());
                System.out.println(emp.eliminar(em));

                break;
            case 64:
                System.out.println("IdEmpresaTransporte");
                tran.setIdEmpresaTransporte(in.next());
                System.out.println(tra.eliminar(tran));

                break;
            case 65:
                System.out.println("IdestadoReserva");
                esr.setIdestadoReserva(in.nextInt());
                System.out.println(estad.eliminar(esr));

                break;
            case 66:
                System.out.println("idEstadoRutas");
                est.setIdEstadoRuta(in.nextInt());
                System.out.println(es.eliminar(est));

                break;
            case 67:
                System.out.println("idEstadoUsuarios");
                estd.setIdEstadoUsuario(in.nextInt());
                System.out.println(estado.eliminar(estd));

                break;
            case 68:
                System.out.println("idLugaArrivo");
                lug.setIdLugarArrivo(in.nextInt());
                System.out.println(lu.eliminar(lug));

                break;
            case 69:
                System.out.println("idNacionalidades");
                nac.setIdNacionalidad(in.nextInt());
                System.out.println(naci.eliminar(nac));
                break;
            case 70:
                System.out.println("idPais");
                pa.setIdPais(in.next());
                System.out.println(pas.eliminar(pa));
                break;
            case 71:
                System.out.println("idPersona");
                pers.setIdPersona(in.nextLong());
                long cedu=0;
                System.out.println(per.eliminar(cedu));
                break;
            case 72:
                System.out.println("idPersonaXReservas");
                pxr.setIdPersonaXReservas(in.next());
                System.out.println(pexr.eliminar(pxr));
                break;
            case 73:
                System.out.println("idReserva");
                rdto.setIdReserva(in.nextInt());
                System.out.println(rdao.eliminar(rdto));
                break;
            case 74:
                System.out.println("idRuta");
                ru.setIdRuta(in.nextInt());
                System.out.println(rut.eliminar(ru));
                break;
            case 75:
                System.out.println("idServespecial");
                sees.setIdServEspecial(in.nextInt());
                System.out.println(seres.eliminar(sees));
                break;
            case 76:
                System.out.println("idServespeRuta");
                sert.setIdservespxrutas(in.next());
                System.out.println(srt.eliminar(sert));
                break;
            case 77:
                System.out.println("idServicios");
                serv.setServicio(in.next());
                System.out.println(servi.eliminar(serv));
                break;
            case 78:
                System.out.println("idTipoServicios");
                ser.setIdTipoServicio(in.nextInt());
                System.out.println(se.eliminar(ser));
                break;
            case 79:
                System.out.println("idTpoVehiculo");
                ve.setIdTipoVehiculo(in.nextInt());
                System.out.println(veh.eliminar(ve));
                break;
            case 80:
                System.out.println("idTransporteLlegada");
                trans.setIdTransporteLlegada(in.next());
                System.out.println(transp.eliminar(trans));
                break;

        }
    }
}
