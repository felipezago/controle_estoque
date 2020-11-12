/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.dao;

import br.com.lz.domain.Fabricante;
import br.com.lz.domain.Veiculo;
import br.com.lz.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class FabricanteDAO {
    public static void inserir(Fabricante fab) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into fabricante(nome_fabricante) values (?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1, fab.getNome());
        stmt.execute();
        stmt.close();
        con.close();
    }
   
    public static void alterar(Fabricante fab) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update fabricante set nome_fabricante= ?"
                + "where id_fabricante = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, fab.getNome());
        stmt.setInt(2, fab.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();                
    }
    
    public static void excluir(Fabricante fab) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql="delete from fabricante where id_fabricante= ?";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setInt(1, fab.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Fabricante> pesquisar() throws SQLException{
        List<Fabricante> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from fabricante";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Fabricante f= new Fabricante();
            f.setNome(rs.getString("nome_fabricante"));
            f.setId(rs.getInt("id_fabricante"));
            listaUsu.add(f);
        }
        
        System.out.println(listaUsu.toString());
        stmt.close();
        con.close();
        return listaUsu;

    }
    
    public static List<Fabricante> pesquisar(Fabricante fab) throws SQLException{
        List<Fabricante> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from fabricante where "
                + "nome_fabricante like '%"+fab.getNome()+"%'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Fabricante f= new Fabricante();
            f.setNome(rs.getString("nome_fabricante"));
            f.setId(rs.getInt("id_fabricante"));
            listaUsu.add(f);
        }
        
        System.out.println(listaUsu.toString());
        stmt.close();
        con.close();
        return listaUsu;

    }
    
    public static void main(String[] args) {
        Fabricante f= new Fabricante();
        
        f.setNome("Cu");
        
        try {
            inserir(f);
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
