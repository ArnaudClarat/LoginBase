import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DB_Conn {
    private static DB_Conn connectionDatabase;
    private static Connection conn;

    static Connection getDB() throws ClassNotFoundException {
        try {
            System.out.println("Loading driver");
            Class.forName("com.mysql.cj.jdbc.Driver"); // Chargement du driver
            System.out.println("Driver loaded");
            // Connexion à la DB
            System.out.println("Connection..");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/5ipoo?serverTimezone=UTC", "root", "");
            System.out.println("Connection done");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Cannot connect to the database!");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean newUser(String nom, String pass, Connection conn) {
        MD5 md5 = new MD5();
        try {
            md5.setHash(pass);
            String passMD5 = md5.getHash();
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO users (U_Login, U_Pass) VALUES(?,?)");
            pStmt.setString(1, nom);
            pStmt.setString(2, passMD5);
            return pStmt.execute();
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verifPass(String nom, String pass, Connection conn) {
        // vérification propre
        try {
            String sql = "SELECT U_Pass FROM users WHERE U_Login =?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, nom);
            ResultSet rs = preparedStmt.executeQuery();
            rs.next();
            MD5 md5 = new MD5();
            md5.setHash(rs.getString("U_Pass"));
            return (md5.equals(pass));
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
