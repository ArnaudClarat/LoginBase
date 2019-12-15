import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DB_Conn {

    public static Connection getDB(){
        // Connexion à la DB
        String myUrl = "jdbc:mysql://localhost/5ipoo";
        try {
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            // Connection conn = ConnectionHelper("user","",myUrl);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean newUser(String nom, String pass, Connection conn) throws SQLException {
        MD5 passMD5 = new MD5(pass);
        String sql = "INSERT INTO users VALUES(,"+ nom +", " + passMD5.getHash() + ")";
        Statement st = conn.createStatement();
        System.out.println(st.executeQuery(sql).getBoolean(0));
        return true;
    }

    public static boolean verifPass(String nom, String pass, Connection conn) {
        // vérification propre
        String sql = "SELECT U_Pass FROM users WHERE U_Login = " + nom;
        try {
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            MD5 passMD5 = new MD5(rs.getString("U_Pass"));
            return (passMD5.equals(pass));
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
