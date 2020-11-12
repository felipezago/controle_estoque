/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.dao;

import br.com.lz.domain.Fabricante;
import br.com.lz.domain.ItensVenda;
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
public class ProdutosDAO {
    public static void inserir(Produtos prod) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into produto(nome_produto, preco_produto, estoque_produto, prodserv) values (?, ?, ?, ?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1, prod.getNome());
        stmt.setDouble(2, prod.getPreco());
        stmt.setInt(3, prod.getEstoque());
        stmt.setString(4, "P");
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static void inserirServ(Produtos prod) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into produto(nome_produto, preco_produto, prodserv, estoque_produto) values (?, ?, ?, ?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1, prod.getNome());
        stmt.setDouble(2, prod.getPreco());
        stmt.setString(3, "S");
        stmt.setInt(4, 0);
        stmt.execute();
        stmt.close();
        con.close();
    }
   
    public static void alterar(Produtos prod) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update produto set nome_produto= ?, preco_produto= ?, estoque_produto=?"
                + ""
                + " where id_produto = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, prod.getNome());
        stmt.setDouble(2, prod.getPreco());
        stmt.setInt(3, prod.getEstoque());
        stmt.setInt(4, prod.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();                
    }
    
    public static void alterars(Produtos prod) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update produto set nome_produto= ?, preco_produto= ? where id_produto = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, prod.getNome());
        stmt.setDouble(2, prod.getPreco());
        stmt.setInt(3, prod.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();                
    }
    
    public static void excluir(Produtos prod) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql="delete from produto where id_produto= ?";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setInt(1, prod.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Produtos> pesquisar(Produtos prod) throws SQLException{
        List<Produtos> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from produto where "
                + "nome_produto like '%"+prod.getNome()+"%'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Produtos p = new Produtos();
            p.setNome(rs.getString("nome_produto"));
            p.setId(rs.getInt("id_produto"));
            p.setEstoque(rs.getInt("estoque_produto"));
            p.setPreco(rs.getDouble("preco_produto"));
            p.setProdserv(rs.getString("prodserv"));
            
            listaUsu.add(p);
        }
        
        System.out.println(listaUsu);
        stmt.close();
        con.close();
        return listaUsu;
    }
    
    public static void addEstoque(ItensVenda t) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update produto set estoque_produto= estoque_produto + 1"
                + " where id_produto= "+t.getProduto().getId()+"";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();     
    }
    
    public static void removeEstoque(Produtos prod) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql= "update produto set estoque_produto= estoque_produto - 1 "
                + "where id_produto= "+prod.getId()+"";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();     
    }
    
    public static List<Produtos> listaServ(Produtos prod) throws SQLException{
        List<Produtos> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from produto where "
                + "nome_produto like '%"+prod.getNome()+"%' and prodserv= 'S'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Produtos p = new Produtos();
            p.setNome(rs.getString("nome_produto"));
            p.setId(rs.getInt("id_produto"));
            p.setEstoque(rs.getInt("estoque_produto"));
            p.setPreco(rs.getDouble("preco_produto"));
            p.setProdserv(rs.getString("prodserv"));
            
            listaUsu.add(p);
        }
        
        System.out.println(listaUsu);
        stmt.close();
        con.close();
        return listaUsu;
    }
    
    public static List<Produtos> listaProd(Produtos prod) throws SQLException{
        List<Produtos> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select * from produto where "
                + "nome_produto like '%"+prod.getNome()+"%' and prodserv= 'P'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Produtos p = new Produtos();
            p.setNome(rs.getString("nome_produto"));
            p.setId(rs.getInt("id_produto"));
            p.setEstoque(rs.getInt("estoque_produto"));
            p.setPreco(rs.getDouble("preco_produto"));
            p.setProdserv(rs.getString("prodserv"));
            
            listaUsu.add(p);
        }
        
        System.out.println(listaUsu);
        stmt.close();
        con.close();
        return listaUsu;
    }
    
    public static void main(String[] args) {

            Produtos p= new Produtos();
            Fabricante f= new Fabricante();
            f.setId(3);
            p.setId(5);
            p.setNome("seila");
            
        try {
            inserir(p);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Sucesso");
      
    }
    
    
    
}
