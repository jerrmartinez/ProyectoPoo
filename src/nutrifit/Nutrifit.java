/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrifit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy martinez
 */
public class Nutrifit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            MenuFront mf = new MenuFront();
        } catch (InterruptedException ex) {
            Logger.getLogger(Nutrifit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
