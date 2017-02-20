/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DecimalFormat;

/**
 *
 * @author marce
 */
public class Teste {

  public static void main(String args[]) {
  double numero = 1.9851008;
  DecimalFormat formatador = new DecimalFormat("0.00");
  System.out.println("Número antes da formatação: " + numero);
  System.out.println("Número depois formatação: " + formatador.format(numero));
 }

}
