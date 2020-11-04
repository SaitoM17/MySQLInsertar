package Insertar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLInsertar {
    public static void main(String[] args){
        
        String url = "jdbc:mysql://localhost:3306/libreriadb?useSSL=false";
        String user = "root";
        String password = "";
        
        String autor = "Trygve Gulbranssen";
        String sql = "INSERTAR INTO Autores(Nombres) VALUES(?)";
        
        try(Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(sql)){
            pst.setString(1, autor);
            pst.executeUpdate();
            System.out.println("Un nuevo autor ha sido insertado");
        }catch(SQLException ex){
            Logger lgr = Logger.getLogger(MySQLInsertar.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}