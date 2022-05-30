import java.util.Random;

public class Enemigo {
    private String nombre;
    private int hpMax;
    private int mpMax;
    private int hp;
    private int mp;
    private int ataque;
    private int defensa;

    public Enemigo() {
        Random r = new Random();
        this.hpMax = r.nextInt(25) + 10;
        this.mpMax = r.nextInt(25) + 10;
        this.hp = this.hpMax;
        this.mp = this.mpMax;
        this.ataque = r.nextInt(4) + 2;
        this.defensa = r.nextInt(4) + 2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getMpMax() {
        return mpMax;
    }

    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
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
