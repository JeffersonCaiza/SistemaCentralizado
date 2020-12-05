package com.mycompany.sistemacentralizado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author xtratech
 */
public class Test {
    
    public static void main(String[] args){
        Test t=new Test();
        t.insertar(1,"Pera",19.99);
    
    }
    
    public Connection getConexion(){
    Connection conexion=null;
    String servidor="localhost";
    String puerto="5432";
    String baseDatos="supermercado1";
    String url="jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDatos;
    String usuario="postgres";
    String clave="12345";
    try {
        conexion=DriverManager.getConnection(url,usuario,clave);
    }catch (SQLException ex){
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
    }
    return conexion;
    
    }
    
     public void insertar(double codigo, String nombre, double precio){
        Connection conexion=getConexion();
        String sql = "INSERT INTO productos values (" + codigo + ",'" + nombre +"','" + precio + "')";
        try (Statement st=conexion.createStatement()){
         st.executeUpdate(sql);
        }catch (Exception e){
                e.printStackTrace();
                }
        
    }
     
     
     public void actualizar(double codigo, String nombre, double precio){
        Connection conexion=getConexion();
        String sql="UPDATE productos SET" + "nombre='" + nombre + ",precio=" + precio + "WHERE codigo=" + codigo;
        try (Statement st=conexion.createStatement()){
         st.executeUpdate(sql);
        }catch (Exception e){
                e.printStackTrace();
                }
        
    }
     
     public void eliminar(double codigo){
        Connection conexion=getConexion();
        String sql="DELETE FROM productos WHERE codigo = "+ codigo;
        try (Statement st=conexion.createStatement()){
         st.executeUpdate(sql);
        }catch (Exception e){
                e.printStackTrace();
                }
     }
    
    
        
    
}
