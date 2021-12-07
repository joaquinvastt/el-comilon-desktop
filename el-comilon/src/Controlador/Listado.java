/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Reporte;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Timestamp;

import java.awt.Toolkit;
import java.util.concurrent.*;

import el.comilon.BD.SQLclass;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class Listado {

    public ArrayList<Reporte> buscarTodosLibros() {
        ArrayList<Reporte> lista = new ArrayList<Reporte>();
        SQLclass conexion = new SQLclass();

        try {

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            CallableStatement cstIN = con.prepareCall("{call SP_INSERT_REPORTE()}");

            cstIN.execute();

            CallableStatement cst = con.prepareCall("{call OBTENER_REPORTE (?,?,?,?,?,?,?,?,?,?)}");

            cst.registerOutParameter(1, java.sql.Types.INTEGER);
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.registerOutParameter(4, java.sql.Types.INTEGER);
            cst.registerOutParameter(5, java.sql.Types.INTEGER);
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            cst.registerOutParameter(7, java.sql.Types.VARCHAR);
            cst.registerOutParameter(8, java.sql.Types.INTEGER);
            cst.registerOutParameter(9, java.sql.Types.INTEGER);
            cst.registerOutParameter(10, java.sql.Types.TIMESTAMP);

            cst.execute();

            Reporte reporte = new Reporte();

            reporte.setId(cst.getInt(1));
            reporte.setMontoPromVentas(cst.getInt(2));
            reporte.setCantidadVentas(cst.getInt(3));
            reporte.setCantidadReclamos(cst.getInt(4));
            reporte.setCantidadReclamosPendientes(cst.getInt(5));
            reporte.setCantidadReclamosResueltos(cst.getInt(6));
            reporte.setCalidadReclamo(cst.getString(7));
            reporte.setCantidadPedidofinalizado(cst.getInt(8));
            reporte.setCantidadPedidoCancelado(cst.getInt(9));

            Timestamp fecha = cst.getTimestamp(10);

            LocalDateTime fechaReporte = fecha.toLocalDateTime();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "dd-MM-YYYY HH:mm:ss a");

            String dateTimeString = fechaReporte.format(formatter);

            reporte.setFecha(dateTimeString);

            lista.add(reporte);

        } catch (Exception e) {
            System.out.println("Error al obtener reporte " + e.getMessage());

        }

        return lista;
    }
}
