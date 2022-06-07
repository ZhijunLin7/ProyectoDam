
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jugador")
public class Jugador extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private int nivel;
    private int expSubida;
    private int exp;
    private int hpMax;
    private int mpMax;
    private int hp;
    private int mp;
    private int fuerza;
    private int inteligencia;
    private int defensa;
    private int Vitalidad;
    private int Voluntad;
    private int Agilidad;
  

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String resultado = "";
        try {
            resultado=BaseDatos.info_jugador(req.getParameter("id_usuario"));
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        resp.addHeader("Access-Control-Allow-Origin","*" );
		resp.getWriter().append(String.valueOf(resultado));
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random ran = new Random();
        
        String estat = "Fuerza,"+ran.nextInt(20)+",Inteligencia,"+ran.nextInt(20)+",Vitalidad,"+ran.nextInt(20)+",Voluntad,"+ran.nextInt(20)+",Defensa,"+ran.nextInt(20)+",Agilidad,"+ran.nextInt(20);
        
        resp.addHeader("Access-Control-Allow-Origin","*" );
		resp.getWriter().append(String.valueOf(estat));
    }

}
