package tankattack.clases;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Bala {

    /* Objeto contenedor */
    Tanque tank;

    /* Variables globales */
    Image Bala;
    int x;
    int y;
    int direccion;
    int SPEEDX;
    int SPEEDY;
    int SPEEDFINAL = 18;
    boolean visible;
    static int impactoT1 = 0;
    static int impactoT2 = 0;

    public Bala(Tanque tank, int x, int y, int direcc) {

        this.tank = tank;
        visible = true;
        this.x = x;
        this.y = y;
        this.direccion = direcc;
        
        Bala = new ImageIcon(this.getClass()
                .getResource("/tankattack/imagenes/tanque/bala.png")).getImage();
        
        choice();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return Bala;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void update() {

        Rectangle rectanglePlayer = getBounds(direccion);
        if (y > Tanque.BordeInferior || y < Tanque.BordeSuperior || x > Tanque.BordeDerecho || x < Tanque.BordeIzquierdo) {
            visible = false;
        }
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 9; j++) {

                if (rectanglePlayer.intersects(Tablero.muros[i][j].getx(), Tablero.muros[i][j].gety(), 50, 50)) {

                    switch (Tablero.muros[i][j].getname()) {
                        case "ladrillo":
                            Tablero.muros[i][j].impactos++;
                            visible = false;
                            if (tank.jugador == 1) {
                                tank.tablero.escenario.marcador.highscore1 += 10;
                            } else {
                                tank.tablero.escenario.marcador.highscore2 += 10;
                            }
                            break;
                        case "piedra":
                            Tablero.muros[i][j].impactos++;
                            visible = false;
                            if (tank.jugador == 1) {
                                tank.tablero.escenario.marcador.highscore1 += 10;
                            } else {
                                tank.tablero.escenario.marcador.highscore2 += 10;
                            }
                            break;
                        case "acero":
                            Tablero.muros[i][j].impactos++;
                            visible = false;
                            if (tank.jugador == 1) {
                                tank.tablero.escenario.marcador.highscore1 += 10;
                            } else {
                                tank.tablero.escenario.marcador.highscore2 += 10;
                            }
                            break;
                    }

                }

            }
        }
        if (rectanglePlayer.intersects(tank.tablero.tanque1.getx(), tank.tablero.tanque1.gety(), 50, 50)) {
            visible = false;
            System.out.println("Impactado tanque 1");
            impactoT1++;
        }
        if (rectanglePlayer.intersects(tank.tablero.tanque2.getx(), tank.tablero.tanque2.gety(), 50, 50)) {
            visible = false;
            System.out.println("Impactado tanque 2");
            impactoT2++;
        }
        y += SPEEDY;
        x += SPEEDX;
    }

    public final void choice() {
        if (direccion == 1) {
            SPEEDX = 0;
            SPEEDY = -SPEEDFINAL;
        }
        if (direccion == 2) {
            SPEEDX = 0;
            SPEEDY = SPEEDFINAL;
        }
        if (direccion == 3) {
            SPEEDX = -SPEEDFINAL;
            SPEEDY = 0;
        }
        if (direccion == 4) {
            SPEEDX = SPEEDFINAL;
            SPEEDY = 0;
        }
        if (direccion == 0) {
            this.visible = false;
        }
    }

    public int getdir() {
        return direccion;
    }

    public Rectangle getBounds(int i) {
        switch (i) {
            case 1:
                return new Rectangle(x, y - 48, 20, 20);

            case 2:
                return new Rectangle(x, y + 68, 20, 20);

            case 3:
                return new Rectangle(x - 48, y, 20, 20);

            case 4:
                return new Rectangle(x + 68, y, 20, 20);

            default:
                return new Rectangle(x, y, 20, 20);
        }

    }

}
