package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class MarkTempo implements Command {

    Controller controleur;

    @Override
    public void execute() {
        controleur.MarquerTemps();
    }

    public MarkTempo(Controller controleur) {
        this.controleur = controleur;
    }
}
