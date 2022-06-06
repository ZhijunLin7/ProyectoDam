import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try {
            BaseDatos.info_jugador("10");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
}
