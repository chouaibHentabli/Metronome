package ihm;

import commands.Command;
import controller.Controller;
import engine.Engine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Created by chouaib on 22/12/16.
 */
public class Interface implements IInterface {

    @FXML
    private TextField tempo;
    @FXML
    private Text value;
    @FXML
    private Slider tempoSlider;
    @FXML
    private Rectangle ledtic;
    @FXML
    private Rectangle ledtoc;

    private Controller controleur;
    private Engine engine;
    private Led led;

    //Commandes
    private Command start, stop, inc, dec;

    //Sonor
    private Sonor sonor;

    public void setControleur(Controller c) {
        this.controleur = c;
    }

    @Override
    public void setEngine(Engine e) {
        this.engine = e;
    }

    @Override
    public void init() {
        sonor = new Sonor();
        tempoSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                System.out.println(new_val.doubleValue());

                controleur.setTempo(new_val.intValue() + "");

            }
        });
    }

    @Override
    public void start() {
        start.execute();
    }

    @Override
    public void stop() {
        stop.execute();
    }

    @Override
    public void increment() {
        inc.execute();
    }

    @Override
    public void decrement() {
        dec.execute();
    }

    @Override
    public void setTempoText(int v) {
        this.value.setText(v + "");
    }

    @Override
    public void switchOnTic() {
        led = new SimpleLed(ledtic, Color.LIMEGREEN);
        led.flash();
        System.out.println("Tic");
    }

    @Override
    public void switchOnToc() {
        led = new SimpleLed(ledtoc, Color.BLUE);
        led.flash();
        System.out.println("Toc");
    }

    @Override
    public void updateTempo() {
        tempo.setText(engine.getTempo() + "");
    }

    @Override
    public void setStartCommand(Command commande) {
        start = commande;
    }

    @Override
    public void setStopCommand(Command commande) {
        stop = commande;
    }

    @Override
    public void setIncCommand(Command commande) {
        inc = commande;
    }

    @Override
    public void setDecCommand(Command commande) {
        dec = commande;
    }
}
