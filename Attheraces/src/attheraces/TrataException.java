/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

/**
 *
 * @author u0181181
 */
public class TrataException {
    
    public static void fatal(String msg, Throwable throwable) {
        throwable.printStackTrace();
        new ViewException(throwable).setVisible(true);
    }
    
    public static void fatal(Throwable throwable) {
        fatal("Erro", throwable);
    }
    
}
