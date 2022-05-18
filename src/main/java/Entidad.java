import java.util.ArrayList;
import java.util.Random;

public abstract class Entidad {
    private String nombre;
    private int nivel;
    private int hpMax;
    private int mpMax;
    private int hp;
    private int mp;
    private int fuerza;
    private int inteligencia;
    private int vitalidad;
    private int voluntad;
    private int agilidad;
    private int dano;
    private int precision;
    private int velocidadAtaque;
    private int critico;
    private int danoCritico;
    private int evasion;
    private int danoMagia;
    private int defensa;
    private int criticoMagico;
    private int defensaMagica;
    private ArrayList<Habilidad> habilidades;
    public String descripcion;

    public Entidad(String nombre, int nivel, int hpMax, int mpMax, int hp, int mp, int fuerza, int inteligencia, int vitalidad, int voluntad, int agilidad, int dano, int precision, int velocidadAtaque, int critico, int danoCritico, int evasion, int danoMagia, int defensa, int criticoMagico, int defensaMagica) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.hpMax = hpMax;
        this.mpMax = mpMax;
        this.hp = hp;
        this.mp = mp;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.vitalidad = vitalidad;
        this.voluntad = voluntad;
        this.agilidad = agilidad;
        this.dano = dano;
        this.precision = precision;
        this.velocidadAtaque = velocidadAtaque;
        this.critico = critico;
        this.danoCritico = danoCritico;
        this.evasion = evasion;
        this.danoMagia = danoMagia;
        this.defensa = defensa;
        this.criticoMagico = criticoMagico;
        this.defensaMagica = defensaMagica;
    }

    public Entidad() {
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

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getVoluntad() {
        return voluntad;
    }

    public void setVoluntad(int voluntad) {
        this.voluntad = voluntad;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getVelocidadAtaque() {
        return velocidadAtaque;
    }

    public void setVelocidadAtaque(int velocidadAtaque) {
        this.velocidadAtaque = velocidadAtaque;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }

    public int getDanoCritico() {
        return danoCritico;
    }

    public void setDanoCritico(int danoCritico) {
        this.danoCritico = danoCritico;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getDanoMagia() {
        return danoMagia;
    }

    public void setDanoMagia(int danoMagia) {
        this.danoMagia = danoMagia;
    }

    public int getCriticoMagico() {
        return criticoMagico;
    }

    public void setCriticoMagico(int criticoMagico) {
        this.criticoMagico = criticoMagico;
    }

    public int getDefensaMagica() {
        return defensaMagica;
    }

    public void setDefensaMagica(int defensaMagica) {
        this.defensaMagica = defensaMagica;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void atacar(Entidad atacado) {
        Random r = new Random();
        int ataque = this.getPrecision() + (r.nextInt(9) + 1);
        int defensa = atacado.getEvasion() + (r.nextInt(9) + 1);
        if (ataque >= defensa) {
            int dano = this.getDano() - atacado.getDefensa();
            atacado.setHp(atacado.getHp() - dano);
            System.out.println(this.getNombre() + " ha hecho " + dano + " puntos de daño a " + atacado.getNombre());
        } else {
            System.out.println('¡' + atacado.getNombre() + " ha esquivado el ataque de " + this.getNombre());
        }
    }

    public void ensenarHabilidades() {
        for (int i = 0; i < this.getHabilidades().size(); i++) {
            System.out.println(i + '.' + this.getHabilidades().get(i).toString());
        }
    }
}

