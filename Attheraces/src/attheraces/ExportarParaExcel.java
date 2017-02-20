/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import dao.Informacoes;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import util.DataUtils;
import util.jfilechooser.SelecionarArquivosDiretorios;

/**
 *
 * @author marce
 */
public class ExportarParaExcel {

    private List<Informacoes> listagem;
    private String caminho;
    
    public void exportar(List<Informacoes> listagem, Date dataInicio, Date dataFim) {
        this.listagem = listagem;
        
        FormConfiguraExcel fc = new FormConfiguraExcel(null, true);
        fc.setVisible(true);
        
        if(fc.BTN_PRESSIONADO == fc.BTN_OK) {
            
            caminho = fc.getDiretorio().getAbsolutePath();
            
            if(fc.isCriarUnicoArquivo()) {
                criarUnicoArquivo();
            }
            
            if(fc.isCriarArquivoParaCadaMes() || fc.isCriarArquivoParaCadaMesSepararAbas()) {
                if(!caminho.toLowerCase().endsWith("\\")) {
                    caminho = caminho + "\\";
                }
                new File(caminho).mkdirs();
            }
            
            if(fc.isCriarArquivoParaCadaMes()) {
                criarUmArquivoPorMes();
            }
            
            if(fc.isCriarArquivoParaCadaMesSepararAbas()) {
                criarUmArquivoPorMesSeparadoEmAbas();
            }
        }
        
    }
    
    private void criarUnicoArquivo() {
        FileOutputStream fos = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            File f = new File(caminho);

            fos = new FileOutputStream(f);

            int i=1;
            HSSFSheet sheet = workbook.createSheet("Attherace");
            criarCabecalho(sheet);
            for(Informacoes inf : listagem) {
                addLinha(sheet, inf, i);
                i++;
            }

            workbook.write(fos);
        } catch (Exception e) {
            TrataException.fatal(e);
        } finally {
            try {
                fos.flush();
                fos.close();
            } catch (Exception e) {
                TrataException.fatal(e);
            }
        }
    }
    
    private void criarUmArquivoPorMes() {
        try {
            String mesAnoAnterior = "";
            int i=1;
            HSSFSheet sheet = null;
            HSSFWorkbook workbook = null;
            File f = null;
            FileOutputStream fos = null;
            for(Informacoes inf : listagem) {
                
                String mesAno = DataUtils.getDataFormatada(inf.getData(), "MM-yy");
                
                if(!mesAno.equals(mesAnoAnterior)) {
                    
                    if(workbook != null) {
                        workbook.write(fos);
                        fos.flush();
                        fos.close();
                    }
                    
                    workbook = new HSSFWorkbook();
                    f = new File(caminho + mesAno + ".xls");
                    fos = new FileOutputStream(f);
                    sheet = workbook.createSheet("Attheraces");
                    i=1;
                    
                    criarCabecalho(sheet);
                }

                addLinha(sheet, inf, i);
                
                mesAnoAnterior = mesAno;
                i++;
            }
            
            workbook.write(fos);
            fos.flush();
            fos.close();
            
        } catch (Exception e) {
            TrataException.fatal(e);
        }
    }
    
    private void criarUmArquivoPorMesSeparadoEmAbas() {
        try {
            String diaAnterior = "";
            String mesAnoAnterior = "";
            int i=0;
            HSSFSheet sheet = null;
            HSSFWorkbook workbook = null;
            File f = null;
            FileOutputStream fos = null;
            for(Informacoes inf : listagem) {

                String dia = DataUtils.getDataFormatada(inf.getData(), "dd");
                String mesAno = DataUtils.getDataFormatada(inf.getData(), "MM-yy");
                
                if(!mesAno.equals(mesAnoAnterior)) {
                    
                    if(workbook != null) {
                        workbook.write(fos);
                        fos.flush();
                        fos.close();
                    }
                    
                    workbook = new HSSFWorkbook();
                    f = new File(caminho + mesAno + ".xls");
                    fos = new FileOutputStream(f);
                }

                if(!dia.equals(diaAnterior)) {
                    i = 0;
                    sheet = workbook.createSheet(dia.split("/")[0]);
                    criarCabecalho(sheet);
                    i++;
                } 

                addLinha(sheet, inf, i);

                diaAnterior = dia;
                mesAnoAnterior = mesAno;
                i++;
            }
            
            workbook.write(fos);
            fos.flush();
            fos.close();
            
        } catch (Exception e) {
            TrataException.fatal(e);
        }
    }
    
    private void criarCabecalho(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Data");
        row.createCell(1).setCellValue("Hora");
        row.createCell(2).setCellValue("Pista");
        row.createCell(3).setCellValue("OddFav");
        row.createCell(4).setCellValue("NomeFav");
        row.createCell(5).setCellValue("OddFav2");
        row.createCell(6).setCellValue("NomeFav2");
        row.createCell(7).setCellValue("Distancia");
        row.createCell(8).setCellValue("Num. Cavalos");
        row.createCell(9).setCellValue("Winner");
    }
    
    private void addLinha(HSSFSheet sheet, Informacoes inf, int i) {
        HSSFRow row = sheet.createRow(i);
        row.createCell(0).setCellValue(inf.getDataToString());
        row.createCell(1).setCellValue(inf.getHora());
        row.createCell(2).setCellValue(inf.getPista());
        row.createCell(3).setCellValue(inf.getOddFav());
        row.createCell(4).setCellValue(inf.getNomeOddFav());
        row.createCell(5).setCellValue(inf.getOddFav2());
        row.createCell(6).setCellValue(inf.getNomeOddFav2());
        row.createCell(7).setCellValue(inf.getDistancia());
        row.createCell(8).setCellValue(inf.getNumCavalos());
        row.createCell(9).setCellValue(inf.getCampeao());
    }

}
