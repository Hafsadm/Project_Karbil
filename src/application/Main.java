package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // ----- TITRE -----
        Label title = new Label("Dashboard Utilisateur");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        // ----- MENU -----
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("Fichier");
        Menu menuEdit = new Menu("Éditer");
        Menu menuHelp = new Menu("Aide");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

        // ----- FORMULAIRE -----
        Label lblNom = new Label("Nom :");
        TextField txtNom = new TextField();

        Label lblEmail = new Label("Email :");
        TextField txtEmail = new TextField();

        Label lblAge = new Label("Âge :");
        TextField txtAge = new TextField();

        Button btnValider = new Button("Valider");
        Button btnEffacer = new Button("Effacer");

        VBox form = new VBox(10, lblNom, txtNom, lblEmail, txtEmail, lblAge, txtAge, btnValider, btnEffacer);
        form.setPadding(new Insets(20));
        form.setStyle("-fx-background-color: #f5f5f5;");
        form.setPrefWidth(250);

        // ----- ZONE INFO -----
        Label info = new Label("Informations système :\nAucun message.");
        info.setStyle("-fx-border-color: gray; -fx-padding: 10; -fx-background-color: white;");

        // ----- TABLEAU -----
        TableView<String> table = new TableView<>();
        TableColumn<String, String> col1 = new TableColumn<>("Utilisateur");
        col1.setPrefWidth(200);
        table.getColumns().add(col1);

        ObservableList<String> data = FXCollections.observableArrayList("Alice", "Bob", "Charlie");
        table.setItems(data);

        // ----- CENTER : TABLE + INFO -----
        VBox centerBox = new VBox(20, table, info);
        centerBox.setPadding(new Insets(20));

        // ----- PIED DE PAGE -----
        Label footer = new Label("© 2025 Application Hafsa JavaFX – Tous droits réservés.");
        footer.setPadding(new Insets(10));
        footer.setAlignment(Pos.CENTER);

        // ----- LAYOUT PRINCIPAL -----
        BorderPane root = new BorderPane();
        root.setTop(new VBox(menuBar, title));
        root.setLeft(form);
        root.setCenter(centerBox);
        root.setBottom(footer);

        // ----- ACTIONS -----
        btnValider.setOnAction(e -> {
            String message = "Nom: " + txtNom.getText() +
                             "\nEmail: " + txtEmail.getText() +
                             "\nÂge: " + txtAge.getText();
            info.setText("Informations système :\n" + message);
        });

        btnEffacer.setOnAction(e -> {
            txtNom.clear();
            txtEmail.clear();
            txtAge.clear();
            info.setText("Informations système :\nChamps effacés.");
        });

        // ----- SCENE -----
        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Interface JavaFX Complète");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
