
package tankattack.clases;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class Tanque {
    private final GameLoop gameLoop;
    static int x;
    static int y;
    static int Orientacion;
    //int BordeSuperior,BordeInferior,BordeIzquierdo,BordeDerecho;
    protected int BordeSuperior=0;
    protected int BordeInferior=520;
    protected int BordeIzquierdo=0;
    protected int BordeDerecho=750;
    
     ArrayList <Bala> ArrayBalas= new ArrayList <> ();
    //Imagen del tanque hacia arriba
    Image TankUP = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankUP.png")).getImage();
    //Imagen del tanque hacia abajo
    Image TankDOWN = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankDOWN.png")).getImage();
    //Imagen del tanque hacia la izquierda
    Image TankLEFT = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankLEFT.png")).getImage();
    //Imagen del tanque hacia la derecha
    Image TankRIGHT = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankRIGHT.png")).getImage();
   
    public Tanque(GameLoop gameLoop) {
        
       this.gameLoop = gameLoop;
    }
    
    Image Dibujo;
    public void paint(Graphics2D g) {
        g.drawImage(Dibujo, x, y, 50, 50, null);
         
        
    }
    
    public void eventos(KeyEvent ke){
        int pasos=10;
       
        switch(ke.getKeyCode()) {
            case  KeyEvent.VK_UP:
                if(y>BordeSuperior){
                        y=y-pasos;
                        Dibujo=TankUP;
                        Orientacion=1;}
            break;
            case  KeyEvent.VK_DOWN:
                if(y<BordeInferior){
                        y=y+pasos;
                        Dibujo=TankDOWN;
                        Orientacion=2;}
            break;
            case  KeyEvent.VK_LEFT:
                if(x>BordeIzquierdo){
                        x=x-pasos;
                        Dibujo=TankLEFT;    
                        Orientacion=3;}
            break;
            case  KeyEvent.VK_RIGHT:
                if(x<BordeDerecho){
                        x=x+pasos;
                        Dibujo=TankRIGHT;
                        Orientacion=4;}
            break;
            case KeyEvent.VK_NUMPAD0:
                Bala bala= new Bala(gameLoop);
                ArrayBalas.add(bala);
            break;
        }   //Traza del tanque en x e y
            System.out.println("x="+x+"  y="+y+"  "+Orientacion);
        }
    
    
    public static int Sentido(){
        System.out.println("Sentido"+Orientacion);
        return Orientacion;
    }
    public static int x(){
        return x;
    }
    public static int y(){
        return y;
    }
}