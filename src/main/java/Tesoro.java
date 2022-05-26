import java.util.ArrayList;
import java.util.Random;

public class Tesoro {
    private ArrayList<Objeto> recompensa;

    public Tesoro(){
        ArrayList<Objeto> recompensa = new ArrayList<Objeto>();
        this.setRecompensa(recompensa);
    }

    public ArrayList<Objeto> recompensaSala(Jugador jugador, ArrayList<Objeto> listaObjetos) {
        Random r = new Random();
        for (int i = 0; i < (r.nextInt(3) + 1); i++ ) {
            this.getRecompensa();
        }
    }
}
