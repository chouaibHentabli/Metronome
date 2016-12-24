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
import javafx.scene.text.Text;

/**
 * Created by chouaib on 22/12/16.
 */
public class Interface implements IInterface {

    @FXML
    TextField tempo;
    @FXML
    Text value;
    @FXML
    Slider tempoSlider;
    @FXML
    javafx.scene.shape.Rectangle ledtic;
    @FXML
    javafx.scene.shape.Rectangle ledtoc;
    private Controller controleur;
    private Engine engine;
    Led led;
    //Commandes
    Command start, stop, inc, dec;

    //Sonor
    Sonor sonor;

    public void setControleur(Controller c) {
        this.controleur = c;
    }

    @Override
    public void setMoteur(Engine e) {
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
    public void allumeTic() {

        led = new SimpleLed(ledtic, Color.STEELBLUE);
        led.flash();
        System.out.println("Tic");
    }

    @Override
    public void allumeToc() {
        led = new SimpleLed(ledtoc, Color.ORANGERED);
        led.flash();
        System.out.println("Toc");
    }

    @Override
    public void updateTempo() {
        tempo.setText(engine.getTempo() + "");
    }

    @Override
    public void setStartCommande(Command commande) {
        start = commande;
    }

    @Override
    public void setStopCommande(Command commande) {
        stop = commande;
    }

    @Override
    public void setIncCommande(Command commande) {
        inc = commande;
    }

    @Override
    public void setDecCommande(Command commande) {
        dec = commande;
    }
}
