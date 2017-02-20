/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import java.text.DecimalFormat;

/**
 *
 * @author marce
 */
public class OddConverter {
    
    public static double converte(String odd) {
        try {
            
            System.out.println(odd);
            if(odd.toLowerCase().contains("even")) {
                return 2;
            }
            
            odd = odd.toLowerCase().replace("jfav", "").replace("cfav", "").replace("c2fav", "").replace("2fav", "").replace("j2fav", "").replace("fav2", "").replace("fav", "").replace("j", "").replace("fav", "").replace("c", "").trim();
            String[] values = odd.split("/");
            double x = Integer.valueOf(values[0]);
            double y = Integer.valueOf(values[1]);
            double result = x/y;
            DecimalFormat formatador = new DecimalFormat("0.00");
            return Double.valueOf(formatador.format(result).replace(",", ".")) + 1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
}
