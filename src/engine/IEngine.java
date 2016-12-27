package engine;

/**
 * Created by chouaib on 22/12/16.
 */
public interface IEngine {

    /**
     * @return Flapping by minute
     */
    int getTempo();

    /**
     * @param t Flapping by minute
     */
    void setTempo(int t);

    /**
     * @return Time number by measure
     */
    int getTempsPm();

    /**
     * @param t Time number by measure
     */
    void setNbTempsPm(int t);

    /**
     * @return Engine state
     */
    Boolean getRunning();

    /**
     * @param m Engine state
     */
    void setRunning(Boolean m);

    /**
     * Manage event of the clock
     */
    void tic();

}
