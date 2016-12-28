package main;

import commands.Decrement;
import commands.Increment;
import commands.Start;
import commands.Stop;
import controller.Controller;
import ihm.Interface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/resources/sample.fxml").openStream());
        Interface view = loader.getController();

        Controller controleur = new Controller();
        controleur.setIhm(view);
        view.setControleur(controleur);
        view.init();

        view.setStartCommand(new Start(controleur));
        view.setStopCommand(new Stop(controleur));
        view.setIncCommand(new Increment(controleur));
        view.setDecCommand(new Decrement(controleur));
        primaryStage.setTitle("Metronome");
        primaryStage.setScene(new Scene(root, 536, 333));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        //new ihmImpl(new ControleurImpl());

    }
}
