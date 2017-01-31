package proeduka.com;

import java.sql.*;

public class ConsultaPreparada {

    public  static void main (String[] arg){

        try{
            //1. CREAR CONEXION CON BSD
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursosql","root","");
            //2. CREAR OBJETO STATEMENT
            PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");

            //3. ESTABLECER PARAMETROS de consulta

            miSentencia.setString(1,"DEPORTES");
            miSentencia.setString(2, "USA");

            //4. EJECUTAR Y CORRER CONSULTA

            ResultSet miRS=miSentencia.executeQuery();

            while (miRS.next()){
                System.out.println(miRS.getString(1)+" "
                        +miRS.getString(2)+" "
                        +miRS.getString(3));
            }

            miRS.close();

            //REUTILIZACION DE CONSULTA

            System.out.println("Segunda Consulta");

            //3. ESTABLECER PARAMETROS de consulta

            miSentencia.setString(1,"CERÁMICA");
            miSentencia.setString(2, "CHINA");

            //4. EJECUTAR Y CORRER CONSULTA

            miRS=miSentencia.executeQuery();

            while (miRS.next()){
                System.out.println(miRS.getString(1)+" "
                        +miRS.getString(2)+" "
                        +miRS.getString(3));
            }

            miRS.close();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
