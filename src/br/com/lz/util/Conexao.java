package br.com.lz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class Conexao {
    
    public static Connection getConexao()throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver"); //driver de conexão com BD MySql
            return(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/controleestoque", "root", "root"); //parametros de conexão
            
        }catch(ClassNotFoundException ex){
            throw new SQLDataException(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        try{
            getConexao();
            System.out.println("Conexão estabelecida");
        }catch(SQLException ex){
            System.out.println("Conexao não realizada, verificar log.");
            ex.printStackTrace();
        }
    }
    
}
