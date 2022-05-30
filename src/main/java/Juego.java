import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Juego
 */
@WebServlet("/Juego")
public class Juego extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Juego.iniciarJuego();
        String resultat = "";
        try {
            resultat = BasesDades.getSelect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No s'ha pogut accedir a la BBDD");
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().append(resultat);

    }
    public static void iniciarJuego(){
        ArrayList<Objeto> listaObjetos = BaseDatos.obtenerObjetos();
        Sala sala = new Sala();
        Jugador jugador = Jugador.crearjugador(listaObjetos);


    }
}
