/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Cami
 */
public class Conexion {
     public static Connection getConexion() throws ConexionException{
        Connection con=null;
        try{
            String driverClassName="com.mysql.jdbc.Driver";
            String driverUrl="jdbc:mysql://localhost/solemne1";
            Class.forName(driverClassName);
            con= DriverManager.getConnection(driverUrl,"root","");
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new ConexionException("error al conectar la BD: "+e.getMessage());
        }
        return con;
    }    
}
