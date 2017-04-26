package model.dao;

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
    	e.printStackTrace();
		throw new RuntimeException("Driver de JDBC não encontrado!");
    }
 }
 
 // -----------------------------------------------------------
 // Obtém conexão com o banco de dados
 public static Connection getConnection() throws SQLException
 {
    return DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/SCP?user=alunos&password=alunos");
 }
}