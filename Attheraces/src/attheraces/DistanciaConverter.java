/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

/**
 *
 * @author marce
 */
public class DistanciaConverter {
    
    public double getMetros(String distancia) {
        double metros = 0;
        String[] dados = distancia.split(" ");
        for(String d : dados) {
            if(d.toLowerCase().contains("m")) {
                metros += Double.valueOf(d.toLowerCase().replace("m", "")) * 1609;
            }
            if(d.toLowerCase().contains("f")) {
                metros += Double.valueOf(d.toLowerCase().replace("f", "")) * 201;
            }
            if(d.toLowerCase().contains("y")) {
                metros += Double.valueOf(d.toLowerCase().replace("y", "")) * 0.91;
            }
        }
        return metros;
    }
    
}
