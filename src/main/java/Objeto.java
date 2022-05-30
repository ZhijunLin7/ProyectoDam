import java.util.ArrayList;

public class Objeto extends Entidad{
    private int id;
    private String descripcion;
    private int cantidad;

    public Objeto(){}

    public Objeto(String nombre, int hpMax, int hp, int mpMax, int mp, int fuerza, int inteligencia, int defensa, String descripcion, int cantidad) {
        this.setNombre(nombre);
        this.setHpMax(hpMax);
        this.setHp(hp);
        this.setMpMax(mpMax);
        this.setMp(mp);
        this.setFuerza(fuerza);
        this.setInteligencia(inteligencia);
        this.setDefensa(defensa);
        this.setDescripcion(descripcion);
        this.setCantidad(cantidad);
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

    public static Objeto buscarObjeto(String nombre, ArrayList<Objeto> listaObjetos) {
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (listaObjetos.get(i).getNombre().equals(nombre)) {
                return listaObjetos.get(i);
            }
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
