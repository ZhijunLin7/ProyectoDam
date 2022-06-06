import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class test {


    public static void test1() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/proyectodam";
        String query = "SELECT id_usuario,Nom_usuario,contrasena FROM usuario where Nom_usuario='pepe'";

		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        
       
                String query2 = "INSERT INTO usuario (Nom_usuario, contrasena) VALUES ('pepe','123')";
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
        
        

    }
    public static String info_jugador(int id_usuario) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/proyectodam";
		String query ="SELECT * FROM `personaje` join estadistica on estadistica.id_personaje= personaje.id_personaje where personaje.id_personaje="+id_usuario+";";
		
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

       
        rs.next();
        String nombre=rs.getString("personaje.nom_personaje");
        if (nombre==null) {
            return null;
        }
        else {
            
            
            String jugador ="{nom_personaje:"+rs.getString("personaje.nom_personaje")+
                            ",habitacion:"+rs.getString("personaje.habitacion")+
                            ",oro:"+rs.getString("personaje.oro")+
                            ",NIVEL:"+rs.getString("estadistica.NIVEL")+
                            ",EXPERIENCIA_MAX:"+rs.getString("estadistica.EXPERIENCIA_MAX")+
                            ",EXPERIENCIA:"+rs.getString("estadistica.EXPERIENCIA")+
                            ",VIDA_MAX:"+rs.getString("estadistica.VIDA_MAX")+
                            ",MAGIA_MAXIMA:"+rs.getString("estadistica.MAGIA_MAXIMA")+
                            ",VIDA:"+rs.getString("estadistica.VIDA")+
                            ",MAGIA:"+rs.getString("estadistica.MAGIA")+
                            ",FUERZA:"+rs.getString("estadistica.FUERZA")+
                            ",INTELIGENCIA:"+rs.getString("estadistica.INTELIGENCIA")+
                            ",VITALIDAD:"+rs.getString("estadistica.VITALIDAD")+
                            ",VOLUNTAD:"+rs.getString("estadistica.VOLUNTAD")+
                            ",DEFENSA:"+rs.getString("estadistica.DEFENSA")+
                            ",AGILIDAD:"+rs.getString("estadistica.AGILIDAD")+"}'";


            return jugador;

        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
        
     
           
        
        
    }
}
