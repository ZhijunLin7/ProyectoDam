import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try {
            
            System.out.println(BaseDatos.monstruoinfo());
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
}
