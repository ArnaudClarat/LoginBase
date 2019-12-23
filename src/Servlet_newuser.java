import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet(name = "Servlet_newuser", urlPatterns = {"/newuser"})
public class Servlet_newuser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = DB_Conn.getDB();
        assert conn != null;
        DB_Conn.newUser("Arnaud", "coucou", conn);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
