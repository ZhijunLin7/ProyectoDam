public class Habilidad extends Entidad{
    private int idHabilidad;

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getDescripcion();
    }
}
