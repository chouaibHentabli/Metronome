package commands;

import ihm.Sonor;

/**
 * Created by chouaib on 22/12/16.
 */
public class SonorToc implements Command {
    private String pathMedia = "/home/chouaib/IdeaProjects/metronome/src/resources/toc.wav";
    private Sonor sonor;

    public SonorToc(Sonor sonor) {
        this.sonor = sonor;
    }

    @Override
    public void execute() {
        sonor.playSound(pathMedia);
    }

}
