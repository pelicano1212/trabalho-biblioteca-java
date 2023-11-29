/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ConexaoDB {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(con == null){
                con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            }
            return con;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro com Drive de conexão. "+ex.getMessage());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao conectar com o banco de dados. "+ex.getMessage());
        }
        return null;
    }
}