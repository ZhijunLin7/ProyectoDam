

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                return rs.getString("id_usuario");
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

    public static ArrayList<Objeto> obtenerObjetos() throws ClassNotFoundException, SQLException {
        ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3308/proyectodam";
        String query = "SELECT * FROM objetos";

        Connection con = DriverManager.getConnection(url, "root", "");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            Objeto objeto = new Objeto(rs.getString("nombre"), rs.getInt("hpMax"), rs.getInt("hp"), rs.getInt("mpMax"), rs.getInt("mp"), rs.getInt("fuerza"), rs.getInt("inteligencia"), rs.getInt("defensa"), rs.getString("descripcion"), rs.getInt("cantidad"));
            listaObjetos.add(objeto);
        }
        return listaObjetos;
    }

    public static ArrayList<Enemigo> obtenerEnemigos() throws ClassNotFoundException, SQLException {
        ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3308/proyectodam";
        String query = "SELECT * FROM enemigos";

        Connection con = DriverManager.getConnection(url, "root", "");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            Enemigo enemigo = new Enemigo(rs.getInt("id"),rs.getString("nombre"), rs.getInt("hpMax"), rs.getInt("hp"), rs.getInt("mpMax"), rs.getInt("mp"), rs.getInt("fuerza"), rs.getInt("inteligencia"), rs.getInt("defensa"));
            listaEnemigos.add(enemigo);
        }
        return listaEnemigos;
    }

    public void guardarJugador(Jugador jugador) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3308/proyectodam";
        String query = "SELECT * FROM personaje where id='"+jugador.getId()+"'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        if (!rs.next()) {
            String query2= "INSERT INTO jugador (id, ) VALUES ('"+Nom_usuario+"','"+contrasena+"')";
        }

    }
    
}