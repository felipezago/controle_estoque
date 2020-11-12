/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.dao;

import br.com.lz.domain.Clientes;
import br.com.lz.domain.Venda;
import br.com.lz.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class VendaDAO {
        public static void inserir(Venda venda) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into venda(data_venda, valorTotal, id_cli "
                + ") values (?, ?, ?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setDate(1, new java.sql.Date(venda.getData().getTimeInMillis()));
        stmt.setDouble(2, venda.getValorTotal());
        stmt.setInt(3, venda.getCliente().getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static void excluir(Venda vd) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql="delete from venda where id_venda= ?";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setInt(1, vd.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Venda> pesquisar(Clientes cli) throws SQLException{
        List<Venda> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select id_venda, data_venda, cliente.nome_cliente, valorTotal from venda inner join cliente "
                + "on venda.id_cli= cliente.id_cliente where cliente.nome_cliente like '%"+cli.getNome()+"%'";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            Venda v= new Venda();
            Clientes c= new Clientes();
            
            v.setId(rs.getInt("id_venda"));
            c.setNome(rs.getString("nome_cliente"));
            Calendar ca = Calendar.getInstance();
            ca.setTime(rs.getDate("data_venda"));
            v.setData(ca);
            v.setValorTotal(rs.getDouble("valorTotal"));
            v.setCliente(c);
            
            listaUsu.add(v);
        }
        
        System.out.println(listaUsu);
        stmt.close();
        con.close();
        return listaUsu;
    }
    
    public static int buscaId() throws SQLException{
        //List<Venda> listaUsu= new ArrayList<>();
        Connection con= Conexao.getConexao();
        String sql = "select id_venda from venda order by id_venda desc limit 1";
        PreparedStatement stmt= con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        int i = 0;
        
        while(rs.next()){
            
            i= rs.getInt("id_venda");
            
        }
        
        stmt.close();
        con.close();
        return i;
    }
    
    public static ResultSet retornaRS01(int id) throws SQLException {
        Connection con = Conexao.getConexao();

      String sql= "SELECT controleestoque.cliente.nome_cliente,\n" +
"	controleestoque.produto.nome_produto,\n" +
"	controleestoque.produto.preco_produto,\n" +
"	controleestoque.venda.`valorTotal`,\n" +
"	controleestoque.itens_venda.`valorParcial`,\n" +
"	controleestoque.itens_venda.quantidade_produtos_itv,\n" +
"	controleestoque.cliente.cpfcnpj_cliente,\n" +
"	controleestoque.cliente.contato_cliente\n" +
"FROM controleestoque.itens_venda\n" +
"	INNER JOIN controleestoque.produto ON \n" +
"	 controleestoque.itens_venda.id_produto = controleestoque.produto.id_produto \n" +
"	INNER JOIN controleestoque.venda ON \n" +
"	 controleestoque.itens_venda.id_venda = controleestoque.venda.id_venda \n" +
"	INNER JOIN controleestoque.cliente ON \n" +
"	 controleestoque.venda.id_cli = controleestoque.cliente.id_cliente where venda.id_venda= "+id+"";
        //System.out.println(sql);
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        return rs;

    }
    
    public static void main(String[] args) {
        Venda v = new Venda();
        Calendar c= Calendar.getInstance();        
        v.setData(c);
        v.setId(3);
        v.setValorTotal(5);
            try {
                inserir(v);
            } catch (SQLException ex) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}

            
    