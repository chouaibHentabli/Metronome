package engine;

/**
 * Created by chouaib on 22/12/16.
 */
public interface IEngine {

    /**
     * @return Battement par minute
     */
    int getTempo();

    /**
     * @param t Battement par minute
     */
    void setTempo(int t);

    /**
     * @return Nombre de temps par mésure
     */
    int getTempsPm();

    /**
     * @param t Nombre de temps par mésure
     */
    void setNbTempsPm(int t);

    /**
     * @return Etat du moteur
     */
    Boolean getEnMarche();

    /**
     * @param m Etat moteur
     */
    void setEnMarche(Boolean m);

    /**
     * gére les événement de l'horloge
     */
    void tic();

}
