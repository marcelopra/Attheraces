/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import dao.Informacoes;
import dao.InformocoesDAO;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import util.DataUtils;

/**
 *
 * @author marce
 */
public class FormAplicacao extends javax.swing.JFrame {

    private List<Informacoes> listagem;
    
    /**
     * Creates new form FormAplicacao
     */
    public FormAplicacao() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        txtDataFinal.setDate(DataUtils.dimunuirDias(new Date(), 1));
        txtDataInicio.setDate(DataUtils.dimunuirDias(new Date(), 2));
        
        atualizaListagem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePadrao1 = new gui.TablePadrao();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        painelWhere1 = new attheraces.PainelWhere();
        jLabel1 = new javax.swing.JLabel();
        txtDataInicio = new org.jdesktop.swingx.JXDatePicker();
        txtDataFinal = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxOrderBy1 = new gui.ComboBoxOrderBy();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Attheraces");

        tablePadrao1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Pista", "OddFav", "Nome OddFav", "OddFav2", "Nome OddFav2", "Distância", "Dist. (metros)", "Num.", "Campeão", "Link Racecard"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePadrao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePadrao1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePadrao1);
        if (tablePadrao1.getColumnModel().getColumnCount() > 0) {
            tablePadrao1.getColumnModel().getColumn(0).setPreferredWidth(75);
            tablePadrao1.getColumnModel().getColumn(1).setPreferredWidth(75);
            tablePadrao1.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablePadrao1.getColumnModel().getColumn(3).setPreferredWidth(126);
            tablePadrao1.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablePadrao1.getColumnModel().getColumn(5).setPreferredWidth(125);
            tablePadrao1.getColumnModel().getColumn(6).setPreferredWidth(150);
            tablePadrao1.getColumnModel().getColumn(7).setPreferredWidth(75);
            tablePadrao1.getColumnModel().getColumn(8).setPreferredWidth(125);
            tablePadrao1.getColumnModel().getColumn(9).setPreferredWidth(50);
            tablePadrao1.getColumnModel().getColumn(10).setPreferredWidth(150);
            tablePadrao1.getColumnModel().getColumn(11).setPreferredWidth(400);
        }

        jLabel3.setText("* Duplo clique para abril o link do racecard");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButton2.setText("Atualizar Listagem");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Exportar para Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Filtros"));

        jLabel1.setText("Data início:");

        txtDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInicioActionPerformed(evt);
            }
        });

        txtDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataFinalActionPerformed(evt);
            }
        });

        jLabel2.setText("Data final:");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Ordem:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxOrderBy1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelWhere1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxOrderBy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelWhere1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Buscar Dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1287, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioActionPerformed
        
    }//GEN-LAST:event_txtDataInicioActionPerformed

    private void txtDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataFinalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        atualizaListagem();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablePadrao1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePadrao1MouseClicked
        if(evt.getClickCount()==2){
            try {
                if(getInformacoesSelecionada() != null) {
                    Desktop.getDesktop().browse(new URI(getInformacoesSelecionada().getLink()));
                }
            } catch (URISyntaxException ex) {
                TrataException.fatal(ex);
            } catch (IOException ex) {
                TrataException.fatal(ex);
            }
        } 
    }//GEN-LAST:event_tablePadrao1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormConfigurarBusca fb = new FormConfigurarBusca(this, true, txtDataInicio.getDate(), txtDataFinal.getDate());
        fb.setVisible(true);
        if(fb.BTN_PRESSIONADO == fb.BTN_OK) {
            List<Date> datas = DataUtils.getDatasEntreDuasDatas(fb.getDataInicio(), fb.getDataFim());
            int threadPoolSize = 10;

            ExecutorService tpes = Executors.newFixedThreadPool(threadPoolSize);

            ThreadBuscaInformacoesDia[] workers = new ThreadBuscaInformacoesDia[datas.size()];
            FormLog f = new FormLog();
            f.setVisible(true);
            for (int i = 0; i < datas.size(); i++) {
                f.atualiza(datas.get(i), "Pendente", "");
                workers[i] = new ThreadBuscaInformacoesDia(datas.get(i), f);
                tpes.execute(workers[i]);
            }
            tpes.shutdown();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ExportarParaExcel().exportar(listagem, txtDataInicio.getDate(), txtDataFinal.getDate());
    }//GEN-LAST:event_jButton3ActionPerformed

    public Informacoes getInformacoesSelecionada() {
        if(tablePadrao1.getSelectedRow() != -1) {
            return listagem.get(tablePadrao1.getSelectedRow());
        }
        return null;
    }
    
    private void atualizaListagem() {
        try {
            tablePadrao1.limparTabela();
            listagem = new InformocoesDAO().listagem(txtDataInicio.getDate(), txtDataFinal.getDate(), 
                    painelWhere1.getWhere(), comboBoxOrderBy1.getOrderBySelecionado().getOperador());
            if(listagem != null) {
                for(Informacoes i : listagem) {
                    tablePadrao1.adicionarLinha(new Object[] {i.getDataToString(), i.getHora(),
                    i.getPista(), i.getOddFav() + " (" + i.getOddFavText()+ ")", i.getNomeOddFav(), i.getOddFav2() + " (" + i.getOddFav2Text()+ ")", i.getNomeOddFav2(), 
                    i.getDistancia(), i.getDist(), i.getNumCavalos(), i.getCampeao(), i.getLink()});
                }
            }
        } catch (SQLException ex) {
            TrataException.fatal(ex);
        } catch (SQLWhreException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private gui.ComboBoxOrderBy comboBoxOrderBy1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private attheraces.PainelWhere painelWhere1;
    private gui.TablePadrao tablePadrao1;
    private org.jdesktop.swingx.JXDatePicker txtDataFinal;
    private org.jdesktop.swingx.JXDatePicker txtDataInicio;
    // End of variables declaration//GEN-END:variables
}