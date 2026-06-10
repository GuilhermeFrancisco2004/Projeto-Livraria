package org.livraria;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{

    public static Connection conectar(){
        try {
            String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/livraria_db");
            String user = System.getenv().getOrDefault("DB_USER", "root");
            String password = System.getenv().getOrDefault("DB_PASS", "123456789");

            return DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}

