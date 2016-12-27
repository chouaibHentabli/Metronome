package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class MarkTempo implements Command {

    private Controller controleur;

    @Override
    public void execute() {
        controleur.MarkTemps();
    }

    public MarkTempo(Controller controleur) {
        this.controleur = controleur;
    }
}
