import java.util.Random;

public class Enemigo extends Entidad{
    private int idEnemigo;

    public Enemigo(String nombre, int nivel, int hpMax, int mpMax, int hp, int mp, int fuerza, int inteligencia, int vitalidad, int voluntad, int agilidad, int dano, int precision, int velocidadAtaque, int critico, int danoCritico, int evasion, int danoMagia, int defensa, int criticoMagico, int defensaMagica, int idEnemigo) {
        super(nombre, nivel, hpMax, mpMax, hp, mp, fuerza, inteligencia, vitalidad, voluntad, agilidad, dano, precision, velocidadAtaque, critico, danoCritico, evasion, danoMagia, defensa, criticoMagico, defensaMagica);
        this.idEnemigo = idEnemigo;
    }
}
