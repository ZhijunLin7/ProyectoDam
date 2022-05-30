import java.util.Random;

public class Entidad {
    private String nombre;
    private int nivel;
    private int expSubida;
    private int exp;
    private int hpMax;
    private int mpMax;
    private int hp;
    private int mp;
    private int fuerza;
    private int inteligencia;
    private int defensa;

    public Entidad(String nombre, int nivel, int expSubida, int exp, int hpMax, int mpMax, int hp, int mp, int fuerza, int inteligencia, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.expSubida = expSubida;
        this.exp = exp;
        this.hpMax = hpMax;
        this.mpMax = mpMax;
        this.hp = hp;
        this.mp = mp;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int atacar(int defensaAtacado) {
        Random r = new Random();
        int dado = r.nextInt(5) + 1;
        if (this.getFuerza() + dado >= defensaAtacado) {
            dado = r.nextInt(5) + 1;
            return dado + this.getFuerza();
        } else {
            return 0;
        }
    }
}
