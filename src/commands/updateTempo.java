package commands;


import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class updateTempo implements Command {
    Controller controleur;
    @Override
    public void execute() {
        controleur.updateTempo();
    }
    public updateTempo(Controller c){
        this.controleur=c;
    }
}
