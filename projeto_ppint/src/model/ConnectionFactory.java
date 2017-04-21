package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory
{
 
 static
 {
    try
    {
       Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException e)
    {
       throw new RuntimeException(e);
    }
 }
 
 // -----------------------------------------------------------
 // Obtém conexão com o banco de dados
 public Connection getConnection() throws SQLException
 {
    return DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/SCP?user=alunos&password=alunos");
 }
}