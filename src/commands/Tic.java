package commands;

import Moteur.Moteur;

/**
 * Created by chouaib on 22/12/16.
 */
public class Tic implements Command {

    Moteur moteur;
    public Tic(Moteur m){
        this.moteur=m;
    }
    @Override
    public void execute() {
        moteur.tic();
    }
}
