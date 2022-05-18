import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void informacion(Jugador jugador, Enemigo enemigo) {
        System.out.println("Jugador");
        System.out.println("Nombre = "+jugador.getNombre()+" , HP = "+jugador.getHp()+'/'+jugador.getHpMax()+" MP = "+jugador.getMp()+'/'+jugador.getMpMax());
        System.out.println("Fuerza = "+jugador.getFuerza()+" Inteligencia = "+jugador.getInteligencia()+" Defensa = "+jugador.getDefensa());
        System.out.println("Nivel = "+jugador.getNivel()+" Experiencia = "+jugador.getExp()+'/'+jugador.getExpSubida());
        System.out.println("--------------------------");
        System.out.println("Enemigo");
        System.out.println("Nombre = "+enemigo.getNombre()+" , HP = "+enemigo.getHp()+'/'+enemigo.getHpMax()+" MP = "+enemigo.getMp()+'/'+enemigo.getMpMax());
        System.out.println("Ataque = "+enemigo.getAtaque()+" Defensa = "+enemigo.getDefensa());
    }

    public static boolean continuar() {
        Scanner teclado = new Scanner(System.in);
        String decision;
        System.out.println("¿Quieres volver a intentarlo? (y/n)");
        decision = teclado.nextLine();
        if (decision.equals("n")) {
            return false;
        } else{
            return true;
        }
    }
    public static void main(String[] args) {
        ArrayList<String> listaNombres = new ArrayList<String>();
        Random r = new Random();
        Collections.addAll(listaNombres, "Mauricio", "Jose", "Antonio", "Venancio", "Jorge", "Mateo");
        Jugador jugador = new Jugador();
        Objeto pocionSalud = new Objeto("Pocion de salud", "Cura 20 puntos de salud", 5);
        Objeto pocionMagia = new Objeto("Pocion de magia", "Restablece 20 puntos de magia", 5);
        Collections.addAll(jugador.getInventario(), pocionSalud, pocionMagia);
        int experiencia;
        int ataque;
        jugador.setNombre(listaNombres.get(r.nextInt(listaNombres.size())));
        Scanner teclado = new Scanner(System.in);
        int opcionMenu;
        boolean programa = true;
        int contadorSalas = 0;
        while (programa) {
            contadorSalas++;
            Enemigo enemigo = new Enemigo();
            enemigo.setNombre(listaNombres.get(r.nextInt(listaNombres.size())));
            enemigo.subirDificultad(contadorSalas);
            System.out.println("Sala "+contadorSalas);
            System.out.println("El enemigo "+enemigo.getNombre()+" se interpone en tu camino!");
            boolean combate = true;
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
                        ataque = jugador.atacar(enemigo.getDefensa());
                        if (ataque == 0) {
                            System.out.println("Has fallado!");
                        } else {
                            System.out.println("Has hecho "+ataque+" puntos de daño.");
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
                            System.out.println("Has hecho "+ataque+" puntos de daño.");
                            enemigo.setHp(enemigo.getHp() - ataque);
                        }
                        break;
                    case 3:
                        jugador.usarObjeto();
                        break;
                }
                System.out.println(enemigo.getNombre()+" ataca!");
                ataque = enemigo.ataque(jugador.getDefensa());
                if (ataque == 0) {
                    System.out.println("El ataque ha fallado!");
                } else {
                    System.out.println(enemigo.getNombre()+" te ha hecho "+ataque+" puntos de daño.");
                    jugador.setHp(jugador.getHp() - ataque);
                }
                if (jugador.getHp() <= 0) {
                    System.out.println("Has perdido!");
                    System.out.println("Has completado con exito "+(contadorSalas - 1)+ " sala/s.");
                    combate = false;
                    programa = Main.continuar();
                } else if (enemigo.getHp() <= 0) {
                    System.out.println("Has ganado!");
                    experiencia = r.nextInt(30) + 20;
                    System.out.println("Has ganado "+experiencia+" puntos de experiencia.");
                    jugador.setExp(jugador.getExp() + experiencia);
                    jugador.subirNivel();
                    combate = false;
                }
            }
        }
    }
}
