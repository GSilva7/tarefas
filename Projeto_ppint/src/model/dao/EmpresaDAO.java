package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.javabean.Empresa;

public class EmpresaDAO
{
	
   public void consultarEmpresa(Empresa empresa)
   {
      String sqlSelect = "SELECT * FROM Empresa WHERE cnpj = ?";
      try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);)
      {
         stm.setInt(1, empresa.getCnpj());
         try(ResultSet rs = stm.executeQuery();)
         {
        	 if(rs.next())
        	 {
        		 empresa.setCnpj(rs.getInt(1));
        		 empresa.setRazaosocial(rs.getString(2));
        		 empresa.setHorarioAbertura(rs.getTime(3));
        		 empresa.setHorarioFechamento(rs.getTime(4));
        		 conn.commit();
        	 } else
        	 {
        		 empresa.setCnpj(-1);
        		 empresa.setRazaosocial(null);
        		 empresa.setHorarioAbertura(null);
        		 empresa.setHorarioFechamento(null);
        	 }
         }
         catch(SQLException e)
         {
        	 e.printStackTrace();
         }
      }
      catch (Exception e1)
      {
         System.out.println(e1.getStackTrace());
      }
      
   }
   
   
   
   public void cadastrarEmpresa(Empresa empresa)
   {
      String sqlInsert = "INSERT INTO Empresa (razaoSocial, horarioAbertura, horarioFechamento) VALUES (?, ?, ?)";
      try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stm = conn.prepareStatement(sqlInsert);)
      {
         stm.setString(1, empresa.getRazaosocial());         
         stm.setTime(2, empresa.getHorarioAbertura()); 
         stm.setTime(3, empresa.getHorarioFechamento());
         stm.execute();
         String sqlQuery = "SELECT LAST_INSERT_ID()";
         try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();)
         {
        	 if(rs.next())
        		 empresa.setCnpj(rs.getInt(1));
         }
         catch(SQLException e)
         {
        	 e.printStackTrace();
         }
         
      }
      
      catch(SQLException e)
            {
                e.printStackTrace();
            }
   
   }// método cadastrar
   
   
   
   public void excluirEmpresa(Empresa empresa)
   {
      String sqlDelete = "DELETE FROM Empresa WHERE cnpj = ?";

      try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stm = conn.prepareStatement(sqlDelete);)
      {
         stm.setInt(1, empresa.getCnpj());
         stm.execute();
      }
      
      
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }//metodo excluir
   
   
   public void alterarEmpresa(Empresa empresa)
   {
      String sqlAltera = "UPDATE Empresa SET razaoSocial = ?, horarioAbertura = ? , horarioFechamento = ? where cnpj = ?";
      
      try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stm = conn.prepareStatement(sqlAltera);)
      {
         stm.setString(1, empresa.getRazaosocial());
         stm.setTime(2, empresa.getHorarioAbertura());
         stm.setTime(3, empresa.getHorarioFechamento());
         stm.setInt(4, empresa.getCnpj());
         
         stm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   
        
}//class
