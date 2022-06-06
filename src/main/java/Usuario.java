
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Usuario")
public class Usuario extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private int id_usuario;
    private String Nom_usuario;
    private String contrasena;

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNom_usuario() {
        return Nom_usuario;
    }
    public void setNom_usuario(String nom_usuario) {
        Nom_usuario = nom_usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resultado = "";
        
        String operacion = req.getParameter("operacion");
        switch (operacion) {
            case "login":
                try {
                    resultado=BaseDatos.login(req.getParameter("username"),req.getParameter("password"));
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case "registrar":
                try {
                    resultado=BaseDatos.registrar(req.getParameter("username"),req.getParameter("password"),req.getParameter("password2"));
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
                break;
        }
       
        
        resp.addHeader("Access-Control-Allow-Origin","*" );
		resp.getWriter().append(String.valueOf(resultado));
        
    }
   

}
