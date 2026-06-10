package org.livraria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListarLivros{
    public void listar(){
     String sql = "SELECT * FROM livros";

     try {
         Connection conn = Conexao.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);

         while (rs.next()){
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Titulo: "+rs.getString("titulo"));
            System.out.println("Autor: "+rs.getString("autor"));
            System.out.println("preço: "+rs.getDouble("preco"));
            System.out.println("---------------");
            }
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}       