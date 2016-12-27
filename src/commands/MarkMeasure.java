package commands;


import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class MarkMeasure implements Command {
    private Controller controleur;

    @Override
    public void execute() {
        controleur.MarkMeasure();
    }

    public MarkMeasure(Controller c) {
        this.controleur = c;
    }
}
