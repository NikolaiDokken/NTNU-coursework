import java.sql.*;
import java.util.ArrayList;

public class Database {

    // All information needed to connect to the database
    private static final String username = "nikolard";
    private static final String password = "bLa7Qdy7";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dBUrl = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/" + username + "?user=" + username + "&password=" + password;

    // Method that registers a user
    public static void hentOgSkrivKostnader() {
        Connection con = getCon();
        PreparedStatement prepStmt = null;
        ResultSet res = null;
        try {
            String query = "SELECT prosj_id, kunde, tekst, beløp FROM prosjekt JOIN prosjektkostnader USING(prosj_id) WHERE faktura_sendt IS NULL ORDER BY prosj_id, kunde;";
            prepStmt = con.prepareStatement(query);
            res = prepStmt.executeQuery();
            while (res.next()) {
                Tekstfil.skriv(res.getString("prosj_id") +
                        "; " + res.getString("tekst") + "; " +
                        res.getString("kunde") + "; " +
                        res.getDouble("beløp") + "\n");
            }
            /*
            String query2 = "UPDATE prosjektkostnader SET faktura_sendt=CURRENT_DATE() WHERE faktura_sendt IS NULL;";
            prepStmt = con.prepareStatement(query2);
            prepStmt.executeUpdate();
            */
        } catch (SQLSyntaxErrorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, prepStmt, null);
        }
    }

    public static void hentOgSkrivArbeid() {
        Connection con = getCon();
        PreparedStatement prepStmt = null;
        ResultSet res = null;
        int forrigeProsj = 0;
        String forrigeKunde = "";
        double tot = 0;
        try {
            String query = "SELECT prosj_id, kunde, SUM(utgift) as utgift FROM arbeid GROUP BY prosj_id";
            prepStmt = con.prepareStatement(query);
            res = prepStmt.executeQuery();
            while (res.next()) {
                int prosjNr = res.getInt("prosj_id");
                String kunde = res.getString("kunde");
                Double utgift = res.getDouble("utgift");
                Tekstfil.skriv(prosjNr + "; timer; " + kunde + "; " + utgift + "\n");
            }
            /*
            String query2 = "UPDATE prosjektarbeid SET faktura_sendt=CURRENT_DATE() WHERE faktura_sendt IS NULL;";
            prepStmt = con.prepareStatement(query2);
            prepStmt.executeUpdate();
            */
        } catch (SQLSyntaxErrorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, prepStmt, null);
        }
    }

    // Use this whenever you want to connect to the database
    public static Connection getCon() {
        Connection con= null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dBUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con, PreparedStatement prepStmt, ResultSet res) {
        try {
            if (res != null) {
                res.close();
            }
            if (prepStmt != null) {
                prepStmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}