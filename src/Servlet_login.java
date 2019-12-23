import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Servlet_login", urlPatterns = {"/login"})
public class Servlet_login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupération des paramètres
        String nom = request.getParameter("nom");
        String password = request.getParameter("password");

        Connection connection;
        connection = DB_Conn.getDB();
        assert connection != null;
        if (DB_Conn.verifPass(nom, password, connection)) {
            System.out.println("Pass OK");
            HttpSession session = request.getSession();
            session.setAttribute("nom", nom);
            request.getRequestDispatcher("views/bienvenue.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
            System.out.println("Pass NOK");
        }

        /*
        // vérification à la dure
        if ( nom.equals("Arnaud") && password.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("nom", nom);
            request.getRequestDispatcher("views/bienvenue.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }
}
