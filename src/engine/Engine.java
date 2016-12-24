package engine;

import commands.*;
import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class Engine implements IEngine {
    Controller controleur;
    //Horloge horloge;
    int Tempo = 120;
    int index_messure = 0;
    Boolean enMarche = false;
    int Messure = 4;

    public Engine(Controller c) {
        this.controleur = c;
       // horloge = new HorlogeImpl();
        index_messure = Messure;
    }

    @Override
    public int getTempo() {
        return Tempo;
    }

    @Override
    public void setTempo(int t) {
        Command tic = new Tic(this);
        Command UpdateTempo = new updateTempo(controleur);
        this.Tempo = t;
        if (getEnMarche()) {
            horloge.desactiver();
            horloge.activerPeriodiquement(tic, getPeriodMSFromBPM(getTempo()));
        }
        //horloge.activerApresDelai(tic,getTempo());
        UpdateTempo.execute();
    }


    @Override
    public int getTempsPm() {
        return Messure;
    }

    @Override
    public void setNbTempsPm(int t) {
        Messure = t;
    }

    @Override
    public Boolean getEnMarche() {
        return enMarche;
    }

    @Override
    public void setEnMarche(Boolean m) {
        System.out.println("Engine on : " + m);
        if (m) {
            Command tic = new Tic(this);
            this.horloge.activerPeriodiquement(tic, getPeriodMSFromBPM(getTempo()));
            enMarche = true;
        } else {
            //this.setTempo(Init);
            this.horloge.desactiver();
            enMarche = false;
        }
    }

    @Override
    public void tic() {
        index_messure--;
        if (index_messure == 0) {
            index_messure = Messure;
            Command command = new MarkMeasure(controleur);
            command.execute();
        } else {
            Command command = new MarkTempo(controleur);
            command.execute();
        }
    }

    /**
     * @param bpm Battement par minute
     * @return Battement par milliseconde
     */
    private Long getPeriodMSFromBPM(int bpm) {
        float periodMinute = 1.0f / Float.valueOf(bpm);
        Long periodMS = Long.valueOf((int) (periodMinute * 60 * 1000));
        return periodMS;
    }

}
