/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.util;

import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author felip
 */
public class Relatorio {
        public static void gerarRelatorio(String caminho, ResultSet rs) {
        try{
            //RECEBE UM RESULTSET VINDO DO BANCO
            JRResultSetDataSource jrRS= new JRResultSetDataSource(rs);
            
            //IMPRIME O RELATORIO
            JasperPrint jasperPrint= JasperFillManager.fillReport(caminho, new HashMap(), jrRS);
            
            //COMPONENTE PARA VISUALIZAR O RELATORIO
            JasperViewer j= new JasperViewer(jasperPrint);
            j.viewReport(jasperPrint, false);
            
        
        }catch(NullPointerException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não existe nenhum dado!");
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("erro");
        }
    }
}
