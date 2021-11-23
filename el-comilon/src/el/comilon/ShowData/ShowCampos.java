/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package el.comilon.ShowData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Timestamp;

import java.awt.Toolkit;
import java.util.concurrent.*;

import el.comilon.SQLclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Joaquin
 */
public class ShowCampos implements Runnable {
    
    public void run() {
        
        String sSQL = "";
        SQLclass conexion = new SQLclass();

        try {
            sSQL = "SELECT * FROM cliente";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            
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
            
            int ID = cst.getInt(1);
            int montoProm = cst.getInt(2);
            int cantVentas = cst.getInt(3);
            int cantReclamo = cst.getInt(4);
            int cantReclamoPend = cst.getInt(5);
            int cantReclamoResu = cst.getInt(6);
            String calidadReclamo = cst.getString(7);
            int cantPedFinalizado = cst.getInt(8);
            int cantPedCancelado = cst.getInt(9);
            Timestamp fecha =  cst.getTimestamp(10);
            
            LocalDateTime fechaReporte = fecha.toLocalDateTime();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd-MM-YYYY HH:mm:ss a");
            
            String dateTimeString = fechaReporte.format(formatter);
            
            
            System.out.print(dateTimeString+"\n");
            System.out.print("-----\n");
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new ShowCampos();
        int initialDelay = 0;
        int periodicDelay = 1;
        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
                TimeUnit.MINUTES
        );
        
    }
}
