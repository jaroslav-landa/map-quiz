package logika;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @FXML ImageView mapa;
    @FXML Button novahra;
    @FXML Label mesto;
    @FXML Label skore;
    private Hra hra;

    public Controller() {
    }

    @FXML
    public void novaHra() {
        hra.vynulujVsechno();
    }

    @FXML
    public void inicializuj(Hra hra) {
        this.hra = hra;
        this.hra.addObserver(this);
        this.hra.hrajKolo();
        mapa.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("X " + event.getX() + ", Y " + event.getY());

                hra.prepocitejSkore(event.getX(), event.getY());
                hra.hrajKolo();

                event.consume();
            }
        });
        update(null, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        skore.setText(this.hra.getSkore() + "");
        mesto.setText(this.hra.getAktualni().toString());
    }
}
