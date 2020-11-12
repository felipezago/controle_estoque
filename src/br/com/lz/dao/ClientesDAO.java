/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.dao;

import br.com.lz.domain.Clientes;
import br.com.lz.domain.Fabricante;
import br.com.lz.domain.Produtos;
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
public class ClientesDAO {
        public static void inserir(Clientes cli) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into cliente(nome_cliente, cpfcnpj_cliente, contato_cliente, "
                + "email_cliente, cidade_cliente, estado_cliente, id_veiculo) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1, cli.getNome());
        stmt.setString(2, cli.getCpfcnpj());
        stmt.setString(3, cli.getContato());
        stmt.setString(4, cli.getEmail());
        stmt.setString(5, cli.getCidade());
        stmt.setString(6, cli.getEstado());
        stmt.setInt(7, cli.getVeiculo().getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
   
    public static void alterar(Clientes cli) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update cliente set nome_cliente= ?, cpfcnpj_cliente= ?, contato_cliente=?,"
                + "email_cliente= ?, cidade_cliente= ?, estado_cliente= ?, id_veiculo= ? "
                + "where id_cliente = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cli.getNome());
        stmt.setString(2, cli.getCpfcnpj());
        stmt.setString(3, cli.getContato());
        stmt.setString(4, cli.getEmail());
        stmt.setString(5, cli.getCidade());
        stmt.setString(6, cli.getEstado());
        stmt.setInt(7, cli.getVeiculo().getId());
        stmt.setInt(8, cli.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();                
    }
    
    public static void excluir(Clientes cli) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql="delete from cliente where id_cliente= ?";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setInt(1, cli.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Clientes> pesquisar() throws SQLException{
        List<Clientes> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from cliente";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Clientes c= new Clientes();
            
            c.setNome(rs.getString("nome_cliente"));
            c.setCidade(rs.getString("cidade_cliente"));
            c.setContato(rs.getString("contato_cliente"));
            c.setCpfcnpj(rs.getString("cpfcnpj_cliente"));
            c.setEmail(rs.getString("email_cliente"));
            c.setEstado(rs.getString("estado_cliente"));
            c.setId(rs.getInt("id_cliente"));
            
            listaUsu.add(c);
        }
        
        System.out.println(listaUsu);
        stmt.close();
        con.close();
        return listaUsu;
    }
    
    public static List<Clientes> pesquisar(Clientes cli) throws SQLException{
        List<Clientes> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from cliente inner join veiculo on cliente.id_veiculo ="
                + "veiculo.id_veiculo and "
                + "nome_cliente like '%"+cli.getNome()+"%'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Clientes c= new Clientes();
            Veiculo v= new Veiculo();
            
            v.setId(rs.getInt("id_veiculo"));
            v.setNome(rs.getString("nome_veiculo"));
            v.setPlaca(rs.getString("placa_veiculo"));
            
            c.setNome(rs.getString("nome_cliente"));
            c.setCidade(rs.getString("cidade_cliente"));
            c.setContato(rs.getString("contato_cliente"));
            c.setCpfcnpj(rs.getString("cpfcnpj_cliente"));
            c.setEmail(rs.getString("email_cliente"));
            c.setEstado(rs.getString("estado_cliente"));
            c.setId(rs.getInt("id_cliente"));
            c.setVeiculo(v);
            
            listaUsu.add(c);
        }
        
        System.out.println(listaUsu);
        stmt.close();
        con.close();
        return listaUsu;
    }
    
    public static void main(String[] args) {

    }
}
