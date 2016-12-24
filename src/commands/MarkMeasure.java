package commands;


import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class MarkMeasure implements Command {
    Controller controleur ;
    @Override
    public void execute() {
        controleur.MarquerMesure();
    }
    public MarkMeasure(Controller c){
        this.controleur=c;
    }
}
