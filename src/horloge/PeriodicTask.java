package horloge;

import commands.Command;

import java.util.TimerTask;

/**
 * Created by chouaib on 22/12/16.
 */
public class PeriodicTask extends TimerTask {

    private Command commande;

    @Override
    public void run() {
        commande.execute();
    }

    public PeriodicTask(Command c) {
        super();
        commande = c;
    }
}
