import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class MainApp extends Application {

    public Button convertButton, addCurrency;
    public ListView leftLv, rightLv;
    public Label instructionLabel;
    public Label leftLabel, rightLabel;
    public Label belopLabel;
    public TextField belop;
    public Label output;
    public ObservableList rightData, leftData;
    public Stage primaryStage = new Stage();

    public Valuta[] valutaliste = {
            new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
    };

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Hele vinduet kalles i JavaFX for "Stage"
        primaryStage.setTitle("Valutakalkulator - Øving 17");
        GridPane gp = new GridPane();
        gp.setVgap(10);


        // Instruction Label
        instructionLabel = new Label("Velg fravaluta og tilvaluta fra listene");
        instructionLabel.setFont(new Font("arial", 18));
        gp.add(instructionLabel, 0, 0, 4, 1);
        // GridPane.setHalignment(instructionLabel, HPos.CENTER);

        // Left Label
        leftLabel = new Label("Fra valuta");
        leftLabel.setFont(new Font("arial", 15));
        gp.add(leftLabel, 0,1, 2, 1);
        // GridPane.setHalignment(leftLabel, HPos.CENTER);

        // Right Label
        rightLabel = new Label("Til valuta");
        rightLabel.setFont(new Font("arial", 15));
        gp.add(rightLabel, 2, 1, 2, 1);
        // GridPane.setHalignment(rightLabel, HPos.CENTER);

        // Left Listview
        leftData = FXCollections.observableArrayList();
        leftLv = new ListView(leftData);
        for (int i = 0; i < valutaliste.length; i++) {
            leftData.add(valutaliste[i].getValutaNavn());
        }
        leftLv.setPrefHeight(200);
        leftLv.setPrefWidth(150);
        gp.add(leftLv, 0, 2, 2, 4);
        GridPane.setHalignment(leftLv, HPos.CENTER);

        // Right Listview
        rightData = FXCollections.observableArrayList();
        rightLv = new ListView(rightData);
        for (int i = 0; i < valutaliste.length; i++) {
            rightData.add(valutaliste[i].getValutaNavn());
        }
        rightLv.setPrefHeight(200);
        rightLabel.setPrefWidth(150);
        gp.add(rightLv, 2, 2, 2, 4);
        GridPane.setHalignment(rightLv, HPos.CENTER);

        // Beløp label
        belopLabel = new Label("Beløp");
        belopLabel.setFont(new Font("arial", 15));
        gp.add(belopLabel, 0, 6, 1, 1);

        // belop TextFiel
        belop = new TextField();
        gp.add(belop, 1, 6, 4, 1);

        // Convert button
        convertButton = new Button("Convert");
        convertButton.setDefaultButton(true);
        gp.add(convertButton, 0, 7, 2, 1);
        GridPane.setHalignment(convertButton, HPos.CENTER);
        convertButton.setOnAction(e -> {
            String fromName = (String) leftLv.getSelectionModel().getSelectedItem();
            String toName = (String) rightLv.getSelectionModel().getSelectedItem();
            int fromIndex = leftLv.getSelectionModel().getSelectedIndex();
            int toIndex = rightLv.getSelectionModel().getSelectedIndex();

            double amount = Double.parseDouble(belop.getText());
            double newAmount = convert(fromIndex, toIndex, amount);
            newAmount *= 100;
            newAmount = Math.round(newAmount);
            newAmount /= 100;

            output.setText(amount + " " + fromName + " er lik " + newAmount + " " + toName);
        });

        // Add Currency button
        addCurrency = new Button("Ny valuta");
        gp.add(addCurrency, 2, 7, 2, 1);
        GridPane.setHalignment(addCurrency, HPos.CENTER);
        addCurrency.setOnAction(e -> {
            leggTilValuta();
        });

        // Output Label
        output = new Label("");
        output.setFont(new Font("arial", 13));
        gp.add(output, 0, 8, 4, 1);


        // Det som er inne i vinduet kalles for "Scene"
        // Det er her knapper og funksjonalitet legges
        Scene scene = new Scene(gp, 290, 360);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public double convert(int indexFrom, int indexTo, double amount) {
        double kursFrom = valutaliste[leftLv.getSelectionModel().getSelectedIndex()].getKurs();
        double kursTo = valutaliste[rightLv.getSelectionModel().getSelectedIndex()].getKurs();
        int enhetFrom = valutaliste[leftLv.getSelectionModel().getSelectedIndex()].getEnhet();
        int enhetTo = valutaliste[rightLv.getSelectionModel().getSelectedIndex()].getEnhet();

        double fromToNok = 0;
        if (enhetFrom == 1) {
            fromToNok = kursFrom * amount;
        } else {
            fromToNok = (kursFrom / 100) * amount;
        }
        double nokToAfer = 0;
        if (enhetTo == 1) {
            nokToAfer = fromToNok / kursTo;
        } else {
            nokToAfer = (100 / kursTo) * fromToNok;
        }
        return nokToAfer;
    }

    public void leggTilValuta() {
        Stage nyValuta = new Stage();
        nyValuta.setTitle("Legg til valuta");
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setVgap(10);
        gp.setHgap(5);

        // Label navn
        Label name = new Label("Navn");
        gp.add(name, 0, 0, 1, 1);

        // navn text field
        TextField enterName = new TextField();
        gp.add(enterName, 1, 0, 3, 1);

        // Label kurs
        Label kurs = new Label("Kurs");
        gp.add(kurs, 0, 1, 1, 1);

        // navn text field
        TextField enterKurs = new TextField();
        gp.add(enterKurs, 1, 1, 3, 1);

        // Label enhet
        Label enhet = new Label("Enhet");
        gp.add(enhet, 0, 2, 1, 1);

        // enhet text field
        TextField enterenhet = new TextField();
        gp.add(enterenhet, 1, 2, 3, 1);

        // Legg til button
        Button leggTil = new Button("Legg til");
        leggTil.setPrefWidth(200);
        leggTil.setDefaultButton(true);
        gp.add(leggTil, 0, 3, 4,1);
        GridPane.setHalignment(leggTil, HPos.CENTER);
        leggTil.setOnAction(e -> {
            String navn = enterName.getText();
            double nykurs = Double.parseDouble(enterKurs.getText());
            int nyenhet = Integer.parseInt(enterenhet.getText());
            utvidTabell();
            valutaliste[valutaliste.length - 1] = new Valuta(navn, nykurs, nyenhet);
            leftLv.refresh();
            rightLv.refresh();
            try {
                start(primaryStage);
            } catch(Exception er) {
                er.printStackTrace();
            }
            nyValuta.close();
        });


        Scene scene = new Scene(gp, 250, 160);
        nyValuta.setScene(scene);
        nyValuta.show();
    }

    private void utvidTabell() {
        Valuta[] nyTabell = new Valuta[valutaliste.length + 1];
        for (int i = 0; i < valutaliste.length; i++){
            nyTabell[i] = valutaliste[i];
        }
        valutaliste = nyTabell;
    }
}
