package ihm;

import commands.Command;
import controller.Controller;
import engine.Engine;

/**
 * Created by chouaib on 22/12/16.
 */
public interface IInterface {

    /**
     * @param c Controlleur
     */
    public void setControleur(Controller c);

    /**
     * Moteur
     *
     * @param e
     */
    public void setMoteur(Engine e);

    /**
     * Initialiser la configuration de la vue
     */
    public void init();

    /**
     * Acitver le moteur
     */
    public void start();

    /**
     * Arrêter le moteur
     */
    public void stop();

    /**
     * Incrémenter la mésure
     */
    public void increment();

    /**
     * Décrementer la mésure
     */
    public void decrement();

    /**
     * @param v Battement par mésure
     */
    public void setTempoText(int v);

    /**
     * Allumer led tempo
     */
    public void allumeTic();

    /**
     * Allumer led messure
     */
    public void allumeToc();

    /**
     * Mise à jour le tempo sur la vue
     */
    public void updateTempo();

    /**
     * @param commande Commande start
     */
    public void setStartCommande(Command commande);

    /**
     * @param commande Commande stop
     */
    public void setStopCommande(Command commande);

    /**
     * @param commande Commande incremente
     */
    public void setIncCommande(Command commande);

    /**
     * @param commande Commande decremente
     */
    public void setDecCommande(Command commande);

}
