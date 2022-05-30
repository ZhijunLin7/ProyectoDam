import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Entidad{
    private ArrayList<Objeto> inventario;

    public Jugador() {
    }

    public static void crearjugador() {
        Random r = new Random();
        Jugador jugador = new Jugador();
        jugador.setNivel(1);
        jugador.setExpSubida(100);
        jugador.setExp(0);
        jugador.setHpMax(r.nextInt(15) + 15);
        jugador.setHp(jugador.getHpMax());
        jugador.setMpMax(r.nextInt(10) + 10);
        jugador.setMp(jugador.getMp());
        jugador.setFuerza(r.nextInt(9)+1);
        jugador.setInteligencia(r.nextInt(9)+1);
        jugador.setDefensa(r.nextInt(9)+1);
    }

    public void subirNivel() {
        Random r = new Random();
        int i = 0;
        boolean encontrado = false;
        if (this.getExp() >= this.getExpSubida()) {
            this.setHpMax(this.getHpMax() + r.nextInt(4)+1);
            this.setHp(this.getHpMax());
            this.setMpMax(this.getMpMax() + r.nextInt(4)+1);
            this.setMp(this.getMpMax());
            this.setFuerza(this.getFuerza() + r.nextInt(1)+1);
            this.setInteligencia(this.getInteligencia() + r.nextInt(1)+1);
            this.setDefensa(this.getDefensa() + r.nextInt(1)+1);
            this.setNivel(this.getNivel()++);
            this.setExpSubida(this.getNivel() * 100);
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
