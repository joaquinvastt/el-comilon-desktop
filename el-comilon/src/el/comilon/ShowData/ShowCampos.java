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

import el.comilon.SQLclass;

/**
 *
 * @author Joaquin
 */
public class ShowCampos {

    public static void main(String[] args) {
        String sSQL = "";
        SQLclass conexion = new SQLclass();

        try {
            sSQL = "SELECT * FROM cliente";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

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

            while (res.next()) {
                System.out.println("---------------------");
                System.out.println("ID: " + cst.getInt(1));
                System.out.println(cst.getInt(2));
                System.out.println(cst.getInt(3));
                System.out.println(cst.getInt(4));
                System.out.println(cst.getInt(5));
                System.out.println(cst.getInt(6));
                System.out.println(cst.getString(7));
                System.out.println(cst.getInt(8));
                System.out.println(cst.getInt(9));
                System.out.println(cst.getTimestamp(10));
                System.out.println("---------------------");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }}
