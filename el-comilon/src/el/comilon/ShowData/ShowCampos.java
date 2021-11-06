/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package el.comilon.ShowData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

            while (res.next()){
                System.out.println("---------------------");
                System.out.println(res.getString("RUTCLIENTE"));
                System.out.println(res.getString("NOMBRES"));
                System.out.println(res.getString("APELLIDOS"));
                System.out.println(res.getString("DIRECCION"));
                System.out.println(res.getString("IDTIPOCLIENTE"));
                System.out.println("---------------------");
            }
        } catch(SQLException e){
            System.out.println(e);
        }


    }
    
    
}
