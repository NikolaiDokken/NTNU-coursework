import static javax.swing.JOptionPane.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class LeserInnISBN {
  public static void main(String[] args) throws Exception {
    String brukernavn = "nikolard";  // DataLeser, se nedenfor
    String passord = "bLa7Qdy7"; // bLa7Qdy7

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    }

    String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/nikolard?user=nikolard&password=" + passord;

    try(Connection con = DriverManager.getConnection(url);){

      Statement stmt = con.createStatement();
      ResultSet res1 = null;
      ResultSet res2 = null;
      String valg = showInputDialog("Skriv inn et ISBN nummer, skriv inn 'hade' for å avslutte");
      while (valg != "hade") {
        res1 = stmt.executeQuery("select forfatter, tittel from boktittel where isbn = '" + valg + "';\nselect count(*) antall from eksemplar where isbn = '" + valg + "';");

        String forfatter = res1.getString("forfatter");
        String tittel = res1.getString("tittel");
        int eksemplarer = res1.getInt("antall");

        showMessageDialog(null, "Forfatteren av denne boka er " + forfatter + ". Tittelen på boka er: " + tittel + ".\n Vi har " + eksemplarer + " eksemplarer av denne");
        valg = showInputDialog("Skriv inn et ISBN nummer, skriv inn 'hade' for å avslutte");
      }
      res1.close();
    }catch(SQLException e){
      System.out.println("SQL feil" + e);
    }
  }
}
