package logika;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("okno.fxml"));
        BorderPane root = (BorderPane) loader.load();
        Scene scene = new Scene(root,750,530);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Mapa kvíz");
        primaryStage.show();

        Controller c = loader.getController();

        Hra hra = new Hra();

        c.inicializuj(hra);
    }

    public static void main(String[] args) {
        Hra hra = new Hra();
        launch(args);
    }
}
