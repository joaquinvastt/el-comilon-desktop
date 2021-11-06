/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package el.comilon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SQLclass {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@DESKTOP-UQRDMT2:1521:XE";
    private final String USER = "COMILONBD";
    private final String PASWORD = "1234";

    public Connection cadena;

    public SQLclass() {
         this.cadena = null;
    }

    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL, USER, PASWORD);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;

    }

    public void desconectar() {
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    

}
   
