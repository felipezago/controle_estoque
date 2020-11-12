/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.dao;

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
public class VeiculoDAO {
     public static void inserir(Veiculo veiculo) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into veiculo(nome_veiculo, placa_veiculo) values (?, ?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1, veiculo.getNome());
        stmt.setString(2, veiculo.getPlaca());
        stmt.execute();
        stmt.close();
        con.close();
    }
   
    public static void alterar(Veiculo veiculo) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update veiculo set nome_veiculo= ?, placa_veiculo=? "
                + "where id_veiculo = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, veiculo.getNome());
        stmt.setString(2, veiculo.getPlaca());
        stmt.setInt(3, veiculo.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();                
    }
    
    public static void excluir(Veiculo veiculo) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql="delete from veiculo where id_veiculo= ?";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setInt(1, veiculo.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Veiculo> pesquisar(Veiculo veiculo) throws SQLException{
        List<Veiculo> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from veiculo where "
                + "nome_veiculo like '%"+veiculo.getNome()+"%'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Veiculo v= new Veiculo();
            v.setNome(rs.getString("nome_veiculo"));
            v.setPlaca(rs.getString("placa_veiculo"));
            v.setId(rs.getInt("id_veiculo"));
            listaUsu.add(v);
        }
        
        System.out.println(listaUsu.toString());
        stmt.close();
        con.close();
        return listaUsu;

    }
    
    public static List<Veiculo> pesquisar() throws SQLException{
        List<Veiculo> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from veiculo";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Veiculo v= new Veiculo();
            v.setNome(rs.getString("nome_veiculo"));
            v.setPlaca(rs.getString("placa_veiculo"));
            v.setId(rs.getInt("id_veiculo"));
            listaUsu.add(v);
        }
        
        System.out.println(listaUsu.toString());
        stmt.close();
        con.close();
        return listaUsu;

    }
    
    public static void main(String[] args) {
        Veiculo v =  new Veiculo();
        v.setNome("b");
        v.setPlaca("a");
        v.setId(2);
        
         try {
             inserir(v);
         } catch (SQLException ex) {
             Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
