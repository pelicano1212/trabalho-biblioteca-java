/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Livros;
import db.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class LivrosDAO {
    private Connection con;  
    private PreparedStatement stm; 
    private ResultSet rs; 
    
    public boolean salvar(Livros livro){
        try{
            String sql = "insert into livros values(?,?,?,?,?,?)";
            con = ConexaoDB.getConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, livro.getIsbn());
            stm.setString(2, livro.getTitulo());
            stm.setString(3, livro.getDescricao());
            stm.setString(4, livro.getAutor());
            stm.setString(5, livro.getGenero());
            stm.setInt(6, livro.getAno());
            stm.execute();
                return true;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public List<Livros> listaLivros(String param) {
        try{
            String sql = "";
            if(param.equals("todos")){
                sql = "select * from livros";
            }else {
                sql = "select * from livros where livros like '%"+param+"%'";
            }
            
            con = ConexaoDB.getConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            Livros livros = null;
            List<Livros> lista = new ArrayList<>();
            while(rs.next()){
                livros = new Livros();
                livros.setIsbn(rs.getInt("isbn"));
                livros.setTitulo(rs.getString("titulo"));
                livros.setDescricao(rs.getString("descricao"));
                livros.setAutor(rs.getString("autor"));
                livros.setGenero(rs.getString("genero"));
                livros.setAno(rs.getInt("ano"));
                lista.add(livros);
            }
            return lista;
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } return null;
    }
    public boolean validaLivro(Long id){
        try{
            String sql = "select * from livros where codigo = ?";
            con = ConexaoDB.getConnection();
            stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            System.out.println(stm.executeQuery());
            if(stm.executeQuery().equals("")){
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao validar o livro"+
                    ex.getMessage());
        }
        return false;
    }

    public boolean alterar(Livros livro) {
        try{
            String sql = "update livros set titulo = ?,descricao = ?,autor = ?,genero = ?,ano = ? where isbn = ?";
            con = ConexaoDB.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, livro.getTitulo());
            stm.setString(2, livro.getDescricao());
            stm.setString(3, livro.getAutor());
            stm.setString(4, livro.getGenero());
            stm.setInt(5, livro.getAno());
            stm.setInt(6, livro.getIsbn());
            stm.execute();
                return true;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public boolean excluirLivros(Long id) {
        try{
            String sql = "delete from livros where isbn = ?";
            con = ConexaoDB.getConnection();
            stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            stm.execute();
                return true;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
}


