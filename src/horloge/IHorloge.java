package horloge;

import commands.Command;

/**
 * Created by chouaib on 22/12/16.
 */
public interface IHorloge {
    void activateAfterDelay(Command cmd, long delaiInSecondes);
    void activatePeriodically(Command cmd, long periodInSecondes);
    void disable();
}
