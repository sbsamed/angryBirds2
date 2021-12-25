/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev_3_2;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class oyunEkrani extends JFrame {

    public oyunEkrani(String title) throws HeadlessException {
        super(title);
    }
    

    public static void main(String[] args) {
        oyunEkrani ekran=new oyunEkrani("SamedBaskın");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        
        ekran.setSize(1300, 800);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        oyun_2 oyun=new oyun_2();
        oyun.requestFocus();
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        ekran.add(oyun);
        
        ekran.setVisible(true);
    }
    
    
}

