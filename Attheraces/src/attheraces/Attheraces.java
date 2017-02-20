/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import dao.DataBaseConnection;
import gui.LookAndFeelUtil;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author marce
 */
public class Attheraces {

    public static String DIR_PADRAO = "C:\\attheraces\\";
    
    public static void main(String[] args) {
        
        try {
            DataBaseConnection.conectar();
            
            /*Atualiza o tema das janelas conforme o tema do Windows*/
            new LookAndFeelUtil().setTemaSistemaOperacional();
            
            new FormAplicacao().setVisible(true);
        } catch (ClassNotFoundException ex) {
            TrataException.fatal(ex);
        } catch (InstantiationException ex) {
            TrataException.fatal(ex);
        } catch (IllegalAccessException ex) {
            TrataException.fatal(ex);
        } catch (UnsupportedLookAndFeelException ex) {
            TrataException.fatal(ex);
        } catch (SQLException ex) {
            TrataException.fatal(ex);
        }

        
        
        /*try {
            DataBaseConnection.conectar();
            Calendar dataAtual = Calendar.getInstance();
            dataAtual.setTime(new Date());
            
            dataAtual.add(Calendar.DAY_OF_MONTH, -3);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            dataAtual.add(Calendar.DAY_OF_MONTH, -1);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            dataAtual.add(Calendar.DAY_OF_MONTH, -1);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            dataAtual.add(Calendar.DAY_OF_MONTH, -1);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            dataAtual.add(Calendar.DAY_OF_MONTH, -1);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            dataAtual.add(Calendar.DAY_OF_MONTH, -1);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            dataAtual.add(Calendar.DAY_OF_MONTH, -1);
            new ThreadBuscaInformacoesDia().buscar(dataAtual.getTime());
            
            int maximoThreads = 15;
            int threadPoolSize = 15;

            ExecutorService tpes = Executors.newFixedThreadPool(threadPoolSize);

            ThreadBuscaInformacoesDia[] workers = new ThreadBuscaInformacoesDia[maximoThreads];
            for (int i = 0; i < maximoThreads; i++) {
                
                dataAtual.add(Calendar.DAY_OF_MONTH, -1);
                
                workers[i] = new ThreadBuscaInformacoesDia(dataAtual.getTime());
                tpes.execute(workers[i]);
            }
            tpes.shutdown();
            
        } catch (SQLException ex) {
            Logger.getLogger(Attheraces.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    
}
