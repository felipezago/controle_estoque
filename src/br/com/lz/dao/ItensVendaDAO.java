/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.dao;

import br.com.lz.domain.Fabricante;
import br.com.lz.domain.ItensVenda;
import br.com.lz.domain.Produtos;
import br.com.lz.util.Conexao;
import br.com.lz.domain.Venda;
import com.mysql.jdbc.Statement;
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
public class ItensVendaDAO {
    public static void inserir(ItensVenda itv) throws SQLException{
        Connection con= Conexao.getConexao();
        String sql1= "insert into itens_venda (quantidade_produtos_itv, id_produto,"
                + " valorParcial, status_itv) values"
                + "(?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql1);
        stmt.setInt(1, itv.getQuantidade());
        stmt.setInt(2, itv.getProduto().getId());
        stmt.setDouble(3, itv.getValorParcial());
        stmt.setString(4, "A");
        stmt.execute();
        stmt.close();
        con.close();
    }
    
//    public static void inserirServ(ItensVenda itv) throws SQLException{
//        Connection con= Conexao.getConexao();
//        String sql1= "insert into itens_venda (quantidade_produtos_itv, "
//                + " valorParcial, status_itv) values"
//                + "(?, ?, ?, ?)";
//        PreparedStatement stmt = con.prepareStatement(sql1);
//        stmt.setInt(1, itv.getQuantidade());
//        stmt.setString(3, itv.getServico());
//        stmt.setDouble(2, itv.getValorParcial());
//        stmt.setString(4, "A");
//        stmt.execute();
//        stmt.close();
//        con.close();
//    }
    
//    
//    public static void alterar(ItensVenda) throws SQLException{
//        Connection con = Conexao.getConexao();
//        String sql = "update solicitacao set titulo_solic= ?,"
//                + "descricao_solic= ?";
//        PreparedStatement stmt= con.prepareStatement(sql);
//        stmt.setString(1, solicitacao.getTitulo());
//        stmt.setString(1, solicitacao.getDescricao());
//        stmt.executeUpdate();
//        stmt.close();
//        con.close();
//    }
    
    public static void excluir(ItensVenda itv) throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "delete from itens_venda where id_itv= ?";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setInt(1, itv.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static List<ItensVenda> listar() throws SQLException{
        Connection con = Conexao.getConexao();
        List<ItensVenda> listaInci = new ArrayList<>();
        String sql = "select prodserv, produto.id_produto, id_itv, produto.nome_produto, status_itv, produto.preco_produto, quantidade_produtos_itv, "
                + "valorParcial from itens_venda inner join produto on produto.id_produto= itens_venda.id_produto"
                + " where status_itv= 'A' and produto.prodserv= 'P'";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produtos prod= new Produtos();
            ItensVenda i= new ItensVenda();
            
            prod.setId(rs.getInt("id_produto"));
            prod.setNome(rs.getString("nome_produto"));
            prod.setPreco(rs.getDouble("preco_produto"));
            prod.setProdserv(rs.getString("prodserv"));
            
            i.setProduto(prod);
            i.setQuantidade(rs.getInt("quantidade_produtos_itv"));
            i.setValorParcial(rs.getDouble("valorParcial"));
            i.setStatus(rs.getString("status_itv"));
            i.setId(rs.getInt("id_itv"));
            
            listaInci.add(i);
        }
        stmt.close();
        con.close();
        return listaInci;
    }
    
    public static List<ItensVenda> listarServ() throws SQLException{
        Connection con = Conexao.getConexao();
        List<ItensVenda> listaInci = new ArrayList<>();
        String sql = "select prodserv, produto.id_produto, id_itv, produto.nome_produto, status_itv, produto.preco_produto, quantidade_produtos_itv, "
                + "valorParcial from itens_venda inner join produto on produto.id_produto= itens_venda.id_produto"
                + " where status_itv= 'A' and produto.prodserv= 'S'";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produtos prod= new Produtos();
            ItensVenda i= new ItensVenda();
            
            prod.setId(rs.getInt("id_produto"));
            prod.setNome(rs.getString("nome_produto"));
            prod.setPreco(rs.getDouble("preco_produto"));
            prod.setProdserv(rs.getString("prodserv"));
            
            i.setProduto(prod);
            i.setQuantidade(rs.getInt("quantidade_produtos_itv"));
            i.setValorParcial(rs.getDouble("valorParcial"));
            i.setStatus(rs.getString("status_itv"));
            i.setId(rs.getInt("id_itv"));
            
            listaInci.add(i);
        }
        stmt.close();
        con.close();
        return listaInci;
    }
    
