import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class test {
    public static String test1() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3308/proyectodam";
        String Nom_usuario="Prueba1";
		String query = "SELECT id_usuario,Nom_usuario,contrasena FROM usuario where Nom_usuario='"+Nom_usuario+"'";
		
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

        if (rs.next()==true) {
            System.out.println(rs.getString(2));
        }
        String resultado =(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        return resultado;
        
        
        

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String te=test1();
           System.out.println(te);
        
        
           
        
        
    }
}
