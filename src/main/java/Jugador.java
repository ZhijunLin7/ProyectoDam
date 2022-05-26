import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Entidad{
    private int idPersonaje;
    private int expSubida;
    private int exp;
    private ArrayList<Objeto> inventario;

    public Jugador() {
        Random r = new Random();
        this.setFuerza(r.nextInt(4) + 1);
        this.setAgilidad(r.nextInt(4) + 1);
        this.setVitalidad(r.nextInt(4) + 1);
        this.setVoluntad(r.nextInt(4) + 1);
        this.setInteligencia(r.nextInt(4) + 1);
        this.setDestreza(r.nextInt(4) + 1);
        this.setDano(this.getFuerza() * 2);
        this.setPrecision(this.getDestreza() * 2);
        this.setVelocidadAtaque(this.getAgilidad() * 2);
        this.setCritico(this.getDestreza() * 2);
        this.setDanoCritico(this.getFuerza());
        this.setEvasion(this.getAgilidad() * 1);
        this.setDanoMagia(this.getVoluntad() * 2);
        this.setHpMax(this.getVitalidad() * 4);
        this.setMpMax(this.getInteligencia() * 3);
        this.setHp(this.getHpMax());
        this.setMp(this.getMpMax());
        this.setDefensa(this.getVitalidad() * 2);
        this.setCriticoMagico(this.getInteligencia() * 2);
        this.setDefensaMagica(this.getVoluntad());
        this.setDanoCriticoMagico(this.getInteligencia());
    }

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
            this.setNivel(this.getNivel() + 1);
            this.exp = this.exp - this.expSubida;
            this.expSubida = 100 * this.getNivel();
            this.setHp(this.getHpMax());
            this.setMp(this.getMpMax());
            this.setFuerza(this.getFuerza() + r.nextInt(4)+1);
            this.setInteligencia(this.getInteligencia() + r.nextInt(4) + 1);
            this.setVitalidad(this.getVitalidad() + r.nextInt(4) + 1);
            this.setVoluntad(this.getVoluntad() + r.nextInt(4) + 1);
            this.setAgilidad(this.getAgilidad() + r.nextInt(4) + 1);
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