//    public static List<ItensVenda> listarServ() throws SQLException{
//        Connection con = Conexao.getConexao();
//        List<ItensVenda> listaInci = new ArrayList<>();
//        String sql = "select prodserv, id_itv, status_itv, quantidade_produtos_itv, servico,\n" +
//"valorParcial from itens_venda where status_itv= 'A' and prodserv= 'S'";
//        PreparedStatement stmt = con.prepareStatement(sql);
//        ResultSet rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            ItensVenda i= new ItensVenda();
//            
//            i.setQuantidade(rs.getInt("quantidade_produtos_itv"));
//            i.setValorParcial(rs.getDouble("valorParcial"));
//            i.setStatus(rs.getString("status_itv"));
//            i.setId(rs.getInt("id_itv"));
//            i.setProdsev(rs.getString("prodserv"));
//            i.setServico(rs.getString("servico"));
//            
//            listaInci.add(i);
//        }
//        stmt.close();
//        con.close();
//        return listaInci;
//    }
    
    
    public static List<ItensVenda> listarProd(int id) throws SQLException{
        Connection con = Conexao.getConexao();
        List<ItensVenda> listaInci = new ArrayList<>();
        String sql = "select id_itv, produto.nome_produto, status_itv, produto.preco_produto, quantidade_produtos_itv, "
                + "valorParcial from itens_venda inner join produto on produto.id_produto= itens_venda.id_produto"
                + " where status_itv= 'A' and produto.id_produto= "+id+"";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produtos prod= new Produtos();
            ItensVenda i= new ItensVenda();
            
            prod.setNome(rs.getString("nome_produto"));
            prod.setPreco(rs.getDouble("preco_produto"));
            
            i.setProduto(prod);
            i.setQuantidade(rs.getInt("quantidade_produtos_itv"));
            i.setValorParcial(rs.getDouble("valorParcial"));
            i.setStatus(rs.getString("status_itv"));
            i.setId(rs.getInt("id_itv"));
            
            listaInci.add(i);
        }
        stmt.close();
        con.close();
        return listaInci;
    }
    
    public static boolean validaExist(int id) throws SQLException{
        
        Connection con = Conexao.getConexao();
        String sql = "select * from itens_venda where id_produto= "+id+" and status_itv= 'A'";
        PreparedStatement stmt= con.prepareStatement(sql);
        
        stmt.execute();
        ResultSet rs= stmt.executeQuery();
        
        
        if(rs.next()){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static void alteraQt(ItensVenda it) throws SQLException{     
        Connection con = Conexao.getConexao();
        String sql = "update itens_venda set quantidade_produtos_itv ="
                + "quantidade_produtos_itv + 1 where id_produto= "+it.getProduto().getId()+"";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
        
    }
    
    public static void alteraValor(ItensVenda it, int qt, int id) throws SQLException{   
        Connection con = Conexao.getConexao();
        String sql = "update itens_venda set valorParcial= "
                + "(select preco_produto from produto where "
                + "id_produto= "+id+") * "+qt+""
                + " where id_itv= "+it.getId()+" ";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
        
    }
    
    public static void alteraQuantidade(ItensVenda itv) throws SQLException{   
        Connection con = Conexao.getConexao();
        String sql = "update itens_venda set quantidade_produtos_itv = quantidade_produtos_itv - 1 where"
                + " id_itv= "+itv.getId()+"";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
        
    }
    
    public static void subtrai(Double val, ItensVenda i) throws SQLException{   
        Connection con = Conexao.getConexao();
        String sql = "update itens_venda set valorParcial= "+val+" where id_itv= "+i.getId()+" "
                + "and id_produto= "+i.getProduto().getId()+"";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
        
    }
    
     public static void subtraiServ(Double val, ItensVenda i) throws SQLException{   
        Connection con = Conexao.getConexao();
        String sql = "update itens_venda set valorParcial= "+val+" where id_itv= "+i.getId()+" "
                + "";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
        
    }
    
    public static void salvaVenda(int id) throws SQLException{
        Connection con = Conexao.getConexao();
        
        String sql = "update itens_venda set id_venda= "+id+" where status_itv= 'A'";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static void alteraStatus(int id) throws SQLException{
        Connection con = Conexao.getConexao();
        
        String sql = "update itens_venda set status_itv= 'F' where id_venda= "+id+"";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    
    public static void main(String[] args) {
        ItensVenda itv= new ItensVenda();
        
        itv.setQuantidade(2);
        itv.setValorParcial(1.50);
        itv.setId(1);
        
        try {
            excluir(itv);
        } catch (SQLException ex) {
            Logger.getLogger(ItensVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
