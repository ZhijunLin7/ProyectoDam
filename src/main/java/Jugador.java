import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Entidad{
    private int idPersonaje;
    private int expSubida;
    private int exp;
    private ArrayList<Objeto> inventario;

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public int getExpSubida() {
        return expSubida;
    }

    public void setExpSubida(int expSubida) {
        this.expSubida = expSubida;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Objeto> inventario) {
        this.inventario = inventario;
    }

    public void subirNivel() {
        Random r = new Random();
        int i = 0;
        boolean encontrado = false;
        if (this.exp >= this.expSubida) {
            this.nivel++;
            this.exp = this.exp - this.expSubida;
            this.expSubida = 100 * this.nivel;
            this.hpMax = this.hpMax + r.nextInt(4 )+ 1;
            this.mpMax = this.mpMax + r.nextInt(4) + 1;
            this.hp = this.hpMax;
            this.mp = this.mpMax;
            this.fuerza = this.fuerza + r.nextInt(4)+1;
            this.inteligencia = this.inteligencia + r.nextInt(4) + 1;
            this.defensa = this.defensa + r.nextInt(4) + 1;
            System.out.println("Has subido a nivel "+this.nivel);
        }
    }

    public int atacar(int defensaEnemigo) {
        Random r = new Random();
        int dado = r.nextInt(5) + 1;
        if (this.getFuerza() + dado >= defensaEnemigo) {
            dado = r.nextInt(5) + 1;
            return dado + this.getFuerza();
        } else {
            return 0;
        }
    }

    public int magia(int defensaEnemigo) {
        Random r = new Random();
        int dado = r.nextInt(5) + 1;
        if (this.getMp() < 5) {
            return -1;
        } else {
            this.setMp(this.getMp() - 5);
            if (dado + this.getInteligencia() >= defensaEnemigo) {
                dado = r.nextInt(11) + 1;
                return dado + this.getInteligencia();
            } else {
                return 0;
            }
        }
    }

    public void consultarInventario() {
        for (int i = 0; i < this.getInventario().size(); i++) {
            System.out.println(i+". "+this.getInventario().get(i).toString());
        }
    }

    public void usarObjeto() {
        Scanner teclado = new Scanner(System.in);
        int eleccionObjeto;
        int idObjeto;
        System.out.println("¿Que objeto quieres usar?");
        this.consultarInventario();
        eleccionObjeto = teclado.nextInt();
        teclado.nextLine();
        idObjeto = this.getInventario().get(eleccionObjeto).getId();
        if (this.getInventario().get(eleccionObjeto).getCantidad() < 1) {
            System.out.println("No tienes unidades de este objeto.");
        } else {
            switch(idObjeto) {
                case 1:
                    this.getInventario().get(eleccionObjeto).pocionSalud(this);
                    break;
                case 2:
                    this.getInventario().get(eleccionObjeto).pocionMagia(this);
                    break;
                case 3:

            }

        }
    }
}
