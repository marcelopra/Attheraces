/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class DataUtils {

    public static String QUINTA_FEIRA = "Quinta-feira";
    
    /**
     * 
     * @param data Data a ser formatada
     * @param formato Formato para formatar a data. Ex.: dd/MM/yyyy HH:mm:ss
     * @return Retorna a data passada por parâmetro no formato informado.
     */
    public static String getDataFormatada(Date data, String formato) {
        if(data != null) {
            SimpleDateFormat f = new SimpleDateFormat(formato);
            return f.format(data);
        }
        return "";
    }
    
    /**
     * Função utilizada para formatar a data no seguinte formato: dd/MM/yyyy - HH:mm:ss (dia semana)
     * @param data Data para ser formatada.
     * @return Uma String no formato dd/MM/yyyy - HH:mm:ss (dia semana)
     */
    public static String getDataHoraDiaSemanaFormatada(Date data) {
        return getDataFormatada(data, "dd/MM/yyyy") + " - " + getDataFormatada(data, "HH:mm:ss") + " (" + getNomeDiaSemana(data) + ")";
    }
    
    /**
     * Função utilizada para formatar a data no seguinte formato: dd/MM/yyyy - (dia semana)
     * @param data Data para ser formatada.
     * @return Uma String no formato dd/MM/yyyy - (dia semana)
     */
    public static String getDataDiaSemanaFormatada(Date data) {
        return getDataFormatada(data, "dd/MM/yyyy") + " - " + " (" + getNomeDiaSemana(data) + ")";
    }
    
    public static long getDiffSegundos(Date dataMenor, Date dataMaior) {
        return (dataMenor.getTime() - dataMaior.getTime()) / 1000;
    }

    /**
     * Função responsável em transforma uma String em um Date.
     * @param data String a ser formatada. Ex.: 01/01/2012
     * @param formato Formato em que a string passada se encontra.
     * @return Um Date que reprenseta a String.
     * @throws ParseException Caso ocorra algum erro ao realizar a conversão.
     */
    public static Date toDate(String data, String formato) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(formato);
        return f.parse(data);
    }
    
    /**
     * Tenta converter a string passada por parâmetro para o formato, caso consiga
     * retorna TRUE, caso contrário retorna FALSE.
     */
    public static boolean validaFormatoData(String data, String formato) {
        try {
            SimpleDateFormat f = new SimpleDateFormat(formato);
            f.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static List<Date> getDatasEntreDuasDatas(Date dataInicial, Date dataFinal) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataFinal);
        List<Date> listagem = new ArrayList<>();
        int diffDias = (int) diferencaEmDias(dataInicial, dataFinal);
        if(diffDias == 0) {
            listagem.add(dataFinal);
        } else {
            listagem.add(dataFinal);
            for(int i=0; i<diffDias; i++) {
                c.add(Calendar.DAY_OF_YEAR, -1);
                listagem.add(c.getTime());
            }
        }
        return listagem;
    }
    
    /**
     * Verifica se o Dia, Mes e Ano das datas passadas por parametros são iguais. O restante dos campos
     * são ignorados na comparação.
     * @return 0-Quando os campos Dia, Mes e Ano das duas datas forem iguais. 1-Quando a data um for maior que a data dois.
     * -1- Quando a data um for menor que a data dois;
     */
    public static int comparaDiaMesAno(Date dataUm, Date dataDois) {
        Calendar cUm = Calendar.getInstance();
        Calendar cDois = Calendar.getInstance();
        
        cUm.setTime(dataUm);
        cDois.setTime(dataDois);
        
        if(cUm.get(Calendar.YEAR) == cDois.get(Calendar.YEAR) && 
                cUm.get(Calendar.MONTH) == cDois.get(Calendar.MONTH) &&
                cUm.get(Calendar.DAY_OF_MONTH) == cDois.get(Calendar.DAY_OF_MONTH)) {
            return 0;
        } else if(cUm.get(Calendar.YEAR) > cDois.get(Calendar.YEAR)) {
            return 1;
        } else if(cUm.get(Calendar.YEAR) == cDois.get(Calendar.YEAR) && 
                cUm.get(Calendar.MONTH) > cDois.get(Calendar.MONTH)) {
            return 1;
        } else if(cUm.get(Calendar.YEAR) == cDois.get(Calendar.YEAR) && 
                cUm.get(Calendar.MONTH) == cDois.get(Calendar.MONTH) &&
                cUm.get(Calendar.DAY_OF_MONTH) > cDois.get(Calendar.DAY_OF_MONTH)) {
            return 1;
        } else {
            return -1;
        }
    }
    
    /**
     * Verifica se o Dia, Mes, Ano, Hora, Minuto e Segundo das datas passadas por parametros são iguais. O restante dos campos
     * são ignorados na comparação.
     * @return 0-Quando os campos Dia, Mes, Ano, Hora, Minuto e Segundo das duas datas forem iguais. 
     * 1-Quando a data um for maior que a data dois.
     * -1- Quando a data um for menor que a data dois;
     */
    public static int comparaDiaMesAnoHoraMinutoSegundo(Date dataUm, Date dataDois) {
        Calendar cUm = Calendar.getInstance();
        Calendar cDois = Calendar.getInstance();
        
        cUm.setTime(dataUm);
        cDois.setTime(dataDois);
        
        int rtn = comparaDiaMesAno(dataUm, dataDois);
        
        if(rtn == 0) {
            if(cUm.get(Calendar.HOUR_OF_DAY) == cDois.get(Calendar.HOUR_OF_DAY) && 
                cUm.get(Calendar.MINUTE) == cDois.get(Calendar.MINUTE) &&
                cUm.get(Calendar.SECOND) == cDois.get(Calendar.SECOND)) {
                return 0;
            } else if(cUm.get(Calendar.HOUR_OF_DAY) > cDois.get(Calendar.HOUR_OF_DAY)) {
                return 1;
            } else if(cUm.get(Calendar.HOUR_OF_DAY) == cDois.get(Calendar.HOUR_OF_DAY) && 
                    cUm.get(Calendar.MINUTE) > cDois.get(Calendar.MINUTE)) {
                return 1;
            } else if(cUm.get(Calendar.HOUR_OF_DAY) == cDois.get(Calendar.HOUR_OF_DAY) && 
                    cUm.get(Calendar.MINUTE) == cDois.get(Calendar.MINUTE) &&
                    cUm.get(Calendar.SECOND) > cDois.get(Calendar.SECOND)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return rtn;
        }
    }
    
    /**
     * Verifica se o Dia, Mes, Ano, Hora, Minuto e Segundo das datas passadas por parametros são iguais. O restante dos campos
     * são ignorados na comparação.
     * @return 0-Quando os campos Dia, Mes, Ano, Hora, Minuto e Segundo das duas datas forem iguais. 
     * 1-Quando a data um for maior que a data dois.
     * -1- Quando a data um for menor que a data dois;
     */
    public static int comparaDiaMesAnoHoraMinuto(Date dataUm, Date dataDois) {
        Calendar cUm = Calendar.getInstance();
        Calendar cDois = Calendar.getInstance();
        
        cUm.setTime(dataUm);
        cDois.setTime(dataDois);
        
        int rtn = comparaDiaMesAno(dataUm, dataDois);
        
        if(rtn == 0) {
            if(cUm.get(Calendar.HOUR_OF_DAY) == cDois.get(Calendar.HOUR_OF_DAY) && 
                cUm.get(Calendar.MINUTE) == cDois.get(Calendar.MINUTE)) {
                return 0;
            } else if(cUm.get(Calendar.HOUR_OF_DAY) > cDois.get(Calendar.HOUR_OF_DAY)) {
                return 1;
            } else if(cUm.get(Calendar.HOUR_OF_DAY) == cDois.get(Calendar.HOUR_OF_DAY) && 
                    cUm.get(Calendar.MINUTE) > cDois.get(Calendar.MINUTE)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return rtn;
        }
    }
    
    /**
     * Verifica qual dia da semana a data passada por parãmetro se refere e retorna o nome do mesmo.
     * @param data Data para se obter o nome do dia da semana.
     * @return Retorna o nome do dia da semana da data passada por parãmetro. Ex.: "Segunda-Feira".
     */
    public static String getNomeDiaSemana(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        
        String[] diaSemana = new String[]{"Domingo", "Segunda-feira",
            "Terça-feira","Quarta-feira", QUINTA_FEIRA,"Sexta-feira","Sábado"};
        return diaSemana[c.get(Calendar.DAY_OF_WEEK) - 1];
    }
    
   /** 
     * Calcula a diferença de duas datas em dias 
     * <br> 
     * <b>Importante:</b> Quando realiza a diferença em dias entre duas datas, este método considera as horas restantes e as converte em fração de dias. 
     * @param dataInicial 
     * @param dataFinal 
     * @return quantidade de dias existentes entre a dataInicial e dataFinal. 
     */  
    public static double diferencaEmDias(Date dataInicial, Date dataFinal){  
        if(dataInicial != null && dataInicial != null) {
            double result = 0;  
            long diferenca = dataFinal.getTime() - dataInicial.getTime();  
            double diferencaEmDias = (diferenca /1000) / 60 / 60 /24; //resultado é diferença entre as datas em dias  
            long horasRestantes = (diferenca /1000) / 60 / 60 %24; //calcula as horas restantes  
            result = diferencaEmDias + (horasRestantes /24d); //transforma as horas restantes em fração de dias  

            return result;  
        }
        return 0;
    }  
      
    /** 
     * Calcula a diferença de duas datas em horas 
     * <br> 
     * <b>Importante:</b> Quando realiza a diferença em horas entre duas datas, este método considera os minutos restantes e os converte em fração de horas. 
     * @param dataInicial 
     * @param dataFinal 
     * @return quantidade de horas existentes entre a dataInicial e dataFinal. 
     */  
    public static int diferencaEmHoras(Date dataInicial, Date dataFinal){ 
        if(dataInicial != null && dataInicial != null) {
            double result = 0;  
            long diferenca = dataFinal.getTime() - dataInicial.getTime();  
            long diferencaEmHoras = (diferenca /1000) / 60 / 60;  
            long minutosRestantes = (diferenca / 1000)/60 %60;  
            double horasRestantes = minutosRestantes / 60d;  
            result = diferencaEmHoras + (horasRestantes);  

            return (int) result;  
        }
        return 0;
    }  
      
    /** 
     * Calcula a diferença de duas datas em minutos 
     * <br> 
     * <b>Importante:</b> Quando realiza a diferença em minutos entre duas datas, este método considera os segundos restantes e os converte em fração de minutos. 
     * @param dataInicial 
     * @param dataFinal 
     * @return quantidade de minutos existentes entre a dataInicial e dataFinal. 
     */  
    public static Integer diferencaEmMinutos(Date dataInicial, Date dataFinal){
        if(dataInicial != null && dataFinal != null) {
            double result = 0;  
            long diferenca = dataFinal.getTime() - dataInicial.getTime();  
            double diferencaEmMinutos = (diferenca /1000) / 60; //resultado é diferença entre as datas em minutos  
            long segundosRestantes = (diferenca / 1000)%60; //calcula os segundos restantes  
            result = diferencaEmMinutos + (segundosRestantes /60d); //transforma os segundos restantes em minutos  
            return (int) result;
        }
        return 0;
    }
    
    /** 
     * Calcula a diferença de duas datas em Segundos
     * <br> 
     * @param dataInicial 
     * @param dataFinal 
     * @return quantidade de segundos existentes entre a dataInicial e dataFinal. 
     */  
    public static Integer diferencaEmSegundos(Date dataInicial, Date dataFinal){
        if(dataInicial != null && dataInicial != null) {
            long diferenca = dataFinal.getTime() - dataInicial.getTime();  
            double diferencaEmSegundos = (diferenca /1000); //resultado é diferença entre as datas em segundos  
            return (int) diferencaEmSegundos;
        }
        return 0;
    }
    
    /**
     * Função utilizada para se somar um dia util a data. Dessa forma se a data for igual a uma
     * Sexta-Feira por exemplo, se for somando +1 dia util, a mesma irá cair na próxima Segunda-Feira.
     * @param data
     * @return 
     */
    public static Date somarUmDiaUtil(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, 1);
        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return c.getTime();
    }
    
    /**
     * Soma um dia a data passada por parâmetro.
     * @return A data com dia somando.
     */
    public static Date somarUmDia(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
    
    /**
     * Soma dias a data passada por parâmetro.
     * @return A data com dia somando.
     */
    public static Date somarDias(Date data, int qtdeDias) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, qtdeDias);
        return c.getTime();
    }
    
    /**
     * Soma as horas passadas por parâmetro a data.
     * @return A data com as horas somadas
     */
    public static Date adicionarHoras(Date data, Integer qtdeHorasParaSomar) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.HOUR_OF_DAY, qtdeHorasParaSomar);
        return c.getTime();
    }
    
    public static Date getDataAtualComAsHorasZeradas() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }
    
    /**
     * Subtrai um dia a data passada por parâmetro.
     * @return A data com dia subtraido.
     */
    public static Date dimunuirUmDia(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }
    
    /**
     * Subtrai um dia a data passada por parâmetro.
     * @return A data com dia subtraido.
     */
    public static Date dimunuirDias(Date data, int qtdeDias) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, qtdeDias*-1);
        return c.getTime();
    }
    
    public static int getMesDoAno(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.MONTH) +1;
    }
    
    public static int getAno(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.YEAR);
    }
    
    public static int getDiaDoMes(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.DAY_OF_MONTH);
    }
    
    public static int getHoraDoDia(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.HOUR_OF_DAY);
    }
    
    public static int getMinuto(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.MINUTE);
    }
    
    public static int getSegundo(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.SECOND);
    }
    
    /**
     * Cria uma nova data com os parametros passados.
     */
    public static Date criarNovaData(int dia, int mes, int ano, int hora, int minuto, int segundo) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, dia);
        c.set(Calendar.MONTH, mes-1);
        c.set(Calendar.YEAR, ano);
        c.set(Calendar.HOUR_OF_DAY, hora);
        c.set(Calendar.MINUTE, minuto);
        c.set(Calendar.SECOND, segundo);
        return c.getTime();
    }
    
    /**
     * Se a hora atual do DIA for maior que 19 e menor que 6, então retorna TRUE, significando
     * que agora é o período da noite, caso contrário retorna FALSE.
     */
    public static boolean agoraIsNoturno() {
        Calendar c = Calendar.getInstance();
        int horaDoDia = c.get(Calendar.HOUR_OF_DAY);
        if(horaDoDia > 19 && horaDoDia < 6) {
            return true;
        }
        return false;
    }
    
    /**
     * Se a hora atual do DIA for maior que 6 e menor que 12, então retorna TRUE, significando
     * que agora é o perído da manhã, caso contrário retorna FALSE.
     */
    public static boolean agoraIsMatutino() {
        Calendar c = Calendar.getInstance();
        int horaDoDia = c.get(Calendar.HOUR_OF_DAY);
        if(horaDoDia > 6 && horaDoDia < 12) {
            return true;
        }
        return false;
    }
    
    /**
     * Se a hora atual do DIA for maior que 12 e menor que 19, então retorna TRUE, significando
     * que agora é o perído da tarde, caso contrário retorna FALSE.
     */
    public static boolean agoraIsVespertino() {
        Calendar c = Calendar.getInstance();
        int horaDoDia = c.get(Calendar.HOUR_OF_DAY);
        if(horaDoDia > 12 && horaDoDia < 19) {
            return true;
        }
        return false;
    }
    
    public static Integer getUltimoDiaMes(Integer mes, Integer ano) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONDAY, mes);
        c.set(Calendar.YEAR, ano);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * @return Retorna a "HORA" da data informada.
     */
    public static int getHora(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.HOUR_OF_DAY);
    }
    
        /**
     * Atualiza o campo "MINURO" da data passada por parâmetro.
     * @param data Data para ser atualizada
     * @param novoMinuto Novo minuto para ser setado no campo "MINUTO".
     * @return Retorna a data com o campo "MINUTO" atualizado.
     */
    public static Date setMinuto(Date data, int novoMinuto) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.MINUTE, novoMinuto);
        return c.getTime();
    }
    
    /**
     * Atualiza o campo "HORA" da data passada por parâmetro.
     * @param data Data para ser atualizada
     * @param novaHora Nova hora para ser setado no campo "HORA".
     * @return Retorna a data com o campo "HORA" atualizado.
     */
    public static Date setHora(Date data, int novaHora) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR_OF_DAY, novaHora);
        return c.getTime();
    }
    
    public static Date setDiaMes(Date data, int novoDia) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.DAY_OF_MONTH, novoDia);
        return c.getTime();
    }
}
