package commands;


import ihm.Sonor;

/**
 * Created by chouaib on 22/12/16.
 */
public class sonorTic implements Command {
    private Sonor sonor;

    public sonorTic(Sonor sonor) {
        this.sonor = sonor;
    }

    @Override
    public void execute() {
        sonor.playSound("/tick.wav");
    }
}
