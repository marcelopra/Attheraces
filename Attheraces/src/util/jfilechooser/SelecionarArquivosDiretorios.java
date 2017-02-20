/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.jfilechooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author u0181181
 */
public class SelecionarArquivosDiretorios {
    
    private static File ULTIMO_ARQUIVO = null;
    
    /**
     * Abre a janela de modo que seja possível realizar a seleção somente de pastas.
     * @return Retorna o diretório selecionado.
     */
    public File localizarDiretorio() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Localizar Diretório");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(ULTIMO_ARQUIVO != null) {
            fc.setCurrentDirectory(ULTIMO_ARQUIVO.getParentFile());
        }
        int rtn = fc.showOpenDialog(null);
        if(rtn == JFileChooser.APPROVE_OPTION) {
            ULTIMO_ARQUIVO = fc.getSelectedFile();
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }

    /**
     * Abre a janela de modo que localize somente arquivos conforme o FileFilter informado.
     * @return Retorna o arquivo selecionado. Será retornado NULL caso nenhum arquivo seja selecionado, ou seja fechada a janela ou clicado em cancelar.
     */
    public File localizarArquivo(FileFilter filtro) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Localizar Arquivo");
        fc.setFileFilter(filtro);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(ULTIMO_ARQUIVO != null) {
            fc.setCurrentDirectory(ULTIMO_ARQUIVO.getParentFile());
        }
        int rtn = fc.showOpenDialog(null);
        if(rtn == JFileChooser.APPROVE_OPTION) {
            ULTIMO_ARQUIVO = fc.getSelectedFile();
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }

    /**
     * Abre a janela de modo que localize qualquer tipo de arquivos.
     * @return Retorna o arquivo selecionado. Será retornado NULL caso nenhum arquivo seja selecionado, ou seja fechada a janela ou clicado em cancelar.
     */
    public File localizarArquivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Localizar Arquivo");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(ULTIMO_ARQUIVO != null) {
            fc.setCurrentDirectory(ULTIMO_ARQUIVO.getParentFile());
        }
        int rtn = fc.showOpenDialog(null);
        if(rtn == JFileChooser.APPROVE_OPTION) {
            ULTIMO_ARQUIVO = fc.getSelectedFile();
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }
    
    public File salvarComo(String sugestaoNomeArquivo) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Salva como");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setSelectedFile(new File(sugestaoNomeArquivo));
        int rtn = fc.showOpenDialog(null);
        if(rtn == JFileChooser.APPROVE_OPTION) {
            ULTIMO_ARQUIVO = fc.getSelectedFile();
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }
    
    /**
     * Abre a janela para seleção de MÚLTIPLOS arquivos.
     * @return Retorna uma lista com todos os arquivos selecionados. 
     * Será retornado NULL caso nenhum arquivo seja selecionado, ou seja fechada a janela ou clicado em cancelar.
     */
    public List<String> localizarVariosArquivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Localizar Arquivo");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        if(ULTIMO_ARQUIVO != null) {
            fc.setCurrentDirectory(ULTIMO_ARQUIVO.getParentFile());
        }
        int rtn = fc.showOpenDialog(null);
        if(rtn == JFileChooser.APPROVE_OPTION) {
            ULTIMO_ARQUIVO = fc.getSelectedFile();
            List<String> arqsSelecionados = new ArrayList<String>();
            if(fc.getSelectedFiles() != null) {
                for(File f : fc.getSelectedFiles()) {
                    arqsSelecionados.add(f.getAbsolutePath());
                }
            }
            return arqsSelecionados;
        } else {
            return null;
        }
    }
    
}
