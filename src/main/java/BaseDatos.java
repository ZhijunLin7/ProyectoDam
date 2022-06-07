

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 * BaseDatos
 */
public class BaseDatos {
    //Hacer login comprobar el usuario y contraseña
    public static String login(String Nom_usuario,String contrasena) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/proyectodam";
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
    //Sirve para registrar
    public static String registrar(String Nom_usuario,String contrasena,String contrasena2) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/proyectodam";
        String query = "SELECT id_usuario,Nom_usuario,contrasena FROM usuario where Nom_usuario='"+Nom_usuario+"'";

		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        
        if (rs.next()==false) {
            if (contrasena.equals(contrasena2)) {
                
                String query2 = "INSERT INTO usuario (Nom_usuario, contrasena) VALUES ('"+Nom_usuario+"','"+contrasena+"')";
                st.executeUpdate(query2);

                rs = st.executeQuery(query);
                rs.next();
                int id_usuario = rs.getInt("id_usuario");
                System.out.println(id_usuario);
                
                String query3 = "INSERT INTO personaje (id_personaje) VALUES ("+id_usuario+")";
                String query4 = "INSERT INTO estadistica (id_personaje) VALUES ("+id_usuario+")";
                String query5 = "insert into personaje_inventario(ID_PERSONAJE,NUM_CASILLA) VALUES("+id_usuario+",1),("+id_usuario+",2),("+id_usuario+",3),("+id_usuario+",4),("+id_usuario+",5),("+id_usuario+",6),("+id_usuario+",7),("+id_usuario+",8)";
                String query6 = "insert into personaje_habilidades(ID_PERSONAJE,num_habilidad) VALUES("+id_usuario+",1),("+id_usuario+",2),("+id_usuario+",3),("+id_usuario+",4)";

                st.executeUpdate(query3);
                st.executeUpdate(query4);
                st.executeUpdate(query5);
                st.executeUpdate(query6);
                
                return "Registracion correcto";
            } else {
                return "No coincide los dos contrasena";
            }

        }
        else{
            return "Ya existe el Usuario introducido";
        } 
        
    }

    //Devuelve stat de jugador si hay.
    public static String info_jugador(String string) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/proyectodam";
		String query ="SELECT * FROM `personaje` join estadistica on estadistica.id_personaje= personaje.id_personaje where personaje.id_personaje="+string+";";
		
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

       
        rs.next();
        String nombre=rs.getString("personaje.nom_personaje");
        if (nombre==null) {
            return null;
        }
        else {
            
            String jugador ="nom_personaje,"+rs.getString("personaje.nom_personaje")+
                            ",VIDA,"+rs.getString("estadistica.VIDA")+
                            ",MAGIA,"+rs.getString("estadistica.MAGIA")+
                            ",NIVEL,"+rs.getString("estadistica.NIVEL")+
                            ",EXPERIENCIA,"+rs.getString("estadistica.EXPERIENCIA")+
                            ",EXPERIENCIA_MAX,"+rs.getString("estadistica.EXPERIENCIA_MAX")+
                            ",VIDA_MAX,"+rs.getString("estadistica.VIDA_MAX")+
                            ",MAGIA_MAXIMA,"+rs.getString("estadistica.MAGIA_MAXIMA")+
                            ",FUERZA,"+rs.getString("estadistica.FUERZA")+
                            ",INTELIGENCIA,"+rs.getString("estadistica.INTELIGENCIA")+
                            ",VITALIDAD,"+rs.getString("estadistica.VITALIDAD")+
                            ",VOLUNTAD,"+rs.getString("estadistica.VOLUNTAD")+
                            ",DEFENSA,"+rs.getString("estadistica.DEFENSA")+
                            ",AGILIDAD,"+rs.getString("estadistica.AGILIDAD")+
                            ",habitacion,"+rs.getString("personaje.habitacion")+
                            ",oro,"+rs.getString("personaje.oro");
                            
            return jugador;
        }
  
    }

    public static String monstruoinfo() throws SQLException, ClassNotFoundException {
        Random ran = new Random();
        ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/proyectodam";
        String query = "SELECT * FROM monstruo";

        Connection con = DriverManager.getConnection(url, "root", "");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            Enemigo enemigo = new Enemigo(rs.getInt("ID_MONSTRUOS"),rs.getString("NOMBRE_MONSTRO"), rs.getInt("NIVEL"), rs.getInt("VIDA_MAXIMA"), rs.getInt("MAGIA_MAXIMA"), rs.getInt("VIDA_MAXIMA"), rs.getInt("MAGIA_MAXIMA"), rs.getInt("FUERZA"),rs.getInt("INTELIGENCIA"),rs.getInt("VITALIDAD"),rs.getInt("VOLUNTAD"), rs.getInt("DEFENSA"),rs.getInt("AGILIDAD"));
            listaEnemigos.add(enemigo);
        }
        int aleatoria = ran.nextInt(listaEnemigos.size());
        String monstruo =listaEnemigos.get(aleatoria).toString();
        return monstruo;
        
   
    }
}