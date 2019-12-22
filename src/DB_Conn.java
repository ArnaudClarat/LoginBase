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
        MD5 passMD5 = new MD5(pass);
        String sql = "INSERT INTO users VALUES(,"+ nom +", " + passMD5.getHash() + ")";
        try {
            Statement st = conn.createStatement();
            System.out.println(st.executeQuery(sql).getBoolean(0));
            return true;
        } catch (SQLException e) {
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
            MD5 passMD5 = new MD5(rs.getString("U_Pass"));
            return (passMD5.equals(pass));
        } catch (SQLException e) {
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
