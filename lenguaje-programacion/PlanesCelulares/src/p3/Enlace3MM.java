
package p3;

import p2.PlanPostPagoMinMeg;
import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Enlace3MM {
    
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
    
    public void insertarPlanPostPagoMinMeg(PlanPostPagoMinMeg c) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegas (Nombre,"
                    + "Cedula, Ciudad, Marca, Modelo, Numero, Minutos, CostoXMinuto,"
                    + "Gigas, CostoXGiga, PagoMensual)"
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%d',"
                    + "%s, '%d', %s, %s)", 
                    c.obtenerNombre(), c.obtenerCedula(), 
                    c.obtenerCiudad(), c.obtenerMarca(), 
                    c.obtenerModelo(), c.obtenerNumero(), 
                    c.obtenerMin(), c.obtenerCostoMin(),
                    c.obtenerGigas(), c.obtenerCostoGiga(),
                    c.obtenerPagoMensual());
            statement.executeUpdate(data);
            obtenerConexion().close();
            
        } catch (SQLException e) {  
             System.err.println("ERROR: no se pudo insertar PlanPostPagoMinMeg");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<PlanPostPagoMinMeg> obtenerDataPppmm() {
        
        ArrayList<PlanPostPagoMinMeg> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegas;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                
                PlanPostPagoMinMeg miPppmm = new PlanPostPagoMinMeg(
                rs.getInt("Minutos"), rs.getDouble("CostoXMinuto"),
                rs.getInt("Gigas"), rs.getDouble("CostoXGiga"), 
                rs.getString("Nombre"), rs.getString("Cedula"), 
                rs.getString("Ciudad"), rs.getString("Marca"),
                rs.getString("Modelo"), rs.getString("Numero"));
                lista.add(miPppmm);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("ERROR: no se pudo obtener PlanPostPagoMinMeg");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
     
}  
