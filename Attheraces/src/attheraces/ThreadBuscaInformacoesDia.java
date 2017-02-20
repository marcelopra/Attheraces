/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import dao.InformocoesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.DataUtils;

/**
 *
 * @author marce
 */
public class ThreadBuscaInformacoesDia implements Runnable {
    
    private static String[] meses = new String[] {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
    private Date dia;
    private boolean ocorreuErro;
    private String msgErro;
    private FormLog formLog;
    private String diaFormatado;

    public ThreadBuscaInformacoesDia(Date dia, FormLog formLog) {
        this.dia = dia;
        this.ocorreuErro = true;
        this.formLog = formLog;
        this.diaFormatado = DataUtils.getDataFormatada(dia, "dd/MM/yy");
    }
    
    private String dateToUrl(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.DAY_OF_MONTH) + "-" + meses[c.get(Calendar.MONTH)] + "-" + c.get(Calendar.YEAR);
    }
    
    public void buscar(Date dia) {
        new Thread(this).start();
    }
    
    public void getLinkDeTodasCorridasDia(Document doc) {
        
        String url = "";
        
        try {
            Elements uk = doc.select("[id=tab-uk-racing]");
            if(uk != null  && !uk.isEmpty()) {
                Elements cidades = uk.select(".meeting-title");
                if(cidades != null  && !cidades.isEmpty()) {
                    Elements links = cidades.select(".race-navigation-link");
                    if(links != null  && !links.isEmpty()) {
                        for (Element link : links) {

                            if(!link.text().toLowerCase().contains("abandoned")) {
                            
                                url = "http://www.attheraces.com" + link.attr("href");

                                System.out.println("CARREGANDO URL: " + url);

                                Document docRaceCard = Jsoup.connect(url).timeout(10000).get();

                                String hora = url.split("/")[6];
                                String pista = url.split("/")[4];
                                String winner = "";
                                Double oddFav = new Double(0);
                                String nomeFav = "";
                                String oddFavText = "";
                                Double oddFav2 = new Double(0);
                                String nomeFav2 = "";
                                String oddFav2Text = "";
                                String distance = docRaceCard.select(".distance").select("span").text();
                                double dist = new DistanciaConverter().getMetros(distance);
                                String numCavalosText = docRaceCard.select(".race-head__main").select(".secondary").text().split("-")[1].trim();
                                int numCavalos = Integer.valueOf(docRaceCard.select(".race-head__main").select(".secondary").text().split("-")[1].replace("ran", "").replace("declared to run", "").trim());
                                boolean achouOddFav = false;
                                boolean achouOddFav2 = false;

                                for (Element table : docRaceCard.select("[id=racecard-table-racecard-results]")) {
                                    for (Element body : table.select("tbody")) {

                                        winner = body.select("[class=name summary form-link horse-form-link]").get(0).text();

                                        for (Element tr : body.select("tr")) {
                                            int col = 1;
                                            for (Element td : tr.select("td")) {
                                                for(Element tdOdd : td.select(".starting-price")) {
                                                    if(!tdOdd.text().toLowerCase().contains("jfav") && !tdOdd.text().toLowerCase().contains("cfav") && !tdOdd.text().toLowerCase().contains("c2fav")) {
                                                        if(tdOdd.text().toLowerCase().contains("2fav") || tdOdd.text().toLowerCase().contains("j2fav")) {
                                                            oddFav2Text = tdOdd.text();
                                                            oddFav2 = OddConverter.converte(tdOdd.text());
                                                            nomeFav2 = tr.select("[class=name summary form-link horse-form-link]").get(0).text();
                                                            achouOddFav2 = true;
                                                        } else if(tdOdd.text().toLowerCase().contains("fav")) {
                                                            oddFavText = tdOdd.text();
                                                            oddFav = OddConverter.converte(tdOdd.text());
                                                            nomeFav = tr.select("[class=name summary form-link horse-form-link]").get(0).text();
                                                            achouOddFav = true;
                                                        }
                                                    }
                                                }
                                            } 
                                        }
                                    }
                                }

                                if(achouOddFav || achouOddFav2) {
                                    new InformocoesDAO().salvar(dia, hora, pista, oddFav, nomeFav, oddFavText, oddFav2, nomeFav2, oddFav2Text, distance, numCavalosText, winner, url, numCavalos, dist);
                                }
                            }
                        }
                        ocorreuErro = false;
                    } else {
                        msgErro = "Horários (.race-navigation-link) não encontrado.";
                        addLog(msgErro,url);
                    }
                } else {
                    msgErro = "Cidades (.meeting-title) não encontradas.";
                    addLog(msgErro,url);
                }
            } else {
                msgErro = "Tab '[id=tab-uk-racing]' não encontrada.";
                addLog(msgErro,url);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            msgErro = stackToString(ex);
            addLog(msgErro,url);
        } catch (SQLException ex) {
            ex.printStackTrace();
            msgErro = stackToString(ex);
            addLog(msgErro,url);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            msgErro = stackToString(ex);
            addLog(msgErro,url);
        }
    }

    public String stackToString(Throwable t) {
        if(t != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            return sw.toString();
        }
        return "Desconhecido";
    }
    
    @Override
    public void run() {
        
        String url = "http://www.attheraces.com/ajax/racenavigation/" + dateToUrl(dia) + "#tab-uk-racing";
        addLog("Buscando", url);
        System.out.println(url);
        
        try {
            
            //System.out.println("CARREGANDO URL: " + url);
            getLinkDeTodasCorridasDia(Jsoup.connect(url).timeout(15000).get());
            
            if(!ocorreuErro) {
                addLog("Concluído", url);
            } else {
                addLog("ERRO: " + msgErro, url);
            }
        } catch (IOException ex) {
            msgErro = "Erro carregando link: " + url + " --- " + stackToString(ex);;
            addLog(msgErro, url);
        }
    }
    
    private void addLog(String msg, String url) {
        formLog.atualiza(dia, msg, url);
    }
    
}
