import java.util.ArrayList;
import java.util.Random;

public class Objeto {
    private String nombre;
    private int idObjeto;
    private String descripcion;
    private int cantidad;

    public Objeto(){}
    public Objeto(String nombre, String descripcion, int cantidad) {
        this.idroot++;
        id=idroot;
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCantidad(cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static void objetoRandom(ArrayList<Objeto> listaObjetos) {
        Random r = new Random();
        int idObjeto = r.nextInt(listaObjetos.size());
        for (int i = 0; i < listaObjetos.size(); i++) {

        }
    }

    public void pocionSalud(Jugador jugador) {
        if (jugador.getHp() + 20 > jugador.getHpMax()) {
            jugador.setHp(jugador.getHpMax());
        } else {
            jugador.setHp(jugador.getHp() + 20);
        }
        this.setCantidad(this.getCantidad() - 1);
    }

    public void pocionMagia(Jugador jugador) {
        if (jugador.getMp() + 20 > jugador.getMpMax()) {
            jugador.setMp(jugador.getMpMax());
        } else {
            jugador.setMp(jugador.getMp() + 20);
        }
        this.setCantidad(this.getCantidad() - 1);
    }

    @Override
    public String toString() {
        return this.getNombre()+" x"+this.getCantidad()+" = "+this.getDescripcion();
    }


}
