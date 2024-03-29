
package p3;

import p2.PlanPostPagoMegas;
import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Enlace2M {
    
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/PlanPostPago.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarPlanPostPagoMegas(PlanPostPagoMegas c) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMegas (Nombre,"
                    + "Cedula, Ciudad, Marca, Modelo, Numero, Gigas, CostoXGiga,"
                    + "Tarifa, PagoMensual)"
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%d',"
                    + "%s, %s, %s)", 
                    c.obtenerNombre(), c.obtenerCedula(), 
                    c.obtenerCiudad(), c.obtenerMarca(), 
                    c.obtenerModelo(), c.obtenerNumero(), 
                    c.obtenerGigas(), c.obtenerCostoGiga(),
                    c.obtenerTarifaBase(), c.obtenerPagoMensual());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
            
        } catch (SQLException e) {  
             System.err.println("ERROR: no se pudo insertar PlanPostPagoMegas");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<PlanPostPagoMegas> obtenerDataPppMegas() {  
        ArrayList<PlanPostPagoMegas> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMegas;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                
                PlanPostPagoMegas miPppm = new PlanPostPagoMegas(
                rs.getInt("Gigas"), rs.getDouble("CostoXGiga"), 
                rs.getDouble("Tarifa"), rs.getString("Nombre"),
                rs.getString("Cedula"), rs.getString("Ciudad"),
                rs.getString("Marca"), rs.getString("Modelo"),
                rs.getString("Numero"));
                lista.add(miPppm);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("ERROR: no se pudo obtener PlanPostPagoMegas");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
     
}  
