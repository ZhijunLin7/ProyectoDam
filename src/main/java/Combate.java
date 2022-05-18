import java.util.ArrayList;
import java.util.Scanner;

public class Combate {
    public Jugador jugador;
    public Enemigo enemigo;

    public Combate() {};
    public Combate(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigos(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public void Pelea() {
        boolean combate = true;
        int opcionMenu;
        Scanner teclado = new Scanner(System.in);
        int ataque;
        while (combate) {
            Main.informacion(jugador, enemigo);
            System.out.println("¿Que vas a hacer?");
            System.out.println("1. Golpe");
            System.out.println("2. Magia (5 mp)");
            System.out.println("3. Usar objeto");
            opcionMenu = teclado.nextInt();
            teclado.nextLine();
            switch (opcionMenu) {
                case 1:
                    ataque = jugador.atacar(enemigo);
                    if (ataque == 0) {
                        System.out.println("Has fallado!");
                    } else {
                        System.out.println("Has hecho " + ataque + " puntos de daño.");
                        enemigo.setHp(enemigo.getHp() - ataque);
                    }
                    break;
                case 2:
                    ataque = jugador.magia(enemigo.getDefensa());
                    if (ataque == -1) {
                        System.out.println("No tienes suficiente mp.");
                    } else if (ataque == 0) {
                        System.out.println("Has fallado!");
                    } else {
                        System.out.println("Has hecho " + ataque + " puntos de daño.");
                        enemigo.setHp(enemigo.getHp() - ataque);
                    }
                    break;
                case 3:
                    jugador.usarObjeto();
                    break;
            }
            System.out.println(enemigo.getNombre() + " ataca!");
            ataque = enemigo.ataque(jugador.getDefensa());
            if (ataque == 0) {
                System.out.println("El ataque ha fallado!");
            } else {
                System.out.println(enemigo.getNombre() + " te ha hecho " + ataque + " puntos de daño.");
                jugador.setHp(jugador.getHp() - ataque);
            }
        }
    }
}
