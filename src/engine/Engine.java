package engine;

import commands.*;
import controller.Controller;
import horloge.Horloge;

import java.util.Observable;

/**
 * Created by chouaib on 22/12/16.
 */
public class Engine extends Observable implements IEngine {

    //default value 120
    private int Tempo = 120;
    private int measureIndex = 0;
    private Boolean running = false;
    //default value 4
    private int measure = 4;

    private Controller controller;
    private Horloge horloge;

    public Engine(Controller c) {
        this.controller = c;
        this.horloge = new Horloge();
        measureIndex = measure;
    }


    /**
     * @param bpm Flapping by minute
     * @return Flapping by milliseconde
     */
    private Long getPeriodMSFromBPM(int bpm) {
        float periodMinute = 1.0f / Float.valueOf(bpm);
        Long periodMS = Long.valueOf((int) (periodMinute * 60 * 1000));
        return periodMS;
    }

    @Override
    public int getTempo() {
        return Tempo;
    }

    @Override
    public void setTempo(int t) {
        Command tic = new Tic(controller);
        Command UpdateTempo = new updateTempo(controller);
        this.Tempo = t;
        if (getRunning()) {
            horloge.disable();
            horloge.activatePeriodically(tic, getPeriodMSFromBPM(getTempo()));
        }

        UpdateTempo.execute();
    }


    @Override
    public int getTempsPm() {
        return measure;
    }

    @Override
    public void setNbTempsPm(int t) {
        measure = t;
    }

    @Override
    public Boolean getRunning() {
        return running;
    }

    @Override
    public void setRunning(Boolean m) {
        System.out.println("Engine running: " + m);
        if (m) {
            Command tic = new Tic(controller);
            this.horloge.activatePeriodically(tic, getPeriodMSFromBPM(getTempo()));
            running = true;
        } else {
            this.horloge.disable();
            running = false;
        }
    }

    @Override
    public void tic() {
        measureIndex--;
        if (measureIndex < 0) {
            measureIndex = measure;
            Command command = new MarkMeasure(controller);
            command.execute();
        } else {
            Command command = new MarkTempo(controller);
            command.execute();
        }
    }


}
