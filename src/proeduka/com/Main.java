package proeduka.com;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
	// write your code here

        try{
            //1. CREAR CONEXION CON BSD
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursosql","root","");
            //2. CREAR OBJETO STATEMENT
            Statement miStatement=miConexion.createStatement();
            //3. EJECUTAR SQL
            ResultSet miResultset=miStatement.executeQuery("SELECT * FROM productos WHERE SECCIÓN='DEPORTES' OR SECCIÓN='CERÁMICA' ORDER BY SECCIÓN, PAÍSDEORIGEN, PRECIO");
            //4. RECORRER EL RESULSET
            while (miResultset.next()){
                System.out.println("Codigo: "+miResultset.getString("CÓDIGOARTÍCULO")
                        +" Seccion: "+miResultset.getString("SECCIÓN")
                        +" Nombre: "+miResultset.getString("NOMBREARTÍCULO"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
