import java.sql.*;

public class Database {

    // Database information
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dBUrl = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/nikolard?user=nikolard&password=bLa7Qdy7";

    // Connections
    public Connection con;


    public Database() {
        this.con = getCon();
    }

    public Connection getCon() {
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(dBUrl);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void lukkForbindelse() {
        try {
            if (con != null) {
                con.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean regNyBok(Bok nyBok) {
        con = getCon();
        PreparedStatement prepStmt = null;
        try {
            prepStmt = con.prepareStatement("START TRANSACTION ");
            prepStmt.executeUpdate();
            String query = "INSERT INTO boktittel(isbn, forfatter, tittel) values(?, ?, ?);";
            String query2 = "INSERT INTO eksemplar(isbn, eks_nr) VALUES (?, 1);";
            prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, nyBok.getIsbn());
            prepStmt.setString(2, nyBok.getForfatter());
            prepStmt.setString(3, nyBok.getTittel());
            prepStmt.executeUpdate();
            prepStmt = con.prepareStatement(query2);
            prepStmt.setString(1, nyBok.getIsbn());
            prepStmt = con.prepareStatement("COMMIT;");
            prepStmt.executeUpdate();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            lukkForbindelse();
        }
        return false;
    }

    public int regNyttEksemplar(String isbn) {
        con = getCon();
        int eksNr = 0;
        PreparedStatement prepStmt = null;
        ResultSet res = null;
        try {
            String query = "SELECT MAX(eks_nr) as maks FROM eksemplar WHERE isbn=?";
            prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, isbn);
            res = prepStmt.executeQuery();
            res.next();
            eksNr = res.getInt("maks");
            if (eksNr == 0){
                return 0;
            } else {
                eksNr++;
                String query2 = "INSERT INTO eksemplar(isbn, eks_nr) VALUES (?, ?);";
                prepStmt = con.prepareStatement(query2);
                prepStmt.setString(1, isbn);
                prepStmt.setInt(2, eksNr);
                prepStmt.executeUpdate();
                return eksNr;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(null, prepStmt, res);
            lukkForbindelse();
        }
        return 0;
    }

    public boolean lånUtEksemplar(String isbn, String navn, int eksNr) {
        Connection con = getCon();
        if (!exists("eksemplar", "isbn", isbn, 0) || !exists("eksemplar", "eks_nr", null, eksNr)) {
            return false;
        }
        PreparedStatement prepStmt = null;
        try {
            String query = "UPDATE eksemplar SET laant_av = ? WHERE isbn = ? AND eks_nr = ?";
            prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, navn);
            prepStmt.setString(2, isbn);
            prepStmt.setInt(3, eksNr);
            prepStmt.executeUpdate();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(null, prepStmt, null);
            lukkForbindelse();
        }
        return false;
    }

    public boolean exists(String tableName, String columnName, String input, int intput) {
        con = getCon();
        PreparedStatement prepStmt = null;
        ResultSet res = null;
        try{
            String query = "SELECT " + columnName + " FROM " + tableName + " WHERE " + columnName + "=?;";
            prepStmt = con.prepareStatement(query);
            if (input != null) {
                prepStmt.setString(1, input);
            } else {
                prepStmt.setInt(1, intput);
            }
            res = prepStmt.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            closeConnection(null, prepStmt, res);
            lukkForbindelse();
        }
        return false;
    }

    public static void closeConnection(Connection con, Statement stmt, ResultSet res) {
        try {
            if (res != null) {
                res.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
