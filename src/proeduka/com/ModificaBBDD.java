package proeduka.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

    public static void main (String[] args){
        try{
            //1. CREAR CONEXION CON BSD
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursosql","root","");
            //2. CREAR OBJETO STATEMENT
            Statement miStatement=miConexion.createStatement();

            String instruccionSQL="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";
            miStatement.executeUpdate(instruccionSQL);

            System.out.print("Datos Eliminados");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
