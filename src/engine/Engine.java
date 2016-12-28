package engine;

import commands.*;
import controller.Controller;
import horloge.Horloge;

/**
 * Created by chouaib on 22/12/16.
 */
public class Engine implements IEngine {

    //default value 120
    private int Tempo = 120;
    private int measureIndex = 0;
    private Boolean running = false;
    //default value 4
    private int Measure = 4;

    private Controller controller;
    private Horloge horloge;

    public Engine(Controller c) {
        this.controller = c;
        this.horloge = new Horloge();
        measureIndex = Measure;
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
        //horloge.activerApresDelai(tic,getTempo());
        UpdateTempo.execute();
    }


    @Override
    public int getTempsPm() {
        return Measure;
    }

    @Override
    public void setNbTempsPm(int t) {
        Measure = t;
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
            //this.setTempo(Init);
            this.horloge.disable();
            running = false;
        }
    }

    @Override
    public void tic() {
        measureIndex--;
        if (measureIndex < 0) {
            measureIndex = Measure;
            Command command = new MarkMeasure(controller);
            command.execute();
        } else {
            Command command = new MarkTempo(controller);
            command.execute();
        }
    }


}
