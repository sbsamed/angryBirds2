
package odev_3_2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class oyun_2 extends JPanel implements KeyListener,ActionListener {
                
    Timer timer = new Timer(3,this);
          private BufferedImage image,image2;
          float alpha =1f;
          float alpha2 =0f;
          double aci=50,hiz;
          int hedefX,kontrol=1;
          double xSpeed,ySpeed;
          double time, delayy = 0.09 ,G=9.8 ;
          double startX ;
          double startY ;
          double ballX, ballY;
         
        public oyun_2(){
             int k;
             Random random = new Random();
            do{
            k= Math.abs((random.nextInt()))%1200;
            } while(k<300);
            hedefX=k;
             System.out.println(hedefX);
             hiz= 3.7*(hedefX*G)/ 2* Math.cos (aci*(Math.PI / 180))*Math.sin(aci * (Math.PI / 180));
             hiz=Math.sqrt(hiz);
       
        ballX=startX = 90;
        ballY =startY = 670;
            setBackground(Color.white);
        
        try {
            image=ImageIO.read(new FileImageInputStream(new File("birds.png")));
        } catch (IOException ex) {
            Logger.getLogger(oyun_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            image2=ImageIO.read(new FileImageInputStream(new File("sapan.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(oyun_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                 }
   
       public void hizHesapla(){
            int k;
             Random random = new Random();
            do{
            k= Math.abs((random.nextInt()))%1200;
            } while(k<300);
            hedefX=k;
             System.out.println(hedefX);
             hiz= 3.6*(hedefX*G)/ 2* Math.cos (aci*(Math.PI / 180))*Math.sin(aci * (Math.PI / 180));
             hiz=Math.sqrt(hiz);
        }
   
    @Override
    public void paint(Graphics g) {
       
     super.paint(g); 
         ImageIcon i= new ImageIcon("image.jpg");
        i.paintIcon(this, g, 0, 0);
     Graphics2D g2d = (Graphics2D) g.create();
        
         g2d.drawImage(image,(int)ballX,(int)ballY,image.getWidth()/7,image.getHeight()/7,this);
          
         g2d.drawImage(image2,10,680,image.getWidth()/5,image.getHeight()/5,this);
        
            g2d.setColor(Color.red);
            
            AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            g2d.fillRect(hedefX, 680, 100, 80);
           
             g2d.setColor(Color.black);
            AlphaComposite alcom2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);
            g2d.setComposite(alcom2);
            g2d.fillOval((hedefX+5), 720, 40, 40);
             g2d.dispose();
          }

    @Override
    public void repaint() {
        super.repaint(); 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c=e.getKeyCode();
  
        if(c== KeyEvent.VK_SPACE){
        timer.start();
         }
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      xSpeed = hiz * Math.cos(aci * (Math.PI / 180));
       ySpeed = hiz * Math.sin(aci * (Math.PI / 180));
       ballX = startX + (xSpeed * time);
       ballY = startY - ((ySpeed *time)-(0.5 *G * Math.pow(time, 2)));
       time += delayy; 
        repaint();
        if(ballX>hedefX && ballX <1280 && ballY>700 && ballY<800){
             alpha =0f;
             alpha2=1f;
             timer.stop();
             ballX= startX = 90;
             ballY =  startY = 670;
             time=0.09;
             this.hizHesapla();
             repaint();
             alpha =1f;
             alpha2=0f;
     
        }
       
        
    }
}

