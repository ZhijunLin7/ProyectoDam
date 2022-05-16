

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * BaseDatos
 */
public class BaseDatos {
    
    public static String login(String Nom_usuario,String contrasena) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3308/proyectodam";
		String query = "SELECT id_usuario,Nom_usuario,contrasena FROM usuario where Nom_usuario='"+Nom_usuario+"'";
		
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

        if (rs.next()==true) {
            if (contrasena.equals(rs.getString("contrasena"))) {
                return "Sesion iniciada correctamente";
            }
            else{
                return "Error de contrasena";
            }
        }
        else{
            return "No existe Usuario";
        }
        
    }
    public static String registrar(String Nom_usuario,String contrasena,String contrasena2) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3308/proyectodam";
        String query = "SELECT id_usuario,Nom_usuario,contrasena FROM usuario where Nom_usuario='"+Nom_usuario+"'";

		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        String query2 = "INSERT INTO usuario (Nom_usuario, contrasena) VALUES ('"+Nom_usuario+"','"+contrasena+"')";
        if (rs.next()==false) {
            if (contrasena.equals(contrasena2)) {
                st.executeUpdate(query2);
                return "Registracion correcto";
            } else {
                return "No coincide los dos contrasena";
            }

        }
        else{
            return "Ya existe el Usuario introducido";
        }

        

        
        
        
    }
    
}