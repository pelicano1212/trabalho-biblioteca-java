/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LivrosDAO;
import Model.Livros;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class LivrosController {

    public boolean Salvar(Livros produto) {
        LivrosDAO prodDAO = new LivrosDAO();
        return prodDAO.salvar(produto);
    }
    public List<Livros> listaLivros(String param){
        LivrosDAO livrosDAO = new LivrosDAO();
        return livrosDAO.listaLivros(param);
    }
    public boolean alterar(Livros livro){
        LivrosDAO livrosDAO = new LivrosDAO();
        return livrosDAO.alterar(livro);
    }
    
    public boolean validaLivros(Long id){
        LivrosDAO livrosDAO = new LivrosDAO();
        return livrosDAO.validaLivro(id);
    }

    public boolean excluir(Long isbn) {
        LivrosDAO livrosDAO = new LivrosDAO();
        return livrosDAO.excluirLivros(isbn);
    }
}
