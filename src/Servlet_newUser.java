import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Servlet_newUser", urlPatterns = {"/newUser"})
public class Servlet_newUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupération des paramètres
        String nom = request.getParameter("nom");
        String password = request.getParameter("password");

        try {
            Connection conn = DB_Conn.getDB();
            boolean test = DB_Conn.newUser(nom, password, conn);
            System.out.println(test);
            if (test) {
                request.getRequestDispatcher("views/bienvenue.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
