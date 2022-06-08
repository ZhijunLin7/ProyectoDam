import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Datos")
public class Datos extends HttpServlet{
    private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String resultado = "";
    try {
        resultado=BaseDatos.monstruoinfo();
    } catch (ClassNotFoundException | SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    resp.addHeader("Access-Control-Allow-Origin","*" );
    resp.getWriter().append(String.valueOf(resultado));
   }
        
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String estatmons = req.getParameter("Estatmons");
        String estatjug = req.getParameter("Estatjug");

        String monspart [] = estatmons.split(",");
        String jugpart [] = estatjug.split(",");

        int Ataquemons = (int) (Integer.parseInt(monspart[15])+Integer.parseInt(monspart[19])*0.5-Integer.parseInt(monspart[23]));
        int Ataquejug = (int) (Integer.parseInt(jugpart[17])+Integer.parseInt(jugpart[23])*0.5-Integer.parseInt(jugpart[25]));
        int vidajug = Integer.parseInt(jugpart[3])-Ataquemons;
        int vidamons =Integer.parseInt(monspart[11])-Ataquejug;
        String jugrev = "";
        String monsrev = "";

        for (int i = 0; i < jugpart.length; i++) {
            if (i!=3) {
                jugrev = jugrev+ jugpart[i] +",";
            }
            else{
                jugrev = jugrev+ String.valueOf(vidajug) +",";
            }
        }
        for (int j = 0; j < monspart.length; j++) {
            if (j!=11) {
                monsrev = monsrev+ monspart[j] +",";
            }
            else{
                monsrev = monsrev+ String.valueOf(vidamons) +",";
            }
        }

        String infobatl = "Hiciste-"+ Ataquejug+ "-de dano al monstruo" +", Te hizo- "+ Ataquemons+ "-de dano";
        String resultado=jugrev+";"+monsrev+";"+infobatl;

        resp.addHeader("Access-Control-Allow-Origin","*" );
		resp.getWriter().append(String.valueOf(resultado));

   }

}

