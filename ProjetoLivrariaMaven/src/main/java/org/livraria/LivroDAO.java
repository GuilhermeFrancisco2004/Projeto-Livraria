package org.livraria;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LivroDAO{

    public void inserirLivro (String titulo,String autor,double preco){
        String sql= "INSERT INTO livros (titulo,autor,preco) VALUES (?,?,?)";

        try {
            Connection conn = Conexao.conectar();

            if (conn == null) {
                throw new RuntimeException("Falha ao conectar ao banco de dados: conexão nula");
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, titulo);
                stmt.setString(2, autor);
                stmt.setDouble(3, preco);

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Livro inserido com sucesso!");
                } else {
                    System.out.println("Nenhuma linha inserida.");
                }
            } finally {
                try { conn.close(); } catch (Exception ex) { /* ignore */ }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro ao inserir livro: "+e.getMessage());
        }
    }
}

