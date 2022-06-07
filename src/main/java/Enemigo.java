import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Enemigo {

    
    private int mid;
    private String mnombre;
    private int mnivel;
    private int mhpMax;
    private int mmpMax;
    private int mhp;
    private int mmp;
    private int mfuerza;
    private int minteligencia;
    private int mVitalidad;
    private int mVoluntad;
    private int mdefensa;
    private int mAgilidad;
    

    public Enemigo(int id, String nombre, int nivel, int hpMax, int mpMax, int hp, int mp, int fuerza, int inteligencia,
            int defensa, int vitalidad, int voluntad, int agilidad) {
        this.mid = id;
        this.mnombre = nombre;
        this.mnivel = nivel;
        this.mhpMax = hpMax;
        this.mmpMax = mpMax;
        this.mhp = hp;
        this.mmp = mp;
        this.mfuerza = fuerza;
        this.minteligencia = inteligencia;
        this.mdefensa = defensa;
        this.mVitalidad = vitalidad;
        this.mVoluntad = voluntad;
        this.mAgilidad = agilidad;
    }



    @Override
    public String toString() {
        return "mid," + mid + ",mnombre," + mnombre + ",mnivel," + mnivel
                + ",mhpMax," + mhpMax + ",mmpMax," + mmpMax + ",mhp," + mhp + ",mmp," + mmp + ",mfuerza,"
                + mfuerza + ",minteligencia," + minteligencia + ",mVitalidad," + mVitalidad + ",mVoluntad," + mVoluntad + ",mdefensa,"
                + mdefensa + ",mAgilidad," + mAgilidad;
    }



   
}
