import java.util.Random;

public class Enemigo extends Entidad{
    private int id;

    public Enemigo(int id, String nombre, int hpMax, int hp, int mpMax, int mp, int fuerza, int inteligencia, int defensa) {
        this.setId(id);
        this.setNombre(nombre);
        this.setHpMax(hpMax);
        this.setHp(hp);
        this.setMpMax(mpMax);
        this.setMp(mp);
        this.setFuerza(fuerza);
        this.setInteligencia(inteligencia);
        this.setDefensa(defensa);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void subirDificultad(int numeroSala) {
        Random r = new Random();
        this.hpMax = this.hpMax + r.nextInt(3)+ numeroSala;
        this.mpMax = this.mpMax + r.nextInt(3) + numeroSala;
        this.hp = this.hpMax;
        this.mp = this.mpMax;
        this.ataque = this.ataque + r.nextInt(3) + numeroSala;
        this.defensa = this.defensa + r.nextInt(3) + numeroSala;
    }
}
