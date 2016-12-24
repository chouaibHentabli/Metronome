package horloge;

import commands.Command;

import java.util.Timer;

/**
 * Created by chouaib on 22/12/16.
 */
public class Horloge implements IHorloge{

    Timer timer;

    @Override
    public void activateAfterDelay(Command cmd, long delaiEnSecondes) {

    }

    @Override
    public void activatePeriodically(Command cmd, long periodEnSecondes) {
        timer = new Timer();
        PeriodicTask task = new PeriodicTask(cmd);
        //long tempsMillisecondes = this.tempsEnMilliSecondes(periodEnSecondes);
        //System.out.println(tempsMillisecondes);
        timer.schedule(task, 0, periodEnSecondes);
    }

    @Override
    public void disable() {
        timer.cancel();
        timer.purge();
    }

    /**
     * Renvoi le temps "tempsEnSeconde" en milli secondes
     *
     * @param tempsEnSeconde
     * @return
     */
    private long tempsEnMilliSecondes(float tempsEnSeconde) {
        return (long) (1000 * tempsEnSeconde);
    }
}