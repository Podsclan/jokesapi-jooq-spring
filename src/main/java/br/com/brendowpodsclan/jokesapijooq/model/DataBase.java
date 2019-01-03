package br.com.brendowpodsclan.jokesapijooq.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/libraryjokes";
    private static Connection con = null;
    private static String USER = "";
    private static final String PWD = "";
    private static DataBase instance = null;

    private DataBase() throws SQLException {

        try {
            con = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conectado!");
        }
        catch (SQLException e){

            System.out.println("Erro" + e);
        }
    }

    public static Connection getConnection(){

        try {
            if(instance == null || (con.isClosed()))
                instance = new DataBase();

        }
        catch (SQLException e) {
            System.out.println("Erro:"+e);
        }
        return con;
    }

}
