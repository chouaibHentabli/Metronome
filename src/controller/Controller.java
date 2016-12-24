package controller;

import engine.Engine;
import ihm.IInterface;
import ihm.Interface;

import java.util.Observable;

public class Controller {

    Engine engine;
    //ihm view;
    IInterface view;

    public ControleurImpl() {
        engine = new Engine(this);

    }

    public void setView(Interface v) {
        view = v;
        view.setMoteur(moteur);
        //Thread t=new Thread((Interface)view);
        //t.start();
    }

    @Override
    public void MarquerMesure() {
        if (view != null)
            view.allumeToc();
    }

    @Override
    public void MarquerTemps() {
        if (view != null)
            view.allumeTic();
    }

    @Override
    public void IncrementerMesure() {
        if (moteur.getTempsPm() < 7) {
            moteur.setNbTempsPm(moteur.getTempsPm() + 1);
        }
        System.out.println("nombre messure " + moteur.getTempsPm());
    }

    @Override
    public void decrementerMesure() {
        if (moteur.getTempsPm() > 2) {
            moteur.setNbTempsPm(moteur.getTempsPm() - 1);
        }
        System.out.println("nombre messure " + moteur.getTempsPm());
    }

    @Override
    public void updateTempo() {
        if (view != null)
            view.updateTempo();
    }

    @Override
    public void start() {
        if (!moteur.getEnMarche()) {
            moteur.setEnMarche(true);
        }
    }

    @Override
    public void stop() {
        if (moteur.getEnMarche()) {
            moteur.setEnMarche(false);
        }
    }

    @Override
    public void setTempo(String value) {
        int temp;
        temp = Integer.parseInt(value);
        moteur.setTempo(temp);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public Moteur getMoteur() {
        return moteur;
    }
}
