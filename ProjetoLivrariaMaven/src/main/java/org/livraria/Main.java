package org.livraria;

public class Main {
    public static void  main(String[] args) {
         LivroDAO dao =new LivroDAO();

         //dao.inserirLivro("Harry Potter","J.K. Rowling",53.39);
         //dao.inserirLivro("O Pequeno Principe","Antoine de Sant-Exupéry e Isolina Bresolin Vianna",15.58);
        dao.inserirLivro("Algum titulo","Fulano", 10.00);

        ListarLivros lista = new ListarLivros();
        lista.listar();
    }
}