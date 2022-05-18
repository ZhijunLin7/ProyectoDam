import java.util.ArrayList;
import java.util.Random;

public class Sala {
    private static int numTotal = 0;
    private int num;
    private String tipo;
    private ArrayList<Enemigo> enemigos;

    public Sala() {
        this.numTotal++;
        this.num = this.numTotal;
    }
    public Sala(String tipo) {
        this.numTotal++;
        this.num = this.numTotal;
        this.tipo = tipo;
    }

    public static int getNumTotal() {
        return numTotal;
    }

    public static void setNumTotal(int numTotal) {
        Sala.numTotal = numTotal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static Sala crearSala() {
        Random r = new Random();
        String[] salaTipos = new String[2];
        salaTipos[0] = "Combate";
        salaTipos[1] = "Tesoro";
        Sala sala = new Sala(salaTipos[r.nextInt(1)]);
        return sala;
    }

    public void salaTipo(Sala sala) {
        Random r = new Random();
        String tipo = Sala.crearSala().getTipo();
        switch (tipo) {
            case "Combate":
                int numEnemigos = r.nextInt(3)+1;
                for(int i = 0; i < numEnemigos; i++) {
                    Enemigo enemigo = new Enemigo();
                    this.enemigos.add(enemigo);                }
                break;
            case "Tesoro":
                int objetoSala = r.nextInt(5);
                break;
        }
    }
}
