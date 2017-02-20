/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.DecimalFormat;
import java.util.Date;
import util.DataUtils;

/**
 *
 * @author marce
 */
public class Informacoes {
    
    private Date data;
    private String hora;
    private String pista;
    private double oddFav;
    private String oddFavText;
    private String nomeOddFav;
    private double oddFav2;
    private String nomeOddFav2;
    private String oddFav2Text;
    private String distancia;
    private String numCavalos;
    private String campeao;
    private String link;
    private double dist;

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public String getOddFavText() {
        return oddFavText;
    }

    public void setOddFavText(String oddFavText) {
        this.oddFavText = oddFavText;
    }

    public String getOddFav2Text() {
        return oddFav2Text;
    }

    public void setOddFav2Text(String oddFav2Text) {
        this.oddFav2Text = oddFav2Text;
    }
    
    public String getDataToString() {
        return DataUtils.getDataFormatada(data, "dd/MM/yy");
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public double getOddFav() {
        return oddFav;
    }
    
    public void setOddFav(double oddFav) {
        this.oddFav = oddFav;
    }

    public String getNomeOddFav() {
        return nomeOddFav;
    }

    public void setNomeOddFav(String nomeOddFav) {
        this.nomeOddFav = nomeOddFav;
    }

    public double getOddFav2() {
        return oddFav2;
    }
    
    public void setOddFav2(double oddFav2) {
        this.oddFav2 = oddFav2;
    }

    public String getNomeOddFav2() {
        return nomeOddFav2;
    }

    public void setNomeOddFav2(String nomeOddFav2) {
        this.nomeOddFav2 = nomeOddFav2;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getNumCavalos() {
        return numCavalos;
    }

    public void setNumCavalos(String numCavalos) {
        this.numCavalos = numCavalos;
    }

    public String getCampeao() {
        return campeao;
    }

    public void setCampeao(String campeao) {
        this.campeao = campeao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
